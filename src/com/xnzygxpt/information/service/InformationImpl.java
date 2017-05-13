package com.xnzygxpt.information.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.information.dao.dao.InformationMapper;
import com.xnzygxpt.information.dao.vo.Information;

@Service
public class InformationImpl {
	@Autowired
	private InformationMapper per;

	public Information queryByID(int Informationid) {
		return per.queryByID(Informationid);
	}

	@Transactional
	public int add(Information p) {
		return per.add(p);
	}

	@Transactional
	public int update(Information p) {
		return per.update(p);
	}

	public List<Information> queryAll() {
		return per.queryAll();
	}

	public List<Information> queryByclass(String p) {
		return per.queryByClass(p);
	}

	@Transactional
	public int del(int Informationid) {
		return per.del(Informationid);
	}
}
