package com.chinasofti.travelmaster.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ShowRelations implements Serializable {
	private int reid;
	private int uid;
	private int userid;
	private String uname;
	private Date regdate;
	private String usex;
	private String umark;
	public ShowRelations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowRelations(int reid, int uid, int userid, String uname,
			Date regdate, String usex, String umark) {
		super();
		this.reid = reid;
		this.uid = uid;
		this.userid = userid;
		this.uname = uname;
		this.regdate = regdate;
		this.usex = usex;
		this.umark = umark;
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUmark() {
		return umark;
	}
	public void setUmark(String umark) {
		this.umark = umark;
	}
	@Override
	public String toString() {
		return "ShowRelations [reid=" + reid + ", uid=" + uid + ", userid="
				+ userid + ", uname=" + uname + ", regdate=" + regdate
				+ ", usex=" + usex + ", umark=" + umark + "]";
	}
	
}
