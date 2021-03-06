package com.xnzygxpt.courier.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.courier.dao.vo.Courier;

@Service
public class CourierService {
	@Autowired
	private CourierImpl courierImpl;

	public Map<String, String> add(Courier courier) {
		Map<String, String> hmap = new HashMap<String, String>();
		String returnString = "添加失败！";
		int returnCode = 0;
		try {
			courierImpl.add(courier);
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

	public Map<String, Object> queryBySchool(Courier courier) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		List<Courier> clist = new ArrayList<Courier>();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			clist = courierImpl.queryByclass(courier);
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("resultBean", clist);
		return hmap;
	}

	public Map<String, Object> queryByID(int courierid) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		Courier courier = new Courier();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			courier = courierImpl.queryByID(courierid);
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("bean", courier);
		return hmap;
	}
}
