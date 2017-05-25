package com.xnzygxpt.learning_data.controll;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
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

	@RequestMapping(value = "/queryByID", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView queryByID(int learning_dataid) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = learningDataservice
				.queryByID(learning_dataid);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView upload(
			@RequestParam("photo") CommonsMultipartFile[] multiFiles,
			HttpServletRequest request) throws IllegalStateException,
			IOException {
		ModelAndView modelView = new ModelAndView();
		String savePath = request.getSession().getServletContext()
				.getRealPath("updata/upimage/learningdata");
		Map<String, String> resultMap = learningDataservice.upload(multiFiles,
				savePath);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/add", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView add(LearningData learningData) {
		ModelAndView modelView = new ModelAndView();
		Map<String, String> resultMap = learningDataservice.add(learningData);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
