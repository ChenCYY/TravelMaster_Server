package com.chinasofti.travelmaster.dao;

import java.util.List;

import com.chinasofti.travelmaster.po.Posts;

public interface IPostsDao {
	public abstract int insert(final Posts post);
	public abstract List<Posts> selectByFollowId(final int followid);
	public abstract List<Posts> selectByUpdate(final int followid);
	public abstract Posts selectById(final int id);
	
	public abstract List<Posts> selectByUid(final int uid);
}
