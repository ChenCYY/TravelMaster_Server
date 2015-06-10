package com.chinasofti.travelmaster.biz;

import com.chinasofti.travelmaster.po.Users;

public interface IUsersBiz {
	public abstract boolean isUniqueName(final Users user);
	public abstract boolean isUniqueEmail(final Users user);
	public abstract Users isEqual(final Users user);
	public abstract boolean add(final Users user);
	public abstract boolean update(final Users user);
	
	public abstract Users selectById(final int id);
	public abstract Users selectByName(final Users user);
}
