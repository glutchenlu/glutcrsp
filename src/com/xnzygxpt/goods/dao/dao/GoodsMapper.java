package com.xnzygxpt.goods.dao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.goods.dao.vo.Goods;

@Repository
public interface GoodsMapper {
	public Goods queryByID(int Goodsid);

	public int add(Goods p);

	public int update(Goods p);

	public int del(int Goodsid);

	public List<Goods> queryAll();

	public List<Goods> queryByClass(String p);
}
