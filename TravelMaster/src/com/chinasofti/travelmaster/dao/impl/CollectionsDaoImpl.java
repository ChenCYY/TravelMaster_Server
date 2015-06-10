package com.chinasofti.travelmaster.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.travelmaster.dao.ICollectionsDao;
import com.chinasofti.travelmaster.db.ConnectionManger;
import com.chinasofti.travelmaster.db.DBUtils;
import com.chinasofti.travelmaster.db.TransactionManger;
import com.chinasofti.travelmaster.po.Collections;

public class CollectionsDaoImpl implements ICollectionsDao {

	private ConnectionManger connectionManger;
	private DBUtils dbUtils;
	
	public CollectionsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		connectionManger = new ConnectionManger();
		dbUtils = new DBUtils();
	}

	@Override
	public int insert(Collections collection) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();
		
		int affectedRows = this.dbUtils.execOthers(conn,
				"insert into collections values(null,?,?,now())", new Object[] {
						collection.getAid(), collection.getUid() });
	
		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public int deleteById(int colid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();
		
		int affectedRows = this.dbUtils
				.execOthers(conn, "delete from collections where colid=?",
						new Object[] { colid });

		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public int update(Collections collection) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils.execOthers(conn,
				"update collections set aid=?,uid=?,coldate=? where colid=?",
				new Object[] { collection.getAid(), collection.getUid(),
						collection.getColid(),collection.getColdate() });

		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public List<Collections> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from collections order by colid", new Object[] {});
		List<Collections> lstCollections = new ArrayList<Collections>();
		try {
			while (resultSet.next()) {
				lstCollections.add(new Collections(resultSet.getInt(1),
						resultSet.getInt(2), resultSet.getInt(3),resultSet.getDate(4)));
			}
			return lstCollections;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

	@Override
	public Collections selectById(int colid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from collections where colid=?",
				new Object[] { colid });

		try {
			if (resultSet.next()) {
				return new Collections(resultSet.getInt(1),
						resultSet.getInt(2), resultSet.getInt(3),resultSet.getDate(4));
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

	@Override
	public List<Collections> selectByUid(int uid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from collections where uid=? order by colid", new Object[] {uid});
		List<Collections> lstCollections = new ArrayList<Collections>();
		try {
			while (resultSet.next()) {
				lstCollections.add(new Collections(resultSet.getInt(1),
						resultSet.getInt(2), resultSet.getInt(3),resultSet.getDate(4)));
			}
			return lstCollections;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

	@Override
	public Collections selectByAidAndUid(int aid, int uid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from collections where aid=? and uid=?",
				new Object[] { aid,uid });

		try {
			if (resultSet.next()) {
				return new Collections(resultSet.getInt(1),
						resultSet.getInt(2), resultSet.getInt(3),resultSet.getDate(4));
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

}
