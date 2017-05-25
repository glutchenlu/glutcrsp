package com.xnzygxpt.xuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.basic.dao.vo.Basic;
import com.xnzygxpt.basic.service.BasicImpl;
import com.xnzygxpt.dating.dao.vo.Dating;
import com.xnzygxpt.dating.service.DatingImpl;
import com.xnzygxpt.setting.dao.vo.Setting;
import com.xnzygxpt.setting.service.SettingImpl;
import com.xnzygxpt.xuser.dao.dao.XUserMapper;
import com.xnzygxpt.xuser.dao.vo.XUser;

/**
 * mapping实现类
 * 
 * @author Administrator
 *
 */
@Service
public class XUserImpl {
	@Autowired
	private XUserMapper xuserMapper;
	@Autowired
	private BasicImpl basicService;
	@Autowired
	private DatingImpl datingService;
	@Autowired
	private SettingImpl settingService;

	/**
	 * 根据ID获取对象
	 * 
	 * @param userid
	 *            id
	 * @return
	 */
	public XUser queryByID(String userid) {
		return xuserMapper.queryByID(userid);
	}

	/**
	 * 添加用户
	 * 
	 * @param p
	 *            所添加用户的基本信息对象
	 * @return 成功添加后的用户信息对象
	 */
	@Transactional
	public XUser add(XUser p) {
		Basic basic = new Basic();
		Dating dating = new Dating();
		Setting setting = new Setting();
		// basic.setUserid(p.getUserid());
		// setting.setUserid(p.getUserid());
		basicService.add(basic);
		datingService.add(dating);
		settingService.add(setting);
		p.setBasicid(basic.getBasicid());
		p.setDatingid(dating.getDating());
		p.setSettingid(setting.getSettingid());
		xuserMapper.add(p);
		return p;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param p
	 *            所更新用户的基本信息对象
	 * @return 所更新用户的基本信息对象
	 */
	@Transactional
	public int updateStatus(XUser p) {
		return xuserMapper.updateStatus(p);
	}

	@Transactional
	public void modify(XUser p) {
		xuserMapper.modify(p);
	}
}
