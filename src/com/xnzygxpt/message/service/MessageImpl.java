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

	public Message check(Message p) {
		return per.check(p);
	}

	@Transactional
	public int update(Message p) {
		return per.update(p);
	}

	@Transactional
	public int add(Message p) {
		return per.add(p);
	}

	public List<Message> queryAll() {
		return per.queryAll();
	}

	public List<Message> querybyuser(Message p) {
		return per.querybyuser(p);
	}

	public int querybymessage(Message p) {
		return per.querybymessage(p);
	}

	@Transactional
	public int del(int Messageid) {
		return per.del(Messageid);
	}
}
