package com.chinasofti.travelmaster.service.impl;

import com.chinasofti.travelmaster.biz.IUsersBiz;
import com.chinasofti.travelmaster.biz.impl.UsersBizImpl;
import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.service.ILoginService;

public class LoginServiceImpl implements ILoginService {

	private IUsersBiz usersBiz;
	
	public LoginServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.usersBiz = new UsersBizImpl();
	}

	@Override
	public Users login(Users user) {
		// TODO Auto-generated method stub
		return this.usersBiz.isEqual(user);
	}

}
