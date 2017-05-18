package com.xnzygxpt.train_ticket.controll;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.train_ticket.dao.vo.TrainTicket;
import com.xnzygxpt.train_ticket.service.TrainTicketService;

@Controller
@RequestMapping("/trainticket")
public class TrainTicketController {

	@Autowired
	private TrainTicketService trainTicketservice;

	@RequestMapping(value = "/add", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView add(TrainTicket trainTicket) {
		ModelAndView modelView = new ModelAndView();
		Map<String, String> resultMap = trainTicketservice.add(trainTicket);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/querybyschool", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView querybyschool(TrainTicket trainTicket) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = trainTicketservice
				.queryBySchool(trainTicket);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
