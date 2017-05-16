package com.xnzygxpt.basic.controll;

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

import com.xnzygxpt.basic.dao.vo.Basic;
import com.xnzygxpt.basic.service.BasicService;

@Controller
@RequestMapping("/basic")
public class BasicController {

	@Autowired
	private BasicService basicservice;

	@RequestMapping(value = "/findbyid", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView findbyid(Basic basic) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = basicservice.findbyid(basic);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView upload(
			@RequestParam("photo") CommonsMultipartFile multiFiles,
			HttpServletRequest request) throws IllegalStateException,
			IOException {
		ModelAndView modelView = new ModelAndView();
		String savePath = request.getSession().getServletContext()
				.getRealPath("updata/upimage/basic");
		Map<String, String> resultMap = basicservice.upload(multiFiles,
				savePath);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/update", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView update(Basic basic) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = basicservice.update(basic);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/updateschool", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView updateschool(Basic basic) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = basicservice.updateschool(basic);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
