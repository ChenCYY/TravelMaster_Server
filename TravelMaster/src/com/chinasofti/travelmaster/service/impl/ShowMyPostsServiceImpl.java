package com.chinasofti.travelmaster.service.impl;

import java.util.List;

import com.chinasofti.travelmaster.biz.IPostsBiz;
import com.chinasofti.travelmaster.biz.impl.PostsBizImpl;
import com.chinasofti.travelmaster.po.Posts;
import com.chinasofti.travelmaster.service.IShowMyPostsService;

public class ShowMyPostsServiceImpl implements IShowMyPostsService {

	private IPostsBiz postsBiz;
	
	public ShowMyPostsServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.postsBiz = new PostsBizImpl();
	}

	@Override
	public List<Posts> showMyPosts(int uid) {
		// TODO Auto-generated method stub
		return this.postsBiz.findByUid(uid);
	}

}
