package com.xnzygxpt.mycollection.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.company.dao.vo.Company;
import com.xnzygxpt.company.service.CompanyImpl;
import com.xnzygxpt.mycollection.dao.vo.MyCollection;
import com.xnzygxpt.work.service.WorkImpl;

@Service
public class MyCollectionService {
	@Autowired
	private MyCollectionImpl myCollectionImpl;
	@Autowired
	private CompanyImpl companyImpl;
	@Autowired
	private WorkImpl workImpl;

	public Map<String, Object> querybyuserid(String userid) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			List<MyCollection> mlist = myCollectionImpl.querybyuserid(userid);
			List<Company> clist = new ArrayList<Company>();

			for (MyCollection mycollection : mlist) {
				if (mycollection.getType() == 6) {
					Company company = new Company();
					company = companyImpl.queryByName(workImpl.queryByID(
							mycollection.getServiceid()).getSource());
					clist.add(company);
				}
			}
			listMap.put("company", clist);
			listMap.put("mycollection", mlist);

			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("returnBean", listMap);
		return hmap;
	}

	public Map<String, Object> del(int collectionid) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		String returnString = "删除失败！";
		int returnCode = 0;
		try {
			myCollectionImpl.del(collectionid);
			returnString = "删除成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "删除失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		return hmap;
	}

	public Map<String, String> add(MyCollection myCollection) {
		Map<String, String> hmap = new HashMap<String, String>();
		String returnString = "收藏失败！";
		int returnCode = 0;
		try {
			if (myCollectionImpl.check(myCollection) != 0) {
				returnString = "您已经收藏该内容！";
				returnCode = 2;
			} else {
				myCollectionImpl.add(myCollection);
				returnString = "收藏成功！";
				returnCode = 1;
			}
		} catch (Exception e) {
			returnString = "收藏失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		return hmap;
	}
}
