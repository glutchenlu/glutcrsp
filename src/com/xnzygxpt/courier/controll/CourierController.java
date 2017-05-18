package com.xnzygxpt.courier.controll;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.courier.dao.vo.Courier;
import com.xnzygxpt.courier.service.CourierService;

@Controller
@RequestMapping("/courier")
public class CourierController {

	@Autowired
	private CourierService courierservice;

	@RequestMapping(value = "/add", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView add(Courier courier) {
		ModelAndView modelView = new ModelAndView();
		Map<String, String> resultMap = courierservice.add(courier);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/querybyschool", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView querybyschool(Courier courier) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = courierservice.queryBySchool(courier);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
