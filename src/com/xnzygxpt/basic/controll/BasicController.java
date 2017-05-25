package com.xnzygxpt.basic.controll;

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

import com.xnzygxpt.basic.dao.vo.Basic;
import com.xnzygxpt.basic.service.BasicService;

/**
 * 基本信息控制类
 * 
 * @author CL
 *
 */
@Controller
@RequestMapping("/basic")
public class BasicController {

	@Autowired
	private BasicService basicservice;

	/**
	 * 接收请求，根据basicid查询basic表，并通过返回json数据，告知客户端操作结果
	 * 
	 * @param basic
	 *            请求实体
	 * @return
	 */
	@RequestMapping(value = "/findbyid", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView findbyid(Basic basic) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = basicservice.findbyid(basic);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	/**
	 * 接收请求，获取客户端上传的文件流，保存至本地，并通过返回json数据，告知客户端操作结果
	 * 
	 * @param multiFiles
	 *            文件流（头像图片）
	 * @param request
	 *            根据request获取到本地路径，用来保存
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView upload(
			@RequestParam("photo") CommonsMultipartFile multiFiles,
			HttpServletRequest request) throws IllegalStateException,
			IOException {
		ModelAndView modelView = new ModelAndView();
		// 获取保存的路径
		String savePath = request.getSession().getServletContext()
				.getRealPath("updata/upimage/basic");
		Map<String, String> resultMap = basicservice.upload(multiFiles,
				savePath);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	/**
	 * 更新basic表内的内容，并通过返回json数据，告知客户端操作结果
	 * 
	 * @param basic
	 *            所要更新后的内容
	 * @return
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView update(Basic basic) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = basicservice.update(basic);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}

	/**
	 * 根据注册时的信息更新至basic表，包括学校、头像、邮箱，并通过返回json数据，告知客户端操作结果
	 * 
	 * @param basic
	 *            所要更新后的内容
	 * @return
	 */
	@RequestMapping(value = "/updateschool", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView updateschool(Basic basic) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> resultMap = basicservice.updateschool(basic);
		modelView.addObject("resultMap", resultMap);
		return modelView;
	}
}
