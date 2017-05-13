package com.xnzygxpt.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.work.dao.dao.WorkMapper;
import com.xnzygxpt.work.dao.vo.Work;

@Service
public class WorkImpl {
	@Autowired
	private WorkMapper per;

	public Work queryByID(int Workid) {
		return per.queryByID(Workid);
	}

	@Transactional
	public int add(Work p) {
		return per.add(p);
	}

	@Transactional
	public int update(Work p) {
		return per.update(p);
	}

	public List<Work> queryAll() {
		return per.queryAll();
	}

	@Transactional
	public int del(int Workid) {
		return per.del(Workid);
	}
}
