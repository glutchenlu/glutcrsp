package com.xnzygxpt.setting.dao.dao;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.setting.dao.vo.Setting;

@Repository
public interface SettingMapper {
	public Setting queryByID(int setting);

	public int add(Setting p);

	public int update(Setting p);
}
