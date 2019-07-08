package com.trainingbasket.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginUser {
	Statement stmt;
	ResultSet rs;
	Connection conn;

	public boolean loginUser(String username, String password) {
		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost/CollegeDb?" + "user=root&password=root");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT * FROM login where username ='" + username + "' and password='" + password + "';");
			if(rs.next()) {
				return true;
			}

			// Now do something with the ResultSet ....
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			// it is a good idea to release
			// resources in a finally{} block
			// in reverse-order of their creation
			// if they are no-longer needed

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}
		}
		return false;
	}
}
