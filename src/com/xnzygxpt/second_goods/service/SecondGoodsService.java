package com.xnzygxpt.second_goods.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xnzygxpt.second_goods.dao.vo.SecondGoods;
import com.xnzygxpt.util.LocPath;

@Service
public class SecondGoodsService {
	@Autowired
	private SecondGoodsImpl secondGoodsImpl;

	public Map<String, String> addGoods(SecondGoods secondGoods) {
		Map<String, String> hmap = new HashMap<String, String>();
		String returnString = "添加失败！";
		int returnCode = 0;
		try {
			secondGoodsImpl.add(secondGoods);
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

	public Map<String, String> upload(CommonsMultipartFile[] multiFiles,
			String savePath) throws IllegalStateException, IOException {
		Map<String, String> hmap = new HashMap<String, String>();
		String returnString = "上传成功失败！";
		int returnCode = 0;
		StringBuffer dbStr = new StringBuffer();
		long startTime = System.currentTimeMillis();
		for (MultipartFile file : multiFiles) {
			if (file != null && !file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				System.out.println("fileName：" + fileName);
				File newFile = new File(savePath, new Date().getTime() + "_"
						+ fileName);
				if (!newFile.getParentFile().exists()) {
					System.out.println("文件夹不存在");
					newFile.getParentFile().mkdir();
				}
				file.transferTo(newFile);
				dbStr.append(",");
				dbStr.append(LocPath.LocUrlImage + "secondgoods/"
						+ newFile.getName());
			}
		}
		dbStr = dbStr.deleteCharAt(0);
		returnString = "上传成功";
		returnCode = 1;
		long endTime = System.currentTimeMillis();
		System.out
				.println("上传时间：" + String.valueOf(endTime - startTime) + "ms");
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("dbStr", dbStr.toString());
		return hmap;
	}

	public Map<String, Object> queryByClass(String classify) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		List<SecondGoods> glist = new ArrayList<SecondGoods>();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			glist = secondGoodsImpl.queryByclass(classify);
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("resultBean", glist);
		return hmap;
	}
}
