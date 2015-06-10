package com.chinasofti.travelmaster.dao;

import java.util.List;

import com.chinasofti.travelmaster.po.Users;

public interface IUsersDao {
	public abstract int insert(final Users user);
	public abstract int deleteById(final int uid);
	public abstract int update(final Users user);
	public abstract List<Users> selectAll();
	public abstract Users selectById(final int uid);
	
	public abstract Users selectByName(final Users user);
	public abstract Users selectByEmail(final String uemail);
	public abstract Users selectByNameAndPwd(final Users user);
}
