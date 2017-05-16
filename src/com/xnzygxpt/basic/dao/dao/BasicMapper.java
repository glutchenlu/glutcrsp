package com.xnzygxpt.basic.dao.dao;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.basic.dao.vo.Basic;

@Repository
public interface BasicMapper {
	public Basic queryByID(int basicid);

	public int add(Basic p);

	public int update(Basic p);

	public int updateschool(Basic p);

	public int updatecredit(Basic p);
}
