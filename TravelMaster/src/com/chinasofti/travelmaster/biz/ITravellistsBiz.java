package com.chinasofti.travelmaster.biz;

import java.util.List;

import com.chinasofti.travelmaster.po.Travellists;

public interface ITravellistsBiz {
	public abstract int add(final Travellists travellist);
	public abstract List<Travellists> findByUid(final int uid);
	
	public abstract int modify(final Travellists travellist);
	public abstract int removeById(final int tid);
	public abstract Travellists findById(final int tid);
}
