package com.xnzygxpt.mycollection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.mycollection.dao.dao.MyCollectionMapper;
import com.xnzygxpt.mycollection.dao.vo.MyCollection;

@Service
public class MyCollectionImpl {
	@Autowired
	private MyCollectionMapper per;

	public MyCollection queryByID(int collectionid) {
		return per.queryByID(collectionid);
	}

	public int check(MyCollection p) {
		return per.check(p);
	}

	public List<MyCollection> queryAll() {
		return per.queryAll();
	}

	public List<MyCollection> querybyuserid(String userid) {
		return per.querybyuserid(userid);
	}

	@Transactional
	public int add(MyCollection p) {
		return per.add(p);
	}

	@Transactional
	public int del(int collection) {
		return per.del(collection);
	}
}
