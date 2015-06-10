package com.chinasofti.travelmaster.service.impl;

import java.util.List;

import com.chinasofti.travelmaster.biz.IAttractionsBiz;
import com.chinasofti.travelmaster.biz.impl.AttractionsBizImpl;
import com.chinasofti.travelmaster.po.Attractions;
import com.chinasofti.travelmaster.service.IShowHotService;

public class ShowHotServiceImpl implements IShowHotService {

	private IAttractionsBiz attractionsBiz;
	
	public ShowHotServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.attractionsBiz = new AttractionsBizImpl();
	}

	@Override
	public List<Attractions> showHotAttractions() {
		// TODO Auto-generated method stub
		return this.attractionsBiz.findTop3();
	}

}
