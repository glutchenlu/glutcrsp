package com.xnzygxpt.message.controll;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.message.dao.vo.Message;
import com.xnzygxpt.message.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageservice;

	@RequestMapping(value = "/querybymessage", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView querybymessage(Message message) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = messageservice.querybymessage(message);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/querybyuser", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView querybyuser(Message message) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = messageservice.querybyuser(message);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/sendmessage", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView sendmessage(Message message) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = messageservice.sendmessage(message);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/del", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView del(int messageid) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = messageservice.del(messageid);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
