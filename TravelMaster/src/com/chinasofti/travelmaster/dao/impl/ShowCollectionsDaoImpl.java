package com.chinasofti.travelmaster.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.travelmaster.dao.IShowCollectionsDao;
import com.chinasofti.travelmaster.db.ConnectionManger;
import com.chinasofti.travelmaster.db.DBUtils;
import com.chinasofti.travelmaster.po.ShowCollections;

public class ShowCollectionsDaoImpl implements IShowCollectionsDao {

	private ConnectionManger connectionManger;
	private DBUtils dbUtils;
	
	public ShowCollectionsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		connectionManger = new ConnectionManger();
		dbUtils = new DBUtils();
	}

	@Override
	public List<ShowCollections> selectByUid(int uid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from showcollections where uid=? order by coldate desc", new Object[] {uid});
		List<ShowCollections> lstShowCollections = new ArrayList<ShowCollections>();
		try {
			while (resultSet.next()) {
				lstShowCollections.add(new ShowCollections(resultSet.getInt(1),resultSet.getInt(2),
						resultSet.getDate(3),resultSet.getInt(4), resultSet.getString(5), resultSet
								.getString(6), resultSet.getString(7),
						resultSet.getInt(8), resultSet.getDouble(9)));
			}
			return lstShowCollections;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

}
