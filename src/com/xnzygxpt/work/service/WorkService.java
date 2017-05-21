package com.xnzygxpt.work.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.company.dao.vo.Company;
import com.xnzygxpt.company.service.CompanyImpl;
import com.xnzygxpt.work.dao.vo.Work;

@Service
public class WorkService {
	@Autowired
	private WorkImpl workImpl;
	@Autowired
	private CompanyImpl companyImpl;

	public Map<String, String> addWork(Work work) {
		Map<String, String> hmap = new HashMap<String, String>();
		String returnString = "添加失败！";
		int returnCode = 0;
		try {
			workImpl.add(work);
			returnString = "添加成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "添加失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		return hmap;
	}

	public Map<String, Object> queryByIndustry(Work owork) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		List<Work> wlist = new ArrayList<Work>();
		List<Company> clist = new ArrayList<Company>();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			wlist = workImpl.queryByIndustry(owork);
			for (Work work : wlist) {
				Company company = new Company();
				company = companyImpl.queryByName(work.getSource());
				clist.add(company);
			}
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("resultwork", wlist);
		hmap.put("resultcompany", clist);
		return hmap;
	}

	public Map<String, Object> queryByID(int workid) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		Work work = new Work();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			work = workImpl.queryByID(workid);
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("bean", work);
		return hmap;
	}
}
