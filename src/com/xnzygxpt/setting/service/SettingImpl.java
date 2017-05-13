package com.xnzygxpt.setting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.setting.dao.dao.SettingMapper;
import com.xnzygxpt.setting.dao.vo.Setting;

@Service
public class SettingImpl {
	@Autowired
	private SettingMapper per;

	public Setting queryByID(int userid) {
		return per.queryByID(userid);
	}

	@Transactional
	public int add(Setting p) {
		return per.add(p);
	}

	@Transactional
	public int update(Setting p) {
		return per.update(p);
	}
}
