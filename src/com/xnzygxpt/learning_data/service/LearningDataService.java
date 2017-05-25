package com.xnzygxpt.learning_data.service;

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

import com.xnzygxpt.learning_data.dao.vo.LearningData;
import com.xnzygxpt.util.LocPath;

@Service
public class LearningDataService {
	@Autowired
	private LearningDataImpl learningDataImpl;

	public Map<String, Object> queryByClass(LearningData classify) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		List<LearningData> glist = new ArrayList<LearningData>();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			glist = learningDataImpl.queryByclass(classify);
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

	public Map<String, Object> queryByID(int learning_dataid) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		LearningData learningData = new LearningData();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			learningData = learningDataImpl.queryByID(learning_dataid);
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("bean", learningData);
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
				fileName = fileName.substring(fileName.lastIndexOf("."));
				// System.out.println("fileName：" + fileName);
				File newFile = new File(savePath, new Date().getTime()
						+ fileName);
				if (!newFile.getParentFile().exists()) {
					System.out.println("文件夹不存在");
					newFile.getParentFile().mkdir();
				}
				file.transferTo(newFile);
				dbStr.append(",");
				dbStr.append(LocPath.LocUrlImage + "learningdata/"
						+ newFile.getName());
			}
		}
		if (dbStr.length() != 0) {
			dbStr = dbStr.deleteCharAt(0);
		}
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

	public Map<String, String> add(LearningData learningData) {
		Map<String, String> hmap = new HashMap<String, String>();
		String returnString = "添加失败！";
		int returnCode = 0;
		try {
			learningDataImpl.add(learningData);
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
}
