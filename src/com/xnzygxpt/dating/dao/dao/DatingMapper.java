package com.xnzygxpt.dating.dao.dao;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.dating.dao.vo.Dating;

@Repository
public interface DatingMapper {
	public Dating queryByID(int dating);

	public int add(Dating p);

	public int update(Dating p);
}
