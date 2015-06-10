package com.chinasofti.travelmaster.service.impl;

import com.chinasofti.travelmaster.biz.ITravellistsBiz;
import com.chinasofti.travelmaster.biz.impl.TravellistsBizImpl;
import com.chinasofti.travelmaster.po.Travellists;
import com.chinasofti.travelmaster.service.IChangeTravellistsService;

public class ChangeTravellistsServiceImpl implements IChangeTravellistsService {

	private ITravellistsBiz travellistsBiz;
	
	public ChangeTravellistsServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.travellistsBiz = new TravellistsBizImpl();
	}



	@Override
	public int ChangeTravellists(Travellists travellist) {
		// TODO Auto-generated method stub
		return travellistsBiz.modify(travellist);
	}

}
