package com.chinasofti.travelmaster.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ShowCollections implements Serializable {
	private int colid;
	private int uid;
	private Date coldate;
	private int aid;
	private String aname;
	private String aprovince;
	private String acity;
	private int sum;
	private double comments;
	public ShowCollections() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowCollections(int colid, int uid, Date coldate, int aid,
			String aname, String aprovince, String acity, int sum,
			double comments) {
		super();
		this.colid = colid;
		this.uid = uid;
		this.coldate = coldate;
		this.aid = aid;
		this.aname = aname;
		this.aprovince = aprovince;
		this.acity = acity;
		this.sum = sum;
		this.comments = comments;
	}
	public int getColid() {
		return colid;
	}
	public void setColid(int colid) {
		this.colid = colid;
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
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAprovince() {
		return aprovince;
	}
	public void setAprovince(String aprovince) {
		this.aprovince = aprovince;
	}
	public String getAcity() {
		return acity;
	}
	public void setAcity(String acity) {
		this.acity = acity;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public double getComments() {
		return comments;
	}
	public void setComments(double comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "ShowCollections [colid=" + colid + ", uid=" + uid
				+ ", coldate=" + coldate + ", aid=" + aid + ", aname=" + aname
				+ ", aprovince=" + aprovince + ", acity=" + acity + ", sum="
				+ sum + ", comments=" + comments + "]";
	}
}
