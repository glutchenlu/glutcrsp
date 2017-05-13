package com.xnzygxpt.resume.dao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnzygxpt.resume.dao.vo.Resume;

@Repository
public interface ResumeMapper {
	public Resume queryByID(int Resumeid);

	public int add(Resume p);

	public int update(Resume p);

	public int del(int Resumeid);

	public List<Resume> queryByOne();
}
