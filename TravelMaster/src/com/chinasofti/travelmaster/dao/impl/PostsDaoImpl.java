package com.chinasofti.travelmaster.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.travelmaster.dao.IPostsDao;
import com.chinasofti.travelmaster.db.ConnectionManger;
import com.chinasofti.travelmaster.db.DBUtils;
import com.chinasofti.travelmaster.db.TransactionManger;
import com.chinasofti.travelmaster.po.Posts;

public class PostsDaoImpl implements IPostsDao {

	private ConnectionManger connectionManger;
	private DBUtils dbUtils;

	public PostsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManger = new ConnectionManger();
		this.dbUtils = new DBUtils();

	}

	@Override
	public List<Posts> selectByFollowId(int followid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from posts where pfollowid=? order by postdate asc";

		Connection conn = this.connectionManger.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] { followid });
		List<Posts> lstPosts = new ArrayList<Posts>();
		try {
			while (resultSet.next()) {
				Posts post = new Posts();
				post.setPid(resultSet.getInt(1));
				post.setUid(resultSet.getInt(2));
				post.setPtitle(resultSet.getString(3));
				post.setContents(resultSet.getString(4));
				post.setResources(resultSet.getString(5));
				post.setPostdate(resultSet.getDate(6));
				post.setReplynum(resultSet.getInt(7));
				post.setPfollowid(resultSet.getInt(8));
				post.setLatestreply(resultSet.getDate(9));
				lstPosts.add(post);
			}
			return lstPosts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManger.closeConnection(conn);
		}
	}

	@Override
	public int insert(Posts post) {
		// TODO Auto-generated method stub
		int uid = post.getUid();
		String resources = post.getResources();
		String ptitle = post.getPtitle();
		String contents = post.getContents();
		int pfollowid = post.getPfollowid();
		int replynum = 0;

		Connection conn = this.connectionManger.openConnection();
		TransactionManger.connection = conn;
		TransactionManger.beginTransaction();

		String strSQL = "insert into posts values(null, ?, ?, ?, ?, now(),?,?,now() )";
		Object[] params = new Object[] { uid, ptitle, contents, resources,
				replynum, pfollowid };

		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		if (pfollowid != 0) {
			strSQL = "update posts set replynum=replynum+1,latestreply=now() where pid=?";
			params = new Object[] { pfollowid };
			affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		}
		if (affectedRows > 0) {
			TransactionManger.commit();
		} else {
			TransactionManger.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Posts> selectByUpdate(int followid) {
		// TODO Auto-generated method stub
		String strSQL = "select * from posts where pfollowid=? order by latestreply desc";

		Connection conn = this.connectionManger.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] { followid });
		List<Posts> lstPosts = new ArrayList<Posts>();
		try {
			while (resultSet.next()) {
				Posts post = new Posts();
				post.setPid(resultSet.getInt(1));
				post.setUid(resultSet.getInt(2));
				post.setPtitle(resultSet.getString(3));
				post.setContents(resultSet.getString(4));
				post.setResources(resultSet.getString(5));
				post.setPostdate(resultSet.getDate(6));
				post.setReplynum(resultSet.getInt(7));
				post.setPfollowid(resultSet.getInt(8));
				post.setLatestreply(resultSet.getDate(9));
				lstPosts.add(post);
			}
			return lstPosts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManger.closeConnection(conn);
		}
	}

	@Override
	public Posts selectById(int id) {
		// TODO Auto-generated method stub
		String strSQL = "select * from posts where pid=?";

		Connection conn = this.connectionManger.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] { id });
		Posts post = new Posts();

		try {
			if (resultSet.next()) {
				post.setPid(resultSet.getInt(1));
				post.setUid(resultSet.getInt(2));
				post.setPtitle(resultSet.getString(3));
				post.setContents(resultSet.getString(4));
				post.setResources(resultSet.getString(5));
				post.setPostdate(resultSet.getDate(6));
				post.setReplynum(resultSet.getInt(7));
				post.setPfollowid(resultSet.getInt(8));
				post.setLatestreply(resultSet.getDate(9));
				return post;
			} else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManger.closeConnection(conn);
		}

	}

	@Override
	public List<Posts> selectByUid(int uid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from posts where pfollowid=0 and uid=? order by latestreply desc", new Object[] { uid });
		List<Posts> lstPosts = new ArrayList<Posts>();
		try {
			while (resultSet.next()) {
				lstPosts.add(new Posts(
						resultSet.getInt(1), 
						resultSet.getInt(2),
						resultSet.getInt(7), 
						resultSet.getDate(6),
						resultSet.getString(4),
						resultSet.getInt(8),
						resultSet.getString(3), 
						resultSet.getString(5), 
						resultSet.getDate(9)));
			}
			return lstPosts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

}
