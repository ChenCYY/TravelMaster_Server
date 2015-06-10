package com.chinasofti.travelmaster.biz;

import java.util.List;

import com.chinasofti.travelmaster.po.Posts;

public interface IPostsBiz {
	public abstract boolean add(final Posts post);
	public abstract List<Posts> selectPost(final int followid);
	public abstract List<Posts> selectReply(final int followid);
	public abstract Posts selectById(final int id);
	
	public abstract List<Posts> findByUid(final int uid);
}
