package com.chinasofti.travelmaster.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class TransactionManger {
	public static Connection connection = null;
	private static ConnectionManger connectionManger = new ConnectionManger();
	
	public static void beginTransaction(){
		System.out.println("[TransactionManger]:启动设置事务为人工手动模式..."+new Date());
		try {
			connection.setAutoCommit(false);
			System.out.println("[TransactionManger]:设置事务为人工手动模式成功!"+new Date());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[TransactionManger]:设置事务为人工手动模式失败!"+new Date());
		}
	}
	
	public static void commit(){
		System.out.println("[TransactionManger]:启动事务提交操作..."+new Date());
		try {
			connection.commit();
			System.out.println("[TransactionManger]:事务提交操作成功!"+new Date());
			
			connectionManger.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[TransactionManger]:事务提交操作失败!"+new Date());
			
			connectionManger.closeConnection(connection);
		}
	}

	public static void rollback(){
		System.out.println("[TransactionManger]:启动事务回滚操作..."+new Date());
		try {
			connection.rollback();
			System.out.println("[TransactionManger]:事务回滚操作成功!"+new Date());
			
			connectionManger.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[TransactionManger]:事务回滚操作失败!"+new Date());
			
			connectionManger.closeConnection(connection);
		}
	}
}
