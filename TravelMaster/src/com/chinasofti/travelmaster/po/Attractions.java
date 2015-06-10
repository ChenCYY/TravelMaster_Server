package com.chinasofti.travelmaster.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Attractions implements Serializable {
	private int aid; //景点编号
	private String aname; //景点名称
	private String aprovince; //所在省份
	private String acity; //所在市
	private int sum; //评价数
	private double comments; //好评度
	private String resourceids; //景点资源编号组合
	private String context; //景点介绍内容
	public Attractions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Attractions(int aid, String aname, String aprovince, String acity,
			int sum, double comments, String resourceids, String context) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.aprovince = aprovince;
		this.acity = acity;
		this.sum = sum;
		this.comments = comments;
		this.resourceids = resourceids;
		this.context = context;
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
	public String getResourceids() {
		return resourceids;
	}
	public void setResourceids(String resourceids) {
		this.resourceids = resourceids;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Override
	public String toString() {
		return "Attractions [aid=" + aid + ", aname=" + aname + ", aprovince="
				+ aprovince + ", acity=" + acity + ", sum=" + sum
				+ ", comments=" + comments + ", resourceids=" + resourceids
				+ ", context=" + context + "]";
	}
	
}
