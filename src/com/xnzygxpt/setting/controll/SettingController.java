package com.xnzygxpt.setting.controll;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.setting.dao.vo.Setting;
import com.xnzygxpt.setting.service.SettingService;

@Controller
@RequestMapping("/setting")
public class SettingController {

	@Autowired
	private SettingService settingservice;

	@RequestMapping(value = "/update", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView update(Setting setting) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = settingservice.update(setting);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
