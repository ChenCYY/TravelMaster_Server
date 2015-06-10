package com.chinasofti.travelmaster.service.impl;

import com.chinasofti.travelmaster.biz.ITravellistsBiz;
import com.chinasofti.travelmaster.biz.impl.TravellistsBizImpl;
import com.chinasofti.travelmaster.po.Travellists;
import com.chinasofti.travelmaster.service.IAddTravellistsService;

public class AddTravellistsServiceImpl implements IAddTravellistsService {

	private ITravellistsBiz travellistsBiz;
	
	public AddTravellistsServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.travellistsBiz = new TravellistsBizImpl();
	}

	@Override
	public boolean addTravellistsService(Travellists travellist) {
		// TODO Auto-generated method stub
		return this.travellistsBiz.add(travellist) > 0 ? true : false;
	}

}
