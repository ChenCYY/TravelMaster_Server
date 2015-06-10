package com.chinasofti.travelmaster.dao;

import java.util.List;

import com.chinasofti.travelmaster.po.Travellists;

public interface ITravellistsDao {
	public abstract int insert(final Travellists travellist);
	public abstract int deleteById(final int tid);
	public abstract int update(final Travellists travellist);
	public abstract List<Travellists> selectAll();
	public abstract Travellists selectById(final int tid);
	
	public abstract List<Travellists> selectByUid(final int uid);
}
