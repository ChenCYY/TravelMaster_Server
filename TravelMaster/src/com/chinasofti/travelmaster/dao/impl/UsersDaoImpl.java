package com.chinasofti.travelmaster.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.travelmaster.dao.IUsersDao;
import com.chinasofti.travelmaster.db.ConnectionManger;
import com.chinasofti.travelmaster.db.DBUtils;
import com.chinasofti.travelmaster.db.TransactionManger;
import com.chinasofti.travelmaster.po.Users;

public class UsersDaoImpl implements IUsersDao {
	
	private ConnectionManger connectionManger;
	private DBUtils dbUtils;

	public UsersDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		connectionManger = new ConnectionManger();
		dbUtils = new DBUtils();
	}

	@Override
	public int insert(Users user) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();
		
		int affectedRows = this.dbUtils.execOthers(
				conn,
				"insert into users values(null,?,?,?,?,now(),?,?)",
				new Object[] { user.getUname(), user.getUpwd(),
						user.getUsex(), user.getUemail(), null ,user.getUavatar() });		
		
		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public int deleteById(int uid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();
		
		int affectedRows = this.dbUtils.execOthers(conn,
				"delete from users where uid=?", new Object[] { uid });	
		
		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}
	
	@Override
	public int update(Users user) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();
		
		int affectedRows = this.dbUtils
				.execOthers(
						conn,
						"update users set uname=?,upwd=?,usex=?,uemail=?,regdate=?,umark=?,uavatar=? where uid=?",
						new Object[] { user.getUname(),
								user.getUpwd(), user.getUsex(),user.getUemail(),
								user.getRegdate(), user.getUmark(),user.getUavatar(),user.getUid() });
		
		if(affectedRows>0){
			TransactionManger.commit();
		}else{
			TransactionManger.rollback();
		}
		
		return affectedRows;
	}

	@Override
	public List<Users> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();
		
		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from users order by uid", new Object[] {});
		List<Users> lstUsers = new ArrayList<Users>();
		try {
			while (resultSet.next()) {
				lstUsers.add(new Users(
						resultSet.getInt(1), resultSet.getString(2), resultSet
								.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getDate(6), resultSet
								.getString(7),resultSet.getString(8)));
			}
			return lstUsers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
		
	}

	@Override
	public Users selectById(int uid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from users where uid=?", new Object[] { uid });

		try {
			if (resultSet.next()) {
				return new Users( resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5),
						resultSet.getDate(6), resultSet.getString(7),resultSet.getString(8));
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
	public Users selectByName(Users user) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from users where uname=?", new Object[] { user.getUname() });

		try {
			if (resultSet.next()) {
				return new Users(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5),
						resultSet.getDate(6), resultSet.getString(7),resultSet.getString(8));
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
	public Users selectByEmail(String uemail) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from users where uemail=?", new Object[] { uemail });

		try {
			if (resultSet.next()) {
				return new Users(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5),
						resultSet.getDate(6), resultSet.getString(7),resultSet.getString(8));
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
	public Users selectByNameAndPwd(Users user) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from users where uname=? and upwd=?", new Object[] { user.getUname(),user.getUpwd() });

		try {
			if (resultSet.next()) {
				return new Users(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5),
						resultSet.getDate(6), resultSet.getString(7),resultSet.getString(8));
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
