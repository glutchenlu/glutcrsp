package com.xnzygxpt.webchar.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.basic.dao.vo.Basic;
import com.xnzygxpt.basic.service.BasicImpl;
import com.xnzygxpt.webchar.dao.vo.WebChar;
import com.xnzygxpt.xuser.service.XUserImpl;

@Service
public class WebCharService {
	@Autowired
	private WebCharImpl webCharImpl;
	@Autowired
	private XUserImpl xuserImpl;
	@Autowired
	private BasicImpl basicImpl;

	public Map<String, Object> add(WebChar webChar) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		Basic basic = new Basic();
		String returnString = "添加失败！";
		int returnCode = 0;
		try {
			webCharImpl.add(webChar);
			webChar = webCharImpl.querybyid(webChar.getWebcharid());
			basic = basicImpl.queryByID(xuserImpl
					.queryByID(webChar.getUserid()).getBasicid());
			returnString = "添加成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "添加失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("webchar", webChar);
		hmap.put("basic", basic);
		return hmap;
	}

	public Map<String, Object> querybyinfo(int informationid) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		List<WebChar> wlist = new ArrayList<WebChar>();
		List<Basic> blist = new ArrayList<Basic>();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			wlist = webCharImpl.querybyinfo(informationid);
			for (int i = 0; i < wlist.size(); i++) {
				Basic basic = basicImpl.queryByID(xuserImpl.queryByID(
						wlist.get(i).getUserid()).getBasicid());
				blist.add(basic);
			}
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("webchar", wlist);
		hmap.put("basic", blist);
		return hmap;
	}
}
