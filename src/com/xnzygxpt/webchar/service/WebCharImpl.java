package com.xnzygxpt.webchar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.webchar.dao.dao.WebCharMapper;
import com.xnzygxpt.webchar.dao.vo.WebChar;

@Service
public class WebCharImpl {
	@Autowired
	private WebCharMapper per;

	public List<WebChar> querybyinfo(int informationid) {
		return per.querybyinfo(informationid);
	}
	public WebChar querybyid(int webcharid) {
		return per.querybyid(webcharid);
	}

	@Transactional
	public int add(WebChar p) {
		return per.add(p);
	}
}
