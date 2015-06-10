package com.chinasofti.travelmaster.dao;

import java.util.List;

import com.chinasofti.travelmaster.po.Collections;

public interface ICollectionsDao {
	public abstract int insert(final Collections collection);
	public abstract int deleteById(final int colid);
	public abstract int update(final Collections collection);
	public abstract List<Collections> selectAll();
	public abstract Collections selectById(final int colid);
	
	public abstract List<Collections> selectByUid(final int uid);
	public abstract Collections selectByAidAndUid(final int aid,final int uid);
}
