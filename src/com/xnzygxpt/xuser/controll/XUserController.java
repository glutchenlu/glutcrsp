package com.xnzygxpt.xuser.controll;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.xuser.dao.vo.XUser;
import com.xnzygxpt.xuser.service.XUserService;

@Controller
@RequestMapping("/user")
public class XUserController {
	@Autowired
	private XUserService userService;

	/**
	 * 登录
	 * 
	 * @param xuser
	 * @return
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView login(XUser xuser) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = userService.login(xuser);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	/**
	 * 注册
	 * 
	 * @param xuser
	 * @return
	 */
	@RequestMapping(value = "/register", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView register(XUser xuser) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = userService.register(xuser);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	/**
	 * 查询用户信息
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "/findbyid", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView findbyid(String userid) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = userService.findbyid(userid);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/userfabu", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView userFabu(String userid) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = userService.userFabu(userid);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/modify", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView modify(String userid, String newpassword,
			String password) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = userService.modify(userid, password,
				newpassword);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
