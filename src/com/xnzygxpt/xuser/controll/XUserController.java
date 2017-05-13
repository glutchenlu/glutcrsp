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

	@RequestMapping(value = "/login", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView login(XUser xuser) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = userService.login(xuser);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/register", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView register(XUser xuser) {
		ModelAndView modelView = new ModelAndView();
		Map<String, String> resultMap = userService.register(xuser);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
