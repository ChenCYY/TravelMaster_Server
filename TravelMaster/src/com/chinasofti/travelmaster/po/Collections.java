package com.chinasofti.travelmaster.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Collections implements Serializable {
	private int colid; //收藏编号
	private int aid; //景点编号
	private int uid; //用户编号
	private Date coldate; //收藏时间
	public Collections() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collections(int colid, int aid, int uid, Date coldate) {
		super();
		this.colid = colid;
		this.aid = aid;
		this.uid = uid;
		this.coldate = coldate;
	}
	public int getColid() {
		return colid;
	}
	public void setColid(int colid) {
		this.colid = colid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Date getColdate() {
		return coldate;
	}
	public void setColdate(Date coldate) {
		this.coldate = coldate;
	}
	@Override
	public String toString() {
		return "Collections [colid=" + colid + ", aid=" + aid + ", uid=" + uid
				+ ", coldate=" + coldate + "]";
	}
	
	

}
