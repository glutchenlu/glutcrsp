package com.xnzygxpt.dating.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.dating.dao.dao.DatingMapper;
import com.xnzygxpt.dating.dao.vo.Dating;

@Service
public class DatingImpl {
	@Autowired
	private DatingMapper per;

	public Dating queryByID(int dating) {
		return per.queryByID(dating);
	}

	@Transactional
	public int add(Dating p) {
		return per.add(p);
	}

	@Transactional
	public int update(Dating p) {
		return per.update(p);
	}
}
