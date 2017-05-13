package com.xnzygxpt.setting.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xnzygxpt.setting.service.SettingImpl;

@Controller
public class SettingController {

	@Autowired
	private SettingImpl settingservice;
	
	
}
