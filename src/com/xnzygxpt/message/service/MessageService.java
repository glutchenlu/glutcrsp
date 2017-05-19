package com.xnzygxpt.message.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnzygxpt.basic.dao.vo.Basic;
import com.xnzygxpt.basic.service.BasicImpl;
import com.xnzygxpt.message.dao.vo.Message;
import com.xnzygxpt.xuser.service.XUserImpl;

@Service
public class MessageService {
	@Autowired
	private MessageImpl messageImpl;
	@Autowired
	private XUserImpl userImpl;
	@Autowired
	private BasicImpl basicImpl;

	// @Autowired
	// private CourierImpl courierImpl;
	// @Autowired
	// private GoodsImpl goodsImpl;
	// @Autowired
	// private InformationImpl informationImpl;
	// @Autowired
	// private LearningDataImpl learningDataImpl;
	// @Autowired
	// private SecondGoodsImpl secondGoodsImpl;
	// @Autowired
	// private TrainTicketImpl trainTicketImpl;
	// @Autowired
	// private WorkImpl workImpl;

	public Map<String, Object> querybymessage(Message message) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		int count = 0;
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			count = messageImpl.querybymessage(message);
			returnString = "查询成功！";
			returnCode = 1;
		} catch (Exception e) {
			returnString = "查询失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		hmap.put("count", count);
		return hmap;
	}

	public Map<String, Object> querybyuser(Message omessage) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		List<Message> mlist = new ArrayList<Message>();
		List<Basic> blist = new ArrayList<Basic>();
		String returnString = "查询失败！";
		int returnCode = 0;
		try {
			mlist = messageImpl.querybyuser(omessage);
			for (Message message : mlist) {
				Basic basic = new Basic();
				basic = basicImpl.queryByID(userImpl.queryByID(
						message.getFromuserid()).getBasicid());
				blist.add(basic);
				// 若变成对应服务可修改为
				// XUser user = new XUser();
				// switch (message.getType()) {
				// case 1:
				// user = userImpl.queryByID(courierImpl.queryByID(
				// message.getServiceid()).getUserid());
				// break;
				// case 2:
				// user = userImpl.queryByID(goodsImpl.queryByID(
				// message.getServiceid()).getUserid());
				// break;
				// case 3:
				// user = userImpl.queryByID(learningDataImpl.queryByID(
				// message.getServiceid()).getUserid());
				// break;
				// case 4:
				// user = userImpl.queryByID(secondGoodsImpl.queryByID(
				// message.getServiceid()).getUserid());
				// break;
				// case 5:
				// user = userImpl.queryByID(trainTicketImpl.queryByID(
				// message.getServiceid()).getUserid());
				// break;
				// case 6:
				// user = userImpl.queryByID(workImpl.queryByID(
				// message.getServiceid()).getUserid());
				// break;
				// case 7:
				// user = userImpl.queryByID(informationImpl.queryByID(
				// message.getServiceid()).getUserid());
				// break;
				//
				// default:
				// break;
				// }
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
		hmap.put("message", mlist);
		hmap.put("basic", blist);
		return hmap;
	}

	public Map<String, Object> sendmessage(Message message) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		String returnString = "发送失败！";
		int returnCode = 0;
		try {
			if (message.getFromuserid().equals(message.getUserid())) {
				returnCode = 2;
				returnString = "不能给自己发送消息！";
			} else {
				Message locMessage = messageImpl.check(message);
				// 检查同类型记录是否存在，存在更新，不存在添加
				if (locMessage == null) {
					messageImpl.add(message);
				} else if (locMessage != null) {
					int messageCount = locMessage.getCount() + 1;
					message.setCount(messageCount);
					message.setMessageid(locMessage.getMessageid());
					messageImpl.update(message);
				}
				returnString = "发送成功！";
				returnCode = 1;
			}
		} catch (Exception e) {
			returnString = "发送失败！";
			returnCode = 0;
			e.printStackTrace();
		}
		hmap.put("returnCode", returnCode + "");
		hmap.put("returnString", returnString);
		return hmap;
	}

	public Map<String, Object> del(int messageid) {
		Map<String, Object> hmap = new HashMap<String, Object>();
		String returnString = "删除失败！";
		int returnCode = 0;
		try {
			messageImpl.del(messageid);
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
