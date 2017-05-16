package com.xnzygxpt.learning_data.dao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.learning_data.dao.vo.LearningData;

@Repository
public interface LearningDataMapper {
	public LearningData queryByID(int LearningDataid);

	public int add(LearningData p);

	public int update(LearningData p);

	public int del(int LearningDataid);

	public List<LearningData> queryAll();

	public List<LearningData> queryByClass(String p);

	public List<LearningData> querybyuserid(String userid);
}
