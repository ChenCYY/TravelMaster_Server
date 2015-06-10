package com.chinasofti.travelmaster.service.impl;

import com.chinasofti.travelmaster.biz.IUsersBiz;
import com.chinasofti.travelmaster.biz.impl.UsersBizImpl;
import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.service.IRegisterService;

public class RegisterServiceImpl implements IRegisterService {

	private IUsersBiz usersBiz;
	
	public RegisterServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.usersBiz = new UsersBizImpl();
	}

	@Override
	public int addUsers(Users user) {
		// TODO Auto-generated method stub
		if(this.usersBiz.isUniqueName(user)){
			if(this.usersBiz.isUniqueEmail(user)){
				if(this.usersBiz.add(user)){
					return 1;  //注册成功
				}else return -1;  //用户添加失败	
			}else return -2;  //注册邮箱重复
		}else return -3; //用户名重复
	}

}
