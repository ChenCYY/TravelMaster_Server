package com.chinasofti.travelmaster.db;

import java.io.IOException;
import java.util.Properties;

/**
 * 名称：DBConfig
 * 功能：实现数据库的配置
 * 作者：陈圣泓
 * 时间：2014-7-30 13:10
 * */
public class DBConfig {
	private static final Properties properties = new Properties();
	
	// 静态块，加载属性配置文件
	static{
		try {	
			properties.load(DBConfig.class.getResourceAsStream("db.cfg.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static final String IP=properties.getProperty("IP");
	public static final String PORT=properties.getProperty("PORT");
	public static final String DBNAME=properties.getProperty("DBNAME");
	public static final String USERNAME=properties.getProperty("USERNAME");
	public static final String PASSWORD=properties.getProperty("PASSWORD");
	
}
