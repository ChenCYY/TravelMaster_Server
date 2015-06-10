package com.chinasofti.travelmaster.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class TransactionManger {
	public static Connection connection = null;
	private static ConnectionManger connectionManger = new ConnectionManger();
	
	public static void beginTransaction(){
		System.out.println("[TransactionManger]:������������Ϊ�˹��ֶ�ģʽ..."+new Date());
		try {
			connection.setAutoCommit(false);
			System.out.println("[TransactionManger]:��������Ϊ�˹��ֶ�ģʽ�ɹ�!"+new Date());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[TransactionManger]:��������Ϊ�˹��ֶ�ģʽʧ��!"+new Date());
		}
	}
	
	public static void commit(){
		System.out.println("[TransactionManger]:���������ύ����..."+new Date());
		try {
			connection.commit();
			System.out.println("[TransactionManger]:�����ύ�����ɹ�!"+new Date());
			
			connectionManger.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[TransactionManger]:�����ύ����ʧ��!"+new Date());
			
			connectionManger.closeConnection(connection);
		}
	}

	public static void rollback(){
		System.out.println("[TransactionManger]:��������ع�����..."+new Date());
		try {
			connection.rollback();
			System.out.println("[TransactionManger]:����ع������ɹ�!"+new Date());
			
			connectionManger.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[TransactionManger]:����ع�����ʧ��!"+new Date());
			
			connectionManger.closeConnection(connection);
		}
	}
}
