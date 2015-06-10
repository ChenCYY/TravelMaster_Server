package com.chinasofti.travelmaster.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Users implements Serializable {
	private int uid; //�û����
	private String uname; //�û���
	private String upwd; //�û�����
	private String usex; //�û��Ա�
	private String uemail; //�û�����
	private Date regdate; //ע��ʱ��
	private String umark; //�û���ע
	private String uavatar; //�û�ͷ��
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int uid, String uname, String upwd, String usex,
			String uemail, Date regdate, String umark, String uavatar) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.usex = usex;
		this.uemail = uemail;
		this.regdate = regdate;
		this.umark = umark;
		this.uavatar = uavatar;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getUmark() {
		return umark;
	}
	public void setUmark(String umark) {
		this.umark = umark;
	}
	public String getUavatar() {
		return uavatar;
	}
	public void setUavatar(String uavatar) {
		this.uavatar = uavatar;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd
				+ ", usex=" + usex + ", uemail=" + uemail + ", regdate="
				+ regdate + ", umark=" + umark + ", uavatar=" + uavatar + "]";
	}
	
}
