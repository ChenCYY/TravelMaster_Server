package com.chinasofti.travelmaster.service;

import java.util.List;

import com.chinasofti.travelmaster.po.Posts;

public interface IShowMyPostsService {
	public abstract List<Posts> showMyPosts(final int uid);
}
