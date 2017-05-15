package com.xnzygxpt.xuser.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.basic.dao.vo.Basic;
import com.xnzygxpt.basic.service.BasicImpl;
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
	public Map<String, String> register(XUser xuser) {
		Map<String, String> hmap = new HashMap<String, String>();
		int returnCode = 0;
		System.out.println("userid:" + xuser.getUserid());
		String returnString = "帐号已经存在！";
		if (xuser.getUserid() != null && !"".equals(xuser.getUserid())) {
			XUser localUser = userImpl.queryByID(xuser.getUserid());
			if (localUser != null) {
				System.out.println("帐号已经存在！");
			} else {
				userImpl.add(xuser);
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
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			xuser = userImpl.queryByID(userid);
			basic = basicImpl.queryByID(xuser.getBasicid());
			beanMap.put("user", xuser);
			beanMap.put("basic", basic);
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
}
