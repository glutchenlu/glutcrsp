package com.xnzygxpt.webchar.controll;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.webchar.dao.vo.WebChar;
import com.xnzygxpt.webchar.service.WebCharService;

@Controller
@RequestMapping("/webchar")
public class WebCharController {
	@Autowired
	private WebCharService webCharService;

	@RequestMapping(value = "/add", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView add(WebChar webChar) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = webCharService.add(webChar);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/querybyinfo", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView querybyinfo(int informationid) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = webCharService
				.querybyinfo(informationid);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
