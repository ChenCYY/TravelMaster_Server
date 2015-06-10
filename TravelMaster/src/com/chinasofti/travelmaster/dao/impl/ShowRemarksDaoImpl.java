package com.chinasofti.travelmaster.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.travelmaster.dao.IShowRemarksDao;
import com.chinasofti.travelmaster.db.ConnectionManger;
import com.chinasofti.travelmaster.db.DBUtils;
import com.chinasofti.travelmaster.po.ShowRemarks;

public class ShowRemarksDaoImpl implements IShowRemarksDao {

	private ConnectionManger connectionManger;
	private DBUtils dbUtils;
	
	
	public ShowRemarksDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		connectionManger = new ConnectionManger();
		dbUtils = new DBUtils();
	}


	@Override
	public List<ShowRemarks> selectByFollowidAndAid(int followid, int aid) {
		// TODO Auto-generated method stub
		Connection conn = connectionManger.openConnection();

		ResultSet resultSet = this.dbUtils
				.execQuery(
						conn,
						"select * from showremarks where followid=? and aid=? order by remarkid",
						new Object[] { followid, aid });
		List<ShowRemarks> lstRemarks = new ArrayList<ShowRemarks>();
		try {
			while (resultSet.next()) {
				lstRemarks.add(new ShowRemarks(resultSet.getInt(1), resultSet
						.getInt(2), resultSet.getInt(3),
						resultSet.getString(4), resultSet.getDate(5), resultSet
								.getInt(6), resultSet.getString(7)));
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
