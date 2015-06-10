package com.chinasofti.travelmaster.biz.impl;

import java.util.List;

import com.chinasofti.travelmaster.biz.IAttractionsBiz;
import com.chinasofti.travelmaster.dao.IAttractionsDao;
import com.chinasofti.travelmaster.dao.impl.AttractionsDaoImpl;
import com.chinasofti.travelmaster.po.Attractions;

public class AttractionsBizImpl implements IAttractionsBiz {

	private IAttractionsDao attractionsDao;
	
	public AttractionsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.attractionsDao = new AttractionsDaoImpl();
	}

	@Override
	public List<Attractions> findTop3() {
		// TODO Auto-generated method stub
		return this.attractionsDao.selectTop3();
	}

	@Override
	public Attractions selectByName(String oaname) {
		// TODO Auto-generated method stub
		return attractionsDao.selectByName(oaname);
	}

	@Override
	public Attractions selectById(int id) {
		// TODO Auto-generated method stub
		return attractionsDao.selectById(id);
	}

	@Override
	public List<Attractions> selectByLoc(String approvince, String acity) {
		// TODO Auto-generated method stub
		return attractionsDao.selectByLoc(approvince, acity);
	}

	

}
