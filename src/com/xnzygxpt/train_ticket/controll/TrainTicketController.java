package com.xnzygxpt.train_ticket.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xnzygxpt.train_ticket.service.TrainTicketImpl;

@Controller
public class TrainTicketController {

	@Autowired	
	private TrainTicketImpl trainTicketservice;
	
	
}
