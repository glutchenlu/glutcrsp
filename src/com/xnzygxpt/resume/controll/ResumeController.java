package com.xnzygxpt.resume.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xnzygxpt.resume.service.ResumeImpl;

@Controller
public class ResumeController {

	@Autowired
	private ResumeImpl resumeservice;
	
	
}
