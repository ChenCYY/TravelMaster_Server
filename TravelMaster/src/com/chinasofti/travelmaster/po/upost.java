package com.chinasofti.travelmaster.po;

import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("serial")
public class upost implements Serializable {
	private int pid;
	private int uid;
	private int replynum;
	private Date postdate;
	private String contents;
	private int pfollowid;
	private String ptitle;
	private String resources;
	private Date latestreply;
	private String uname;
	private String uavatar;
	@Override
	public String toString() {
		return "upost [pid=" + pid + ", uid=" + uid + ", replynum=" + replynum
				+ ", postdate=" + postdate + ", contents=" + contents
				+ ", pfollowid=" + pfollowid + ", ptitle=" + ptitle
				+ ", resources=" + resources + ", latestreply=" + latestreply
				+ ", uname=" + uname + ", uavatar=" + uavatar + "]";
	}
	public upost(int pid, int uid, int replynum, Date postdate,
			String contents, int pfollowid, String ptitle, String resources,
			Date latestreply, String uname, String uavatar) {
		super();
		this.pid = pid;
		this.uid = uid;
		this.replynum = replynum;
		this.postdate = postdate;
		this.contents = contents;
		this.pfollowid = pfollowid;
		this.ptitle = ptitle;
		this.resources = resources;
		this.latestreply = latestreply;
		this.uname = uname;
		this.uavatar = uavatar;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getReplynum() {
		return replynum;
	}
	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getPfollowid() {
		return pfollowid;
	}
	public void setPfollowid(int pfollowid) {
		this.pfollowid = pfollowid;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getResources() {
		return resources;
	}
	public void setResources(String resources) {
		this.resources = resources;
	}
	public Date getLatestreply() {
		return latestreply;
	}
	public void setLatestreply(Date latestreply) {
		this.latestreply = latestreply;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUavatar() {
		return uavatar;
	}
	public void setUavatar(String uavatar) {
		this.uavatar = uavatar;
	}
	public upost() {
		super();
		// TODO Auto-generated constructor stub
	}
}
