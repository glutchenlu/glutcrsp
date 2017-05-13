package com.xnzygxpt.company.dao.dao;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.company.dao.vo.Company;

@Repository
public interface CompanyMapper {
	public Company queryByID(int companyid);

	public Company queryByName(String companyname);

	public int add(Company p);

	public int update(Company p);
}
