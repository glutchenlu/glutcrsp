package com.xnzygxpt.webchar.dao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.webchar.dao.vo.WebChar;

@Repository
public interface WebCharMapper {

	public int add(WebChar p);

	public List<WebChar> querybyinfo(int informationid);
	
	public WebChar querybyid(int webcharid);

}
