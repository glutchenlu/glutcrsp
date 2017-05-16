package com.xnzygxpt.information.dao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.information.dao.vo.Information;

@Repository
public interface InformationMapper {
	public Information queryByID(int Informationid);

	public int add(Information p);

	public int update(Information p);

	public int del(int Informationid);

	public List<Information> queryAll();

	public List<Information> queryByClass(String p);

	public List<Information> querybyuserid(String userid);
}
