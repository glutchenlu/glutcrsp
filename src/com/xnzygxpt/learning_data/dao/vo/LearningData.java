package com.xnzygxpt.learning_data.dao.vo;

public class LearningData {

	private int learning_date;
	private String userid;
	private String classify;
	private String title;
	private String detail;
	private String keyword;
	private String data_name;
	private String data_time;
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getLearning_date() {
		return learning_date;
	}

	public void setLearning_date(int learning_date) {
		this.learning_date = learning_date;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getData_name() {
		return data_name;
	}

	public void setData_name(String data_name) {
		this.data_name = data_name;
	}

	public String getData_time() {
		return data_time;
	}

	public void setData_time(String data_time) {
		this.data_time = data_time;
	}

}