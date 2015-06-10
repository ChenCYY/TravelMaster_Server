package com.chinasofti.travelmaster.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Relations implements Serializable {
	private int reid; //��ע���
	private int uid; //��ע�û�
	private int userid; //����ע�û�
	public Relations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Relations(int reid, int uid, int userid) {
		super();
		this.reid = reid;
		this.uid = uid;
		this.userid = userid;
	}
	public int getReid() {
		return reid;
	}
	public void setReid(int reid) {
		this.reid = reid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Relations [reid=" + reid + ", uid=" + uid + ", userid="
				+ userid + "]";
	}
	
}
