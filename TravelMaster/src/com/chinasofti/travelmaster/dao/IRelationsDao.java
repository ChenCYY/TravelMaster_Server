package com.chinasofti.travelmaster.dao;

import java.util.List;

import com.chinasofti.travelmaster.po.Relations;

public interface IRelationsDao {
	public abstract int insert(final Relations relation);
	public abstract int deleteById(final int reid);
	public abstract int update(final Relations relation);
	public abstract List<Relations> selectAll();
	public abstract Relations selectById(final int reid);
	
	public abstract boolean isAdded(final Relations relation);
}
