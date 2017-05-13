package com.xnzygxpt.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.goods.dao.dao.GoodsMapper;
import com.xnzygxpt.goods.dao.vo.Goods;

@Service
public class GoodsImpl {
	@Autowired
	private GoodsMapper per;

	public Goods queryByID(int Goodsid) {
		return per.queryByID(Goodsid);
	}

	@Transactional
	public int add(Goods p) {
		return per.add(p);
	}

	@Transactional
	public int update(Goods p) {
		return per.update(p);
	}

	public List<Goods> queryAll() {
		return per.queryAll();
	}

	public List<Goods> queryByclass(String p) {
		return per.queryByClass(p);
	}

	@Transactional
	public int del(int Goodsid) {
		return per.del(Goodsid);
	}
}
