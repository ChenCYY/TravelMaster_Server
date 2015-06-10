package com.chinasofti.travelmaster.biz.impl;

import java.util.List;

import com.chinasofti.travelmaster.biz.IPostsBiz;
import com.chinasofti.travelmaster.dao.IPostsDao;
import com.chinasofti.travelmaster.dao.impl.PostsDaoImpl;
import com.chinasofti.travelmaster.po.Posts;

public class PostsBizImpl implements IPostsBiz {

	private IPostsDao postDao;

	public PostsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.postDao=new PostsDaoImpl();
	}
	
	@Override
	public boolean add(Posts post) {
		// TODO Auto-generated method stub
		return postDao.insert(post)>0?true:false;
	}

	@Override
	public List<Posts> selectPost(int followid) {
		// TODO Auto-generated method stub
		return postDao.selectByUpdate(followid);
	}

	@Override
	public List<Posts> selectReply(int followid) {
		// TODO Auto-generated method stub
		return postDao.selectByFollowId(followid);
	}

	@Override
	public Posts selectById(int id) {
		// TODO Auto-generated method stub
		return postDao.selectById(id);
	}

	@Override
	public List<Posts> findByUid(int uid) {
		// TODO Auto-generated method stub
		return postDao.selectByUid(uid);
	}

}
