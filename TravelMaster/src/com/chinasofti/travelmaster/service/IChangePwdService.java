package com.chinasofti.travelmaster.service;

import com.chinasofti.travelmaster.po.Users;

public interface IChangePwdService {
	public abstract int changePwd(final Users user,final String pass);
}
