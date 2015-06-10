package com.chinasofti.travelmaster.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Users implements Serializable {
	private int uid; //用户编号
	private String uname; //用户名
	private String upwd; //用户密码
	private String usex; //用户性别
	private String uemail; //用户邮箱
	private Date regdate; //注册时间
	private String umark; //用户备注
	private String uavatar; //用户头像
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
