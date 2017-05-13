package com.xnzygxpt.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.message.dao.dao.MessageMapper;
import com.xnzygxpt.message.dao.vo.Message;

@Service
public class MessageImpl {
	@Autowired
	private MessageMapper per;

	public Message queryByID(int Messageid) {
		return per.queryByID(Messageid);
	}

	@Transactional
	public int add(Message p) {
		return per.add(p);
	}

	public List<Message> queryAll() {
		return per.queryAll();
	}

	@Transactional
	public int del(int Messageid) {
		return per.del(Messageid);
	}
}
