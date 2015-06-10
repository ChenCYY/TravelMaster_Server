package com.chinasofti.travelmaster.dao;

import java.util.List;

import com.chinasofti.travelmaster.po.Hotlevel;

public interface IHotlevelDao {
	public abstract int insert(final Hotlevel hotlevel);
	public abstract int deleteById(final int hid);
	public abstract int update(final Hotlevel hotlevel);
	public abstract List<Hotlevel> selectAll(final int year, final int season);
	public abstract Hotlevel selectById(final int hid);
	
	public abstract int selectByAid(final int aid);
	public abstract Hotlevel isExist(final int aid,final int year,final int season);
}
