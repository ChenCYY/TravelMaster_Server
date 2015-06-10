package com.chinasofti.travelmaster.service.impl;

import java.util.List;

import com.chinasofti.travelmaster.biz.ITravellistsBiz;
import com.chinasofti.travelmaster.biz.impl.TravellistsBizImpl;
import com.chinasofti.travelmaster.po.Travellists;
import com.chinasofti.travelmaster.service.IShowTravellistsService;

public class ShowTravellistsServiceImpl implements IShowTravellistsService {

	private ITravellistsBiz travellistsBiz;
	
	public ShowTravellistsServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.travellistsBiz = new TravellistsBizImpl();
	}

	@Override
	public List<Travellists> showTravellistsByUid(int uid) {
		// TODO Auto-generated method stub
		return travellistsBiz.findByUid(uid);
	}

	@Override
	public Travellists showTravellistsByTid(int tid) {
		// TODO Auto-generated method stub
		return travellistsBiz.findById(tid);
	}

}
