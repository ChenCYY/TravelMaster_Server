package com.chinasofti.travelmaster.biz;

import com.chinasofti.travelmaster.po.Relations;

public interface IRelationsBiz {
	public abstract boolean insert(final Relations relation);
	public abstract boolean isAdded(final Relations relation);
	public abstract boolean removeById(final int reid);
}
