package com.xnzygxpt.courier.dao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.courier.dao.vo.Courier;

@Repository
public interface CourierMapper {
	public Courier queryByID(int courierid);

	public int add(Courier p);

	public int update(Courier p);

	public int updatestate(Courier p);

	public int del(int courierid);

	public List<Courier> queryAll();

	public List<Courier> querybyuserid(String userid);

	public List<Courier> querybyschool(Courier p);
}
