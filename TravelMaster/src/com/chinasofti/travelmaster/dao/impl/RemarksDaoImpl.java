package com.chinasofti.travelmaster.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.travelmaster.dao.IRemarksDao;
import com.chinasofti.travelmaster.db.ConnectionManger;
import com.chinasofti.travelmaster.db.DBUtils;
import com.chinasofti.travelmaster.db.TransactionManger;
import com.chinasofti.travelmaster.po.Remarks;

public class RemarksDaoImpl implements IRemarksDao {

	private ConnectionManger connectionManger;
	private DBUtils dbUtils;
	
	public RemarksDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		connectionManger = new ConnectionManger();
		dbUtils = new DBUtils();
	}

	@Override
	public int insert(Remarks remark) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils.execOthers(conn,
				"insert into remarks values(null,?,?,?,now(),?)", new Object[] {
						remark.getAid(),remark.getUid(),remark.getRemarkcontext(),remark.getFollowid() });

		if (affectedRows > 0) {
			TransactionManger.commit();
		} else {
			TransactionManger.rollback();
		}

		return affectedRows;
	}

	@Override
	public int deleteById(int remarkid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils.execOthers(conn,
				"delete from remarks where remarkid=?",
				new Object[] { remarkid });

		if (affectedRows > 0) {
			TransactionManger.commit();
		} else {
			TransactionManger.rollback();
		}

		return affectedRows;
	}

	@Override
	public int update(Remarks remark) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		int affectedRows = this.dbUtils
				.execOthers(
						conn,
						"update remarks set aid=?,uid=?,remarkcontext=?,publish=?,followid=? where remarkid=?",
						new Object[] { remark.getAid(),remark.getUid(),remark.getRemarkcontext(),remark.getPublish(),remark.getFollowid(), remark.getRemarkid() });

		if (affectedRows > 0) {
			TransactionManger.commit();
		} else {
			TransactionManger.rollback();
		}

		return affectedRows;
	}

	@Override
	public List<Remarks> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from remarks order by remarkid", new Object[] {});
		List<Remarks> lstRemarks = new ArrayList<Remarks>();
		try {
			while (resultSet.next()) {
				lstRemarks.add(new Remarks(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getDate(5),resultSet.getInt(6)));
			}
			return lstRemarks;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

	@Override
	public Remarks selectById(int remarkid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from remarks where remarkid=?",
				new Object[] { remarkid });
		try {
			if (resultSet.next()) {
				return new Remarks(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getDate(5),resultSet.getInt(6));
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
	public List<Remarks> selectByFollowidAndAid(int followid,int aid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from remarks where followid=? and aid=? order by remarkid", new Object[] {followid,aid});
		List<Remarks> lstRemarks = new ArrayList<Remarks>();
		try {
			while (resultSet.next()) {
				lstRemarks.add(new Remarks(resultSet.getInt(1), resultSet
						.getInt(2), resultSet.getInt(3),
						resultSet.getString(4), resultSet.getDate(5), resultSet
								.getInt(6)));
			}
			return lstRemarks;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

}
