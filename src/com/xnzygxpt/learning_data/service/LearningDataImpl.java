package com.xnzygxpt.learning_data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.learning_data.dao.dao.LearningDataMapper;
import com.xnzygxpt.learning_data.dao.vo.LearningData;

@Service
public class LearningDataImpl {
	@Autowired
	private LearningDataMapper per;

	public LearningData queryByID(int LearningDataid) {
		return per.queryByID(LearningDataid);
	}

	@Transactional
	public int add(LearningData p) {
		return per.add(p);
	}

	public List<LearningData> querybyuserid(String userid) {
		return per.querybyuserid(userid);
	}
	@Transactional
	public int update(LearningData p) {
		return per.update(p);
	}

	public List<LearningData> queryByclass(LearningData p) {
		return per.queryByClass(p);
	}

	public List<LearningData> queryAll() {
		return per.queryAll();
	}

	@Transactional
	public int del(int LearningDataid) {
		return per.del(LearningDataid);
	}
}
