package com.xnzygxpt.second_goods.controll;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xnzygxpt.second_goods.dao.vo.SecondGoods;
import com.xnzygxpt.second_goods.service.SecondGoodsService;

@Controller
@RequestMapping("/secondgoods")
public class SecondGoodsController {

	@Autowired
	private SecondGoodsService secondGoodsservice;

	@RequestMapping(value = "/addsecondGoods", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView add(SecondGoods secondGoods) {
		ModelAndView modelView = new ModelAndView();
		Map<String, String> resultMap = secondGoodsservice
				.addGoods(secondGoods);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView upload(
			@RequestParam("photo") CommonsMultipartFile[] multiFiles,
			HttpServletRequest request) throws IllegalStateException,
			IOException {
		ModelAndView modelView = new ModelAndView();
		String savePath = request.getSession().getServletContext()
				.getRealPath("updata/upimage/secondgoods");
		Map<String, String> resultMap = secondGoodsservice.upload(multiFiles,
				savePath);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/queryclass", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView queryByClass(SecondGoods classify) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = secondGoodsservice
				.queryByClass(classify);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/queryByID", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView queryByID(int second_goodsid) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = secondGoodsservice
				.queryByID(second_goodsid);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
