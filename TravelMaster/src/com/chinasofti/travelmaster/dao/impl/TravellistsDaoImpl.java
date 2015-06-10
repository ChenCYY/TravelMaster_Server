package com.chinasofti.travelmaster.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.travelmaster.dao.ITravellistsDao;
import com.chinasofti.travelmaster.db.ConnectionManger;
import com.chinasofti.travelmaster.db.DBUtils;
import com.chinasofti.travelmaster.db.TransactionManger;
import com.chinasofti.travelmaster.po.Travellists;

public class TravellistsDaoImpl implements ITravellistsDao {

	private ConnectionManger connectionManger;
	private DBUtils dbUtils;
	
	public TravellistsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		connectionManger = new ConnectionManger();
		dbUtils = new DBUtils();
	}

	@Override
	public int insert(Travellists travellist) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils.execOthers(conn,
				"insert into travellists values(null,?,?,?,?,?,?)",
				new Object[] { travellist.getAid(), travellist.getUid(),
						travellist.getDeparture(), travellist.getWay(),
						travellist.getTraveldate(), travellist.getMark() });

		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public int deleteById(int tid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils.execOthers(conn,
				"delete from travellists where tid=?", new Object[] { tid });

		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public int update(Travellists travellist) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils
				.execOthers(
						conn,
						"update travellists set aid=?,uid=?,departure=?,way=?,traveldate=?,mark=? where tid=?",
						new Object[] { travellist.getAid(),
								travellist.getUid(), travellist.getDeparture(),
								travellist.getWay(),
								travellist.getTraveldate(),
								travellist.getMark(), travellist.getTid() });

		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public List<Travellists> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from travellists order by tid", new Object[] {});
		List<Travellists> listTravellists = new ArrayList<Travellists>();
		try {
			while (resultSet.next()) {
				listTravellists.add(new Travellists(resultSet.getInt(1),
						resultSet.getInt(2), resultSet.getInt(3), resultSet
								.getString(4), resultSet.getString(5),
						resultSet.getDate(6), resultSet.getString(7)));
			}
			return listTravellists;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

	@Override
	public Travellists selectById(int tid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from travellists where tid=?", new Object[] { tid });

		try {
			if (resultSet.next()) {
				return new Travellists(resultSet.getInt(1),
						resultSet.getInt(2), resultSet.getInt(3), resultSet
						.getString(4), resultSet.getString(5),
				resultSet.getDate(6), resultSet.getString(7));
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
	public List<Travellists> selectByUid(int uid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from travellists where uid=? order by traveldate", new Object[] {uid});
		List<Travellists> listTravellists = new ArrayList<Travellists>();
		try {
			while (resultSet.next()) {
				listTravellists.add(new Travellists(resultSet.getInt(1),
						resultSet.getInt(2), resultSet.getInt(3), resultSet
								.getString(4), resultSet.getString(5),
						resultSet.getDate(6), resultSet.getString(7)));
			}
			return listTravellists;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

}
