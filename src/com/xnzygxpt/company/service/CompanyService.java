package com.xnzygxpt.company.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.company.dao.vo.Company;

@Service
public class CompanyService {
	@Autowired
	private CompanyImpl companyImpl;

	/**
	 * 添加公司
	 * 
	 * @param company
	 *            注册公司的信息
	 * @return
	 */
	public Map<String, String> addCompany(Company company) {
		Map<String, String> hmap = new HashMap<String, String>();
		int returnCode = 0;
		System.out.println("Companyname:" + company.getCompanyname());
		String returnString = "该公司已经添加注册！";
		if (company.getCompanyname() != null
				&& !"".equals(company.getCompanyname())) {
			Company localCompany = companyImpl.queryByName(company
					.getCompanyname());
			if (localCompany != null) {
				System.out.println("该公司已经添加注册！");
			} else {
				companyImpl.add(company);
				returnCode = 1;
				returnString = "公司添加注册成功！";
			}
		} else {
			returnString = "输入的公司名称为空！";
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		return hmap;
	}

	public Map<String, String> checkCompany(String companyname) {
		Map<String, String> hmap = new HashMap<String, String>();
		int returnCode = 0;
		System.out.println("Companyname:" + companyname);
		String returnString = "所填写公司未添加注册！";
		if (companyname != null && !"".equals(companyname)) {
			Company localCompany = companyImpl.queryByName(companyname);
			if (localCompany != null) {
				System.out.println("该公司已经添加注册！");
				returnString = "该公司已经添加注册！";
				returnCode = 1;
			} else {
				returnCode = 0;
				returnString = "所填写公司未添加注册！";
			}
		} else {
			returnString = "输入的公司名称为空！";
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		return hmap;
	}
}
