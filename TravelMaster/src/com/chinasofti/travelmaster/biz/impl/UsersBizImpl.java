package com.chinasofti.travelmaster.biz.impl;

import com.chinasofti.travelmaster.biz.IUsersBiz;
import com.chinasofti.travelmaster.dao.IUsersDao;
import com.chinasofti.travelmaster.dao.impl.UsersDaoImpl;
import com.chinasofti.travelmaster.po.Users;

public class UsersBizImpl implements IUsersBiz {

	private IUsersDao usersDao;
	
	public UsersBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		usersDao = new UsersDaoImpl();
	}

	@Override
	public boolean add(Users user) {
		// TODO Auto-generated method stub
		return this.usersDao.insert(user) > 0 ? true : false;
	}
	
	@Override
	public boolean update(Users user) {
		// TODO Auto-generated method stub
		return this.usersDao.update(user) > 0 ? true : false;
	}

	@Override
	public boolean isUniqueName(Users user) {
		// TODO Auto-generated method stub
		return this.usersDao.selectByName(user) == null ? true : false;
	}

	@Override
	public boolean isUniqueEmail(Users user) {
		// TODO Auto-generated method stub
		return this.usersDao.selectByEmail(user.getUemail()) == null ? true : false;
	}

	@Override
	public Users isEqual(Users user) {
		// TODO Auto-generated method stub
		return this.usersDao.selectByNameAndPwd(user);
	}

	@Override
	public Users selectById(int id) {
		// TODO Auto-generated method stub
		return usersDao.selectById(id);
	}

	@Override
	public Users selectByName(Users user) {
		// TODO Auto-generated method stub
		return usersDao.selectByName(user);
	}

}
