package com.xnzygxpt.resume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnzygxpt.resume.dao.dao.ResumeMapper;
import com.xnzygxpt.resume.dao.vo.Resume;

@Service
public class ResumeImpl {
	@Autowired
	private ResumeMapper per;

	public Resume queryByID(int Resumeid) {
		return per.queryByID(Resumeid);
	}

	@Transactional
	public int add(Resume p) {
		return per.add(p);
	}

	@Transactional
	public int update(Resume p) {
		return per.update(p);
	}

	public List<Resume> queryByOne(String userid) {
		return per.queryByOne(userid);
	}

	public int check(String userid) {
		return per.check(userid);
	}

	@Transactional
	public int del(int Resumeid) {
		return per.del(Resumeid);
	}
}
