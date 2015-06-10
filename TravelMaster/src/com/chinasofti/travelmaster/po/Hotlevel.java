package com.chinasofti.travelmaster.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Hotlevel implements Serializable {
	private int hid; //景点热度编号
	private int aid; //景点编号
	private int clickrate; //点击次数
	private int year; //年份
	private int month; //月份
	public Hotlevel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotlevel(int hid, int aid, int clickrate, int year, int month) {
		super();
		this.hid = hid;
		this.aid = aid;
		this.clickrate = clickrate;
		this.year = year;
		this.month = month;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getClickrate() {
		return clickrate;
	}
	public void setClickrate(int clickrate) {
		this.clickrate = clickrate;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "Hotlevel [hid=" + hid + ", aid=" + aid + ", clickrate="
				+ clickrate + ", year=" + year + ", month=" + month + "]";
	}
	

}
