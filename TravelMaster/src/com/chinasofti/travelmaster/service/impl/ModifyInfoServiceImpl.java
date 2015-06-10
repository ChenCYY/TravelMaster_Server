package com.chinasofti.travelmaster.service.impl;

import com.chinasofti.travelmaster.biz.IUsersBiz;
import com.chinasofti.travelmaster.biz.impl.UsersBizImpl;
import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.service.IModifyInfoService;

public class ModifyInfoServiceImpl implements IModifyInfoService {

	private IUsersBiz usersBiz;
	
	public ModifyInfoServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.usersBiz = new UsersBizImpl();
	}

	@Override
	public boolean modifyInfo(Users user) {
		// TODO Auto-generated method stub
		return usersBiz.update(user);
	}

}
