package com.chinasofti.travelmaster.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.travelmaster.dao.IShowRelationsDao;
import com.chinasofti.travelmaster.db.ConnectionManger;
import com.chinasofti.travelmaster.db.DBUtils;
import com.chinasofti.travelmaster.po.ShowRelations;

public class ShowRelationsDaoImpl implements IShowRelationsDao {

	private ConnectionManger connectionManger;
	private DBUtils dbUtils;

	public ShowRelationsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		connectionManger = new ConnectionManger();
		dbUtils = new DBUtils();
	}

	@Override
	public List<ShowRelations> selectByUid(int uid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils.execQuery(conn,
				"select * from showrelations where uid=? order by reid",
				new Object[] { uid });
		List<ShowRelations> lstShowRelations = new ArrayList<ShowRelations>();
		try {
			while (resultSet.next()) {
				lstShowRelations.add(new ShowRelations(resultSet.getInt(1),
						resultSet.getInt(2), resultSet.getInt(3), resultSet
								.getString(4), resultSet.getDate(5), resultSet
								.getString(6), resultSet.getString(7)));
			}
			return lstShowRelations;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManger.closeConnection(conn);
		}
	}

}
