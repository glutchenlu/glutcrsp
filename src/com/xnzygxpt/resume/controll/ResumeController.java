package com.xnzygxpt.resume.controll;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.resume.dao.vo.Resume;
import com.xnzygxpt.resume.service.ResumeService;

@Controller
@RequestMapping("/resume")
public class ResumeController {

	@Autowired
	private ResumeService resumeservice;

	@RequestMapping(value = "/add", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView add(Resume resume) {
		ModelAndView modelView = new ModelAndView();
		Map<String, String> resultMap = resumeservice.add(resume);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/check", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView check(Resume resume) {
		ModelAndView modelView = new ModelAndView();
		Map<String, String> resultMap = resumeservice.check(resume);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/querybyuser", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView querybyuser(Resume resume) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = resumeservice.querybyuser(resume);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/querybyid", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView querybyid(Resume resume) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = resumeservice.querybyid(resume);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/update", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView update(Resume resume) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = resumeservice.update(resume);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/del", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView del(Resume resume) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = resumeservice.del(resume.getResumeid());
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
