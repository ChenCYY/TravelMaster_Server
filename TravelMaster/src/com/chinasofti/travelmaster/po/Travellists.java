package com.chinasofti.travelmaster.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Travellists implements Serializable {
	private int tid; //�ó̱��
	private int aid; //������
	private int uid; //�û����
	private String departure; //������
	private String way; //Ŀ�ĵ�
	private Date traveldate; //�û���������
	private String mark; //�ó̱�ע
	public Travellists() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Travellists(int tid, int aid, int uid, String departure, String way,
			Date traveldate, String mark) {
		super();
		this.tid = tid;
		this.aid = aid;
		this.uid = uid;
		this.departure = departure;
		this.way = way;
		this.traveldate = traveldate;
		this.mark = mark;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
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
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public Date getTraveldate() {
		return traveldate;
	}
	public void setTraveldate(Date traveldate) {
		this.traveldate = traveldate;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Travellists [tid=" + tid + ", aid=" + aid + ", uid=" + uid
				+ ", departure=" + departure + ", way=" + way + ", traveldate="
				+ traveldate + ", mark=" + mark + "]";
	}
	
}
