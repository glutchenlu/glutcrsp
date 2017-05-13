package com.xnzygxpt.company.controll;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.company.dao.vo.Company;
import com.xnzygxpt.company.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyservice;

	@RequestMapping(value = "/addCompany", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView add(Company company) {
		ModelAndView modelView = new ModelAndView();
		Map<String, String> resultMap = companyservice.addCompany(company);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/checkCompany", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView check(Company company) {
		ModelAndView modelView = new ModelAndView();
		Map<String, String> resultMap = companyservice.checkCompany(company
				.getCompanyname());
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

}
