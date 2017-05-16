package com.xnzygxpt.courier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.courier.dao.dao.CourierMapper;
import com.xnzygxpt.courier.dao.vo.Courier;

@Service
public class CourierImpl {
	@Autowired
	private CourierMapper per;

	public Courier queryByID(int courierid) {
		return per.queryByID(courierid);
	}

	@Transactional
	public int add(Courier p) {
		return per.add(p);
	}

	@Transactional
	public int update(Courier p) {
		return per.update(p);
	}

	public List<Courier> queryAll() {
		return per.queryAll();
	}

	public List<Courier> querybyuserid(String userid) {
		return per.querybyuserid(userid);
	}

	@Transactional
	public int del(int courierid) {
		return per.del(courierid);
	}
}
