package com.xnzygxpt.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.basic.dao.dao.BasicMapper;
import com.xnzygxpt.basic.dao.vo.Basic;

@Service
public class BasicImpl {
	@Autowired
	private BasicMapper per;

	public Basic queryByID(int basic) {
		return per.queryByID(basic);
	}

	@Transactional
	public int add(Basic p) {
		return per.add(p);
	}

	@Transactional
	public int update(Basic p) {
		return per.update(p);
	}

	@Transactional
	public int updatecredit(Basic p) {
		return per.updatecredit(p);
	}
}
