package com.xnzygxpt.work.controll;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.work.dao.vo.Work;
import com.xnzygxpt.work.service.WorkService;

@Controller
@RequestMapping("/work")
public class WorkController {

	@Autowired
	private WorkService workservice;

	@RequestMapping(value = "/addWork", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView login(Work work) {
		ModelAndView modelView = new ModelAndView();
		Map<String, String> resultMap = workservice.addWork(work);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/querybyindustry", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView queryByIndustry(String industry)
			throws UnsupportedEncodingException {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = workservice.queryByIndustry(industry);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
