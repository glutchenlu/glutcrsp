package com.xnzygxpt.train_ticket.dao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.train_ticket.dao.vo.TrainTicket;

@Repository
public interface TrainTicketMapper {
	public TrainTicket queryByID(int TrainTicketid);

	public int add(TrainTicket p);

	public int update(TrainTicket p);

	public int del(int TrainTicketid);

	public List<TrainTicket> queryAll();

	public List<TrainTicket> querybyuserid(String userid);
}
