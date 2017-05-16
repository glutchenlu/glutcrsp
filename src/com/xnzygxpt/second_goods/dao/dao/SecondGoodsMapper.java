package com.xnzygxpt.second_goods.dao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.second_goods.dao.vo.SecondGoods;

@Repository
public interface SecondGoodsMapper {
	public SecondGoods queryByID(int SecondGoodsid);

	public int add(SecondGoods p);

	public int update(SecondGoods p);

	public int del(int SecondGoodsid);

	public List<SecondGoods> queryAll();

	public List<SecondGoods> queryByClass(String p);

	public List<SecondGoods> querybyuserid(String userid);
}
