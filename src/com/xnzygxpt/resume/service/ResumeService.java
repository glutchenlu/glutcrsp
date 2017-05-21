package com.xnzygxpt.resume.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.resume.dao.vo.Resume;

@Service
public class ResumeService {
	@Autowired
	private ResumeImpl resumeImpl;

	public Map<String, String> add(Resume resume) {
		Map<String, String> hmap = new HashMap<String, String>();
		String returnString = "添加失败！";
		int count = 0;
		int returnCode = 0;
		try {
			count = resumeImpl.check(resume.getUserid());
			if (count == 3) {
				returnString = "您已经有三份简历，不能再添加简历 ！";
				returnCode = 2;
			} else {
				resumeImpl.add(resume);
				count++;
				returnString = "添加成功！";
				returnCode = 1;
			}
		} catch (Exception e) {
			returnString = "添加失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("count", count + "");
		return hmap;
	}

	public Map<String, String> check(Resume resume) {
		Map<String, String> hmap = new HashMap<String, String>();
		String returnString = "查询失败！";
		int count = 0;
		int returnCode = 0;
		try {
			count = resumeImpl.check(resume.getUserid());
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("count", count + "");
		return hmap;
	}

	public Map<String, Object> querybyuser(Resume resume) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		List<Resume> rlist = new ArrayList<Resume>();
		String returnString = "查询失败！";
		int count = 0;
		int returnCode = 0;
		try {
			rlist = resumeImpl.queryByOne(resume.getUserid());
			count = rlist.size();
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("resume", rlist);
		hmap.put("count", count);
		return hmap;
	}

	public Map<String, Object> querybyid(Resume resume) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		Resume locresume = new Resume();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			locresume = resumeImpl.queryByID(resume.getResumeid());
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("resume", locresume);
		return hmap;
	}

	public Map<String, Object> update(Resume resume) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		String returnString = "更新失败！";
		int returnCode = 0;
		try {
			resumeImpl.update(resume);
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

	public Map<String, Object> del(int resumeid) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		String returnString = "删除失败！";
		int returnCode = 0;
		try {
			resumeImpl.del(resumeid);
			returnString = "删除成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "删除失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		return hmap;
	}
}
