package com.trainingbasket.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConfig {
	static Connection conn;

	public static Connection getConnectionObject() throws SQLException {
		if (conn == null) {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/studentdb?" + "user=root&password=root");
		}
		return conn;
	}
}
