package com.chinasofti.travelmaster.dao;

import java.util.List;

import com.chinasofti.travelmaster.po.Attractions;

public interface IAttractionsDao {
	public abstract int insert(final Attractions attraction);
	public abstract int deleteById(final int aid);
	public abstract int update(final Attractions attraction);
	public abstract List<Attractions> selectAll();
	public abstract Attractions selectByName(final String aname);
	public abstract Attractions selectById(final int aid);
	public abstract List<Attractions> selectByLoc(final String aprovince,final String acity);
	public abstract List<Attractions> selectTop3();
}
