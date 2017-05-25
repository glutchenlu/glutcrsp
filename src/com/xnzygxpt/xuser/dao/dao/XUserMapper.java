package com.xnzygxpt.xuser.dao.dao;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.xuser.dao.vo.XUser;

@Repository
public interface XUserMapper {
	public XUser queryByID(String userid);

	public int add(XUser p);

	public int updateStatus(XUser p);

	public void modify(XUser xuser);
}
