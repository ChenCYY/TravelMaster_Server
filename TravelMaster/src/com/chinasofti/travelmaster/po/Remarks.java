package com.chinasofti.travelmaster.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Remarks implements Serializable {
	private int remarkid; //评论编号
	private int aid; //评论的景点编号
	private int uid; //评论用户id
	private String remarkcontext; //评论内容
	private Date publish; //评论时间
	private int followid; //这条评论回复的评论编号
	public Remarks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Remarks(int remarkid, int aid, int uid, String remarkcontext,
			Date publish, int followid) {
		super();
		this.remarkid = remarkid;
		this.aid = aid;
		this.uid = uid;
		this.remarkcontext = remarkcontext;
		this.publish = publish;
		this.followid = followid;
	}
	public int getRemarkid() {
		return remarkid;
	}
	public void setRemarkid(int remarkid) {
		this.remarkid = remarkid;
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
	public String getRemarkcontext() {
		return remarkcontext;
	}
	public void setRemarkcontext(String remarkcontext) {
		this.remarkcontext = remarkcontext;
	}
	public Date getPublish() {
		return publish;
	}
	public void setPublish(Date publish) {
		this.publish = publish;
	}
	public int getFollowid() {
		return followid;
	}
	public void setFollowid(int followid) {
		this.followid = followid;
	}
	@Override
	public String toString() {
		return "Remarks [remarkid=" + remarkid + ", aid=" + aid + ", uid="
				+ uid + ", remarkcontext=" + remarkcontext + ", publish="
				+ publish + ", followid=" + followid + "]";
	}
	
}
