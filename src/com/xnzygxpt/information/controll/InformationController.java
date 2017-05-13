package com.xnzygxpt.information.controll;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.information.service.InformationService;

@Controller
@RequestMapping("/information")
public class InformationController {

	@Autowired
	private InformationService informationservice;

	@RequestMapping(value = "/queryclass", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView queryByClass(String classify) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = informationservice
				.queryByClass(classify);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

}
