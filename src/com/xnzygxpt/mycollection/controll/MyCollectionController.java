package com.xnzygxpt.mycollection.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xnzygxpt.mycollection.service.MyCollectionImpl;

@Controller
public class MyCollectionController {

	@Autowired
	private MyCollectionImpl collectionservice;
	
	
}
