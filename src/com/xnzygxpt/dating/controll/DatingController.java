package com.xnzygxpt.dating.controll;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.dating.dao.vo.Dating;
import com.xnzygxpt.dating.service.DatingService;

@Controller
@RequestMapping("/dating")
public class DatingController {

	@Autowired
	private DatingService datingservice;

	@RequestMapping(value = "/findbyid", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView add(Dating dating) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = datingservice.findbyid(dating);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/update", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView update(Dating dating) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = datingservice.update(dating);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

}
