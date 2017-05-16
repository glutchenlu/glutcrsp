package com.xnzygxpt.work.dao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.work.dao.vo.Work;

@Repository
public interface WorkMapper {
	public Work queryByID(int Workid);

	public int add(Work p);

	public int update(Work p);

	public int del(int Workid);

	public List<Work> queryAll();

	public List<Work> queryByIndustry(String p);

	public List<Work> querybyuserid(String userid);

}
