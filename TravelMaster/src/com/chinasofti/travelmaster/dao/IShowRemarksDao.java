package com.chinasofti.travelmaster.dao;

import java.util.List;

import com.chinasofti.travelmaster.po.ShowRemarks;

public interface IShowRemarksDao {
	public abstract List<ShowRemarks> selectByFollowidAndAid(final int followid,final int aid);
}
