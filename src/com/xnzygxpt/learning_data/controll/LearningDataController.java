package com.xnzygxpt.learning_data.controll;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.learning_data.dao.vo.LearningData;
import com.xnzygxpt.learning_data.service.LearningDataService;

@Controller
@RequestMapping("/learningdata")
public class LearningDataController {

	@Autowired
	private LearningDataService learningDataservice;

	@RequestMapping(value = "/queryclass", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView queryByClass(LearningData classify) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = learningDataservice
				.queryByClass(classify);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

}
