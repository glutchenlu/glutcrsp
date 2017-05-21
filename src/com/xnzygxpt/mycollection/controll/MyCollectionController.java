package com.xnzygxpt.mycollection.controll;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.mycollection.dao.vo.MyCollection;
import com.xnzygxpt.mycollection.service.MyCollectionService;

@Controller
@RequestMapping("/mycollection")
public class MyCollectionController {

	@Autowired
	private MyCollectionService collectionservice;

	@RequestMapping(value = "/querybyuserid", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView querybyuserid(String userid) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = collectionservice.querybyuserid(userid);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/del", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView querybyuserid(int collectionid) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = collectionservice.del(collectionid);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/add", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView add(MyCollection myCollection) {
		ModelAndView modelView = new ModelAndView();
		Map<String, String> resultMap = collectionservice.add(myCollection);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
