package com.chinasofti.travelmaster.dao;

import java.util.List;

import com.chinasofti.travelmaster.po.ShowRelations;

public interface IShowRelationsDao {
	public abstract List<ShowRelations> selectByUid(final int uid);
}
