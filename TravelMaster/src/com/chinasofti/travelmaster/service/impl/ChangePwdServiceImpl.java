package com.chinasofti.travelmaster.service.impl;

import com.chinasofti.travelmaster.biz.IUsersBiz;
import com.chinasofti.travelmaster.biz.impl.UsersBizImpl;
import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.service.IChangePwdService;

public class ChangePwdServiceImpl implements IChangePwdService {

	private IUsersBiz usersBiz;
	
	public ChangePwdServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		usersBiz = new UsersBizImpl();
	}

	@Override
	public int changePwd(Users user, String pass) {
		// TODO Auto-generated method stub
		if( usersBiz.isEqual(user)!= null){
			user.setUpwd(pass);
			if(usersBiz.update(user))
				return 1;
			else return -2; //ÃÜÂëĞŞ¸ÄÊ§°Ü
		}else return -1;  //Ô­ÃÜÂë´íÎó
	}

}
