package com.xnzygxpt.train_ticket.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.train_ticket.dao.vo.TrainTicket;

@Service
public class TrainTicketService {
	@Autowired
	private TrainTicketImpl trainTicketImpl;

	public Map<String, String> add(TrainTicket trainTicket) {
		Map<String, String> hmap = new HashMap<String, String>();
		String returnString = "添加失败！";
		int returnCode = 0;
		try {
			trainTicketImpl.add(trainTicket);
			returnString = "添加成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "添加失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		return hmap;
	}

	public Map<String, Object> queryBySchool(TrainTicket trainTicket) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		List<TrainTicket> tlist = new ArrayList<TrainTicket>();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			tlist = trainTicketImpl.queryByclass(trainTicket);
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("resultBean", tlist);
		return hmap;
	}

	public Map<String, Object> queryByID(int train_ticketid) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		TrainTicket trainTicket = new TrainTicket();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			trainTicket = trainTicketImpl.queryByID(train_ticketid);
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("bean", trainTicket);
		return hmap;
	}
}
