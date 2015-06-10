package com.chinasofti.travelmaster.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Remarks implements Serializable {
	private int remarkid; //���۱��
	private int aid; //���۵ľ�����
	private int uid; //�����û�id
	private String remarkcontext; //��������
	private Date publish; //����ʱ��
	private int followid; //�������ۻظ������۱��
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
