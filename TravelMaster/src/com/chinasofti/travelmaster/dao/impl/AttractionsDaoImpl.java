package com.chinasofti.travelmaster.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.travelmaster.dao.IAttractionsDao;
import com.chinasofti.travelmaster.db.ConnectionManger;
import com.chinasofti.travelmaster.db.DBUtils;
import com.chinasofti.travelmaster.db.TransactionManger;
import com.chinasofti.travelmaster.po.Attractions;

public class AttractionsDaoImpl implements IAttractionsDao {
	
	private ConnectionManger connectionManger;
	private DBUtils dbUtils;
	
	public AttractionsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		connectionManger = new ConnectionManger();
		dbUtils = new DBUtils();
	}

	@Override
	public int insert(Attractions attraction) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();
		
		int affectedRows = this.dbUtils.execOthers(conn,
				"insert into attractions values(null,?,?,?,?,?,?,?)",
				new Object[] { attraction.getAname(),
						attraction.getAprovince(), attraction.getAcity(),
						attraction.getSum(), attraction.getComments(),
						attraction.getResourceids(),attraction.getContext() });
	
		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public int deleteById(int aid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();
		
		int affectedRows = this.dbUtils.execOthers(conn,
				"delete from attractions where aid=?", new Object[] { aid });
		
		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public int update(Attractions attraction) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils
				.execOthers(
						conn,
						"update attractions set aname=?,aprovince=?,acity=?,sum=?,comments=?,resourceids=?,context=? where aid=?",
						new Object[] { attraction.getAname(),
								attraction.getAprovince(),
								attraction.getAcity(), attraction.getSum(),
								attraction.getComments(),
								attraction.getResourceids(),
								attraction.getAid(),
								attraction.getContext()});

		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public List<Attractions> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		
		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from attractions order by aid", new Object[] {});
		List<Attractions> lstAttractions = new ArrayList<Attractions>();
		try {
			while (resultSet.next()) {
				lstAttractions.add(new Attractions(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet
								.getDouble(6), resultSet.getString(7),resultSet.getString(8)));
			}
			return lstAttractions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

	@Override
	public Attractions selectByName(String aname) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from attractions where aname=?", new Object[] { aname });

		try {
			if (resultSet.next()) {
				return new Attractions(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5),
						resultSet.getDouble(6), resultSet.getString(7),resultSet.getString(8));
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
	public List<Attractions> selectTop3() {
		// TODO Auto-generated method stub
Connection conn = connectionManger.openConnection();
		
		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from attractions order by sum desc limit 3", new Object[] {});
		List<Attractions> lstAttractions = new ArrayList<Attractions>();
		try {
			while (resultSet.next()) {
				lstAttractions.add(new Attractions(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet
								.getDouble(6), resultSet.getString(7),
								resultSet.getString(8)));
			}
			return lstAttractions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

	@Override
	public Attractions selectById(int aid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from attractions where aid=?", new Object[] { aid });

		try {
			if (resultSet.next()) {
				return new Attractions(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5),
						resultSet.getDouble(6), resultSet.getString(7),resultSet.getString(8));
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
	public List<Attractions> selectByLoc(String aprovince, String acity) {
		// TODO Auto-generated method stub
Connection conn = connectionManger.openConnection();
		
		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from attractions where aprovince=? and acity=?", new Object[] {aprovince,acity});
		List<Attractions> lstAttractions = new ArrayList<Attractions>();
		try {
			while (resultSet.next()) {
				lstAttractions.add(new Attractions(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet
								.getDouble(6), resultSet.getString(7),
								resultSet.getString(8)));
			}
			return lstAttractions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

}
