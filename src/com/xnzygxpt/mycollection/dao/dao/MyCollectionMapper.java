package com.xnzygxpt.mycollection.dao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.mycollection.dao.vo.MyCollection;

@Repository
public interface MyCollectionMapper {
	public MyCollection queryByID(int collectionid);

	public int add(MyCollection p);

	public int del(int collectionid);
	
	public List<MyCollection> queryAll();
}
