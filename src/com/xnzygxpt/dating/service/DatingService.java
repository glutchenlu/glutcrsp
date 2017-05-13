package com.xnzygxpt.dating.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.dating.dao.vo.Dating;

@Service
public class DatingService {
	@Autowired
	private DatingImpl datingImpl;

	public Map<String, Object> findbyid(Dating dating) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			dating = datingImpl.queryByID(dating.getDating());
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("resultDating", dating);
		return hmap;
	}

	public Map<String, Object> update(Dating dating) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		String returnString = "更新失败！";
		int returnCode = 0;
		try {
			datingImpl.update(dating);
			returnString = "更新成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "更新失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		return hmap;
	}
}
