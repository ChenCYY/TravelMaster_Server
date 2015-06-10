package com.chinasofti.travelmaster.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class ConnectionManger {
	
	public Connection openConnection(){
		try {
			System.out.println("[ConnectionManger]:�����ݿ����Ӷ���..."+new Date());
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection("jdbc:mysql://" + DBConfig.IP
					+ ":" + DBConfig.PORT + "/" + DBConfig.DBNAME,
					DBConfig.USERNAME, DBConfig.PASSWORD);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[ConnectionManger]:�����ݿ����Ӷ���ʧ��!"+new Date());
			return null;
		}
	}
	
	public void closeConnection(Connection connection){
		if(connection != null){
			try {
				System.out.println("[ConnectionManger]:�ر����ݿ����Ӷ���..."+new Date());
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[ConnectionManger]:�ر����ݿ����Ӷ���ʧ��!"+new Date());
			}
		}
		
	}

}
