package com.xnzygxpt.xuser.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.basic.dao.vo.Basic;
import com.xnzygxpt.basic.service.BasicImpl;
import com.xnzygxpt.company.dao.vo.Company;
import com.xnzygxpt.company.service.CompanyImpl;
import com.xnzygxpt.courier.service.CourierImpl;
import com.xnzygxpt.dating.dao.vo.Dating;
import com.xnzygxpt.dating.service.DatingImpl;
import com.xnzygxpt.goods.service.GoodsImpl;
import com.xnzygxpt.information.service.InformationImpl;
import com.xnzygxpt.learning_data.service.LearningDataImpl;
import com.xnzygxpt.resume.service.ResumeImpl;
import com.xnzygxpt.second_goods.service.SecondGoodsImpl;
import com.xnzygxpt.setting.dao.vo.Setting;
import com.xnzygxpt.setting.service.SettingImpl;
import com.xnzygxpt.train_ticket.service.TrainTicketImpl;
import com.xnzygxpt.work.dao.vo.Work;
import com.xnzygxpt.work.service.WorkImpl;
import com.xnzygxpt.xuser.dao.vo.XUser;

/**
 * 逻辑业务操作
 * 
 * @author Administrator
 *
 */
@Service
public class XUserService {
	@Autowired
	private XUserImpl userImpl;

	@Autowired
	private BasicImpl basicImpl;
	@Autowired
	private SettingImpl settingImpl;
	@Autowired
	private DatingImpl datingImpl;
	@Autowired
	private GoodsImpl goodsImpl;
	@Autowired
	private SecondGoodsImpl secondGoodsImpl;
	@Autowired
	private InformationImpl informationImpl;
	@Autowired
	private TrainTicketImpl trainTicketImpl;
	@Autowired
	private WorkImpl workImpl;
	@Autowired
	private CourierImpl courierImpl;
	@Autowired
	private LearningDataImpl learningDataImpl;
	@Autowired
	private CompanyImpl companyImpl;
	@Autowired
	private ResumeImpl resumeImpl;

	/**
	 * 登录
	 * 
	 * @param xuser
	 *            登录用户的信息
	 * @return 执行信息
	 */
	public Map<String, Object> login(XUser xuser) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		XUser localUser = userImpl.queryByID(xuser.getUserid());
		// returnCode 0不通过，1通过
		int returnCode = 0;
		System.out.println("userid:" + xuser.getUserid());
		String returnString = "帐号不存在！";
		if (localUser != null) {
			if (xuser.getPassword().equals(localUser.getPassword())) {
				System.out.println("登录成功！");
				returnCode = 1;
				returnString = "登录成功！";
			} else {
				System.out.println("帐号密码不匹配！");
				returnString = "帐号密码不匹配";
			}
		} else {
			System.out.println("帐号不存在！");
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("resultUser", localUser);
		return hmap;
	}

	/**
	 * 注册
	 * 
	 * @param xuser
	 *            注册用户的信息
	 * @return 执行信息
	 */
	public Map<String, Object> register(XUser xuser) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		int returnCode = 0;
		System.out.println("userid:" + xuser.getUserid());
		String returnString = "帐号已经存在！";
		XUser localUser = userImpl.queryByID(xuser.getUserid());
		if (xuser.getUserid() != null && !"".equals(xuser.getUserid())) {
			if (localUser != null) {
				System.out.println("帐号已经存在！");
			} else {
				localUser = userImpl.add(xuser);
				hmap.put("returnUser", localUser);
				returnCode = 1;
				returnString = "注册成功！";
			}
		} else {
			returnString = "输入的帐号为空！";
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		return hmap;
	}

	/**
	 * 根据ID查询User和对应的Basic
	 * 
	 * @param userid
	 *            用户ID
	 * @return
	 */
	public Map<String, Object> findbyid(String userid) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		Map<String, Object> beanMap = new HashMap<String, Object>();
		XUser xuser = new XUser();
		Basic basic = new Basic();
		Setting setting = new Setting();
		Dating dating = new Dating();
		int count = 0;
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			xuser = userImpl.queryByID(userid);
			basic = basicImpl.queryByID(xuser.getBasicid());
			setting = settingImpl.queryByID(xuser.getSettingid());
			dating = datingImpl.queryByID(xuser.getDatingid());
			count = resumeImpl.check(userid);

			beanMap.put("user", xuser);
			beanMap.put("basic", basic);
			beanMap.put("setting", setting);
			beanMap.put("dating", dating);
			beanMap.put("count", count);
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("returnBean", beanMap);
		return hmap;
	}

	public Map<String, Object> userFabu(String userid) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			List<Work> wlist = workImpl.querybyuserid(userid);
			List<Company> clist = new ArrayList<Company>();

			for (Work work : wlist) {
				Company company = new Company();
				company = companyImpl.queryByName(work.getSource());
				clist.add(company);
			}

			listMap.put("goods", goodsImpl.querybyuserid(userid));
			listMap.put("secondGoods", secondGoodsImpl.querybyuserid(userid));
			listMap.put("information", informationImpl.querybyuserid(userid));
			listMap.put("trainTicket", trainTicketImpl.querybyuserid(userid));
			listMap.put("work", wlist);
			listMap.put("company", clist);
			listMap.put("courier", courierImpl.querybyuserid(userid));
			listMap.put("learningData", learningDataImpl.querybyuserid(userid));

			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("returnBean", listMap);
		return hmap;
	}
}
