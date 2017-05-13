package com.xnzygxpt.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.company.dao.dao.CompanyMapper;
import com.xnzygxpt.company.dao.vo.Company;

@Service
public class CompanyImpl {
	@Autowired
	private CompanyMapper per;

	public Company queryByID(int Company) {
		return per.queryByID(Company);
	}

	public Company queryByName(String CompanyName) {
		return per.queryByName(CompanyName);
	}

	@Transactional
	public int add(Company p) {
		return per.add(p);
	}

	@Transactional
	public int update(Company p) {
		return per.update(p);
	}
}
