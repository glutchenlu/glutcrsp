package com.xnzygxpt.second_goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.second_goods.dao.dao.SecondGoodsMapper;
import com.xnzygxpt.second_goods.dao.vo.SecondGoods;

@Service
public class SecondGoodsImpl {
	@Autowired
	private SecondGoodsMapper per;

	public SecondGoods queryByID(int SecondGoodsid) {
		return per.queryByID(SecondGoodsid);
	}

	@Transactional
	public int add(SecondGoods p) {
		return per.add(p);
	}

	@Transactional
	public int update(SecondGoods p) {
		return per.update(p);
	}

	public List<SecondGoods> queryByclass(String p) {
		return per.queryByClass(p);
	}

	public List<SecondGoods> queryAll() {
		return per.queryAll();
	}

	@Transactional
	public int del(int SecondGoodsid) {
		return per.del(SecondGoodsid);
	}
}
