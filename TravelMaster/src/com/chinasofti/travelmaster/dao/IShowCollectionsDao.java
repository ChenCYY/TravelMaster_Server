package com.chinasofti.travelmaster.dao;

import java.util.List;

import com.chinasofti.travelmaster.po.ShowCollections;

public interface IShowCollectionsDao {
	public abstract List<ShowCollections> selectByUid(final int uid);
}
