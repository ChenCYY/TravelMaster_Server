package com.chinasofti.travelmaster.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtils {

	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	//ʵ�ֶ����ݿ����ɾ�Ĳ���
	public int execOthers(final Connection connection,final String strSQL,final Object...params){
		try {
			System.out.println("[DBUtils]:MySQL:>"+strSQL);
			for (int i = 0; i < params.length; i++) {
				System.out.println("[DBUtils]:params:>"+params[i]+"\t");
			}
			//ʵ����preparedStatement����
			this.preparedStatement=connection.prepareStatement(strSQL);
			for (int j = 0; j < params.length; j++) {
				this.preparedStatement.setObject(j+1, params[j]);
			}
			
			return this.preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return -1;
		}
	}
	
	//ʵ�ֶ����ݿ�Ĳ�ѯ����
	public ResultSet execQuery(final Connection connection,final String strSQL,final Object...params){
		try {
			System.out.println("[DBUtils]:MySQL:>"+strSQL);
			for (int i = 0; i < params.length; i++) {
				System.out.println("[DBUtils]:params:>"+params[i]+"\t");
			}
			
			this.preparedStatement=connection.prepareStatement(strSQL);
			for (int j = 0; j < params.length; j++) {
				this.preparedStatement.setObject(j+1, params[j]);
			}
			this.resultSet = this.preparedStatement.executeQuery();
			
			return this.resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
	}

}
