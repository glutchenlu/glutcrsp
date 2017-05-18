package com.xnzygxpt.goods.controll;

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

import com.xnzygxpt.goods.dao.vo.Goods;
import com.xnzygxpt.goods.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsservice;

	@RequestMapping(value = "/addGoods", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView add(Goods goods) {
		ModelAndView modelView = new ModelAndView();
		Map<String, String> resultMap = goodsservice.addGoods(goods);
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
				.getRealPath("updata/upimage/goods");
		Map<String, String> resultMap = goodsservice.upload(multiFiles,
				savePath);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	@RequestMapping(value = "/queryclass", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView queryByClass(Goods goods) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = goodsservice.queryByClass(goods);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

}
