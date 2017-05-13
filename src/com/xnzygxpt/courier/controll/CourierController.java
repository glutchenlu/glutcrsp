package com.xnzygxpt.courier.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xnzygxpt.courier.service.CourierImpl;

@Controller
public class CourierController {

	@Autowired
	private CourierImpl courierservice;
	
	
}
