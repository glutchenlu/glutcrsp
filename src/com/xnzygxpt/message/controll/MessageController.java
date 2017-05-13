package com.xnzygxpt.message.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xnzygxpt.message.service.MessageImpl;

@Controller
public class MessageController {

	@Autowired
	private MessageImpl messageservice;
	
	
}
