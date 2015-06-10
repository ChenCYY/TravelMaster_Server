package com.chinasofti.travelmaster.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.travelmaster.dao.IRelationsDao;
import com.chinasofti.travelmaster.db.ConnectionManger;
import com.chinasofti.travelmaster.db.DBUtils;
import com.chinasofti.travelmaster.db.TransactionManger;
import com.chinasofti.travelmaster.po.Relations;

public class RelationsDaoImpl implements IRelationsDao {

	private ConnectionManger connectionManger;
	private DBUtils dbUtils;
	
	public RelationsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		connectionManger = new ConnectionManger();
		dbUtils = new DBUtils();
	}

	@Override
	public int insert(Relations relation) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils.execOthers(conn,
				"insert into relations values(null,?,?)", new Object[] {
						relation.getUid(), relation.getUserid() });

		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public int deleteById(int reid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils.execOthers(conn,
				"delete from relations where reid=?", new Object[] { reid });

		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public int update(Relations relation) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils.execOthers(conn,
				"update relations set uid=?,userid=? where reid=?",
				new Object[] { relation.getUid(), relation.getUserid(),
						relation.getReid() });

		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public List<Relations> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from relations order by reid", new Object[] {});
		List<Relations> lstRelations = new ArrayList<Relations>();
		try {
			while (resultSet.next()) {
				lstRelations.add(new Relations(resultSet.getInt(1),
						resultSet.getInt(2), resultSet.getInt(3)));
			}
			return lstRelations;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

	@Override
	public Relations selectById(int reid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from relations where reid=?", new Object[] { reid });

		try {
			if (resultSet.next()) {
				return new Relations(resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getInt(3));
			} else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

	@Override
	public boolean isAdded(Relations relation) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from relations where  uid=? and userid=?", new Object[] { relation.getUid(),relation.getUserid() });

		try {
			if (resultSet.next()) {
				return true;
			} else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

}
