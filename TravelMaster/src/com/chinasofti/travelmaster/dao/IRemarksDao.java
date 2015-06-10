package com.chinasofti.travelmaster.dao;

import java.util.List;

import com.chinasofti.travelmaster.po.Remarks;

public interface IRemarksDao {
	public abstract int insert(final Remarks remark);
	public abstract int deleteById(final int remarkid);
	public abstract int update(final Remarks remark);
	public abstract List<Remarks> selectAll();
	public abstract Remarks selectById(final int remarkid);
	
	public abstract List<Remarks> selectByFollowidAndAid(final int followid,final int aid);
}
