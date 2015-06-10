package com.chinasofti.travelmaster.biz.impl;

import java.util.List;

import com.chinasofti.travelmaster.biz.ITravellistsBiz;
import com.chinasofti.travelmaster.dao.ITravellistsDao;
import com.chinasofti.travelmaster.dao.impl.TravellistsDaoImpl;
import com.chinasofti.travelmaster.po.Travellists;

public class TravellistsBizImpl implements ITravellistsBiz {

	private ITravellistsDao travellistsDao;
	
	public TravellistsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.travellistsDao = new TravellistsDaoImpl();
	}

	@Override
	public int add(Travellists travellist) {
		// TODO Auto-generated method stub
		return travellistsDao.insert(travellist);
	}

	@Override
	public List<Travellists> findByUid(int uid) {
		// TODO Auto-generated method stub
		return travellistsDao.selectByUid(uid);
	}

	@Override
	public int modify(Travellists travellist) {
		// TODO Auto-generated method stub
		return travellistsDao.update(travellist);
	}

	@Override
	public Travellists findById(int tid) {
		// TODO Auto-generated method stub
		return travellistsDao.selectById(tid);
	}

	@Override
	public int removeById(int tid) {
		// TODO Auto-generated method stub
		return travellistsDao.deleteById(tid);
	}

}
