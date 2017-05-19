package com.xnzygxpt.message.dao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.message.dao.vo.Message;

@Repository
public interface MessageMapper {
	public Message queryByID(int Messageid);

	public int add(Message p);

	public int del(int Messageid);

	public List<Message> queryAll();

	public int querybymessage(Message p);

	public List<Message> querybyuser(Message p);

	public Message check(Message p);

	public int update(Message p);
}
