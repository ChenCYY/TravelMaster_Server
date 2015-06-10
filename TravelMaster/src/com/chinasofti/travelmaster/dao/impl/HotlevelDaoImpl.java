package com.chinasofti.travelmaster.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.travelmaster.dao.IHotlevelDao;
import com.chinasofti.travelmaster.db.ConnectionManger;
import com.chinasofti.travelmaster.db.DBUtils;
import com.chinasofti.travelmaster.db.TransactionManger;
import com.chinasofti.travelmaster.po.Hotlevel;

public class HotlevelDaoImpl implements IHotlevelDao {

	private ConnectionManger connectionManger;
	private DBUtils dbUtils;
	
	public HotlevelDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		connectionManger = new ConnectionManger();
		dbUtils = new DBUtils();
	}

	@Override
	public int insert(Hotlevel hotlevel) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils.execOthers(conn,
				"insert into hotlevel values(null,?,?,?,?)",
				new Object[] { hotlevel.getAid(), hotlevel.getClickrate(),
						hotlevel.getYear(), hotlevel.getMonth() });

		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}
	
	@Override
	public int deleteById(int hid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils.execOthers(conn,
				"delete from hotlevel where hid=?",
				new Object[] { hid });

		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}
	
	@Override
	public int update(Hotlevel hotlevel) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils
				.execOthers(
						conn,
						"update hotlevel set aid=?,clickrate=?,year=?,month=? where hid=?",
						new Object[] { hotlevel.getAid(),
								hotlevel.getClickrate(), hotlevel.getYear(),
								hotlevel.getMonth(), hotlevel.getHid() });

		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public List<Hotlevel> selectAll(final int year, final int season) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		ResultSet resultSet=null;
		if(year==0&&season==0){
		resultSet = this.dbUtils.execQuery(conn,
				"select aid from(select aid,sum(clickrate) as sum from hotlevel group by aid) as temp order by sum desc", new Object[] {});}
		else if(year!=0&&season==0){
			resultSet = this.dbUtils.execQuery(conn,
					"select aid from(select aid,sum(clickrate) as sum from (select * from hotlevel where year=? ) as temp2 group by aid) as temp order by sum desc", new Object[] {year});}
		else if(year==0&&season!=0){
			resultSet = this.dbUtils.execQuery(conn,
					"select aid from(select aid,sum(clickrate) as sum from (select * from hotlevel where month=? ) as temp2 group by aid) as temp order by sum desc", new Object[] {season});
		}else{
			resultSet = this.dbUtils.execQuery(conn,
					"select aid from hotlevel where year=? and month=? order by clickrate desc ", new Object[] {year,season});
		}
		List<Hotlevel> lstHotlevels = new ArrayList<Hotlevel>();
		try {
			while (resultSet.next()) {
				lstHotlevels.add(new Hotlevel(0, resultSet.getInt(1), 0, 0,
						0));
			}
			return lstHotlevels;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
		
	}

	@Override
	public Hotlevel selectById(int hid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from hotlevel where hid=?", new Object[] { hid });
	
		try {
			if (resultSet.next()) {
				return new Hotlevel(resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getInt(3), resultSet.getInt(4),
						resultSet.getInt(5));
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
	public int selectByAid(int aid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from hotlevel where aid=?", new Object[] { aid });
	
		int clickrate=0;
		try {
			while (resultSet.next()) {
				clickrate+=resultSet.getInt(3);
			} 
			return clickrate;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

	@Override
	public Hotlevel isExist(int aid, int year, int season) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from hotlevel where aid=? and year=? and month=?", new Object[] { aid,year,season });
	
		try {
			if (resultSet.next()) {
				return new Hotlevel(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5));
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
	

}
