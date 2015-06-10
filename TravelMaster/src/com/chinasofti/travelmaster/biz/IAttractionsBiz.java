package com.chinasofti.travelmaster.biz;

import java.util.List;

import com.chinasofti.travelmaster.po.Attractions;

public interface IAttractionsBiz {
	public abstract List<Attractions> findTop3();
	public abstract Attractions selectByName(final String oaname);
	public abstract Attractions selectById(final int id);
	public abstract List<Attractions> selectByLoc(final String approvince,final String acity);
}
