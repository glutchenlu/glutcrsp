package com.xnzygxpt.basic.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xnzygxpt.basic.dao.vo.Basic;
import com.xnzygxpt.util.LocPath;

@Service
public class BasicService {
	@Autowired
	private BasicImpl basicImpl;

	public Map<String, Object> findbyid(Basic basic) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			basic = basicImpl.queryByID(basic.getBasicid());
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("resultBasic", basic);
		return hmap;
	}

	public Map<String, Object> update(Basic basic) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		String returnString = "更新失败！";
		int returnCode = 0;
		try {
			basicImpl.update(basic);
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

	public Map<String, Object> updateschool(Basic basic) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		String returnString = "更新失败！";
		int returnCode = 0;
		try {
			basicImpl.updateschool(basic);
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

	public Map<String, String> upload(CommonsMultipartFile multiFiles,
			String savePath) throws IllegalStateException, IOException {
		Map<String, String> hmap = new HashMap<String, String>();
		String returnString = "上传成功失败！";
		int returnCode = 0;
		StringBuffer dbStr = new StringBuffer();
		long startTime = System.currentTimeMillis();
		if (multiFiles != null && !multiFiles.isEmpty()) {
			String fileName = multiFiles.getOriginalFilename();
			System.out.println("fileName：" + fileName);
			File newFile = new File(savePath, new Date().getTime() + "_"
					+ fileName);
			if (!newFile.getParentFile().exists()) {
				System.out.println("文件夹不存在");
				newFile.getParentFile().mkdir();
			}
			multiFiles.transferTo(newFile);
			dbStr.append(",");
			dbStr.append(LocPath.LocUrlImage + "basic/" + newFile.getName());
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
}
