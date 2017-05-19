package com.xnzygxpt.setting.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.setting.dao.vo.Setting;

@Service
public class SettingService {
	@Autowired
	private SettingImpl settingImpl;

	public Map<String, Object> update(Setting setting) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		String returnString = "更新失败！";
		int returnCode = 0;
		try {
			settingImpl.update(setting);
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
