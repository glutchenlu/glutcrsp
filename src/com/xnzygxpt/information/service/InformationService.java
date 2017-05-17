package com.xnzygxpt.information.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.information.dao.vo.Information;

@Service
public class InformationService {
	@Autowired
	private InformationImpl imformationImpl;

	public Map<String, Object> queryByClass(Information classify) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		List<Information> glist = new ArrayList<Information>();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			glist = imformationImpl.queryByclass(classify);
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
}
