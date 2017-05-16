package com.xnzygxpt.train_ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.train_ticket.dao.dao.TrainTicketMapper;
import com.xnzygxpt.train_ticket.dao.vo.TrainTicket;

@Service
public class TrainTicketImpl {
	@Autowired
	private TrainTicketMapper per;

	public TrainTicket queryByID(int TrainTicketid) {
		return per.queryByID(TrainTicketid);
	}

	@Transactional
	public int add(TrainTicket p) {
		return per.add(p);
	}

	public List<TrainTicket> querybyuserid(String userid) {
		return per.querybyuserid(userid);
	}

	@Transactional
	public int update(TrainTicket p) {
		return per.update(p);
	}

	public List<TrainTicket> queryAll() {
		return per.queryAll();
	}

	@Transactional
	public int del(int TrainTicketid) {
		return per.del(TrainTicketid);
	}
}
