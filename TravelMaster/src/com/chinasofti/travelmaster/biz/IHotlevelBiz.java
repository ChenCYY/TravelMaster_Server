package com.chinasofti.travelmaster.biz;

import java.util.List;

import com.chinasofti.travelmaster.po.Hotlevel;

public interface IHotlevelBiz {
	public abstract List<Hotlevel> selectAll(final int year,final int season);
	public abstract Hotlevel selectById(final int aid);

	public abstract int findByAid(final int aid);
	public abstract boolean updateClickRate(final int aid,final int year,final int season);
}
