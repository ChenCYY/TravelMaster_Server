package com.chinasofti.travelmaster.biz;

import com.chinasofti.travelmaster.po.Collections;


public interface ICollectionBiz {
	public abstract boolean add(final Collections collection);
	public abstract boolean removeById(final int colid);
	public abstract boolean isCollected(final int aid,final int uid);
}
