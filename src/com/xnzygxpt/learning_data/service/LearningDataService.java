package com.xnzygxpt.learning_data.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.learning_data.dao.vo.LearningData;

@Service
public class LearningDataService {
	@Autowired
	private LearningDataImpl learningDataImpl;

	public Map<String, Object> queryByClass(LearningData classify) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		List<LearningData> glist = new ArrayList<LearningData>();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			glist = learningDataImpl.queryByclass(classify);
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("resultBean", glist);
		return hmap;
	}

	public Map<String, Object> queryByID(int learning_dataid) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		LearningData learningData = new LearningData();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			learningData = learningDataImpl.queryByID(learning_dataid);
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("bean", learningData);
		return hmap;
	}
}
