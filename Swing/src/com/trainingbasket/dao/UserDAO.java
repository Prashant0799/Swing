package com.trainingbasket.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trainingbasket.bean.User;

public class UserDAO {

	Connection conn = null;
	Statement statement = null;
	ResultSet rs = null;

	public UserDAO() throws SQLException {
		conn = JDBCConfig.getConnectionObject();
	}

	// CURD

	// Create -- insertUser
	// Update -- updateUser
	// Read -- getAllUsers
	// Delete -- deleteUser
	public List<User> getAllUsers() throws SQLException {
		List<User> users = new ArrayList<User>();
		statement = conn.createStatement();
		rs = statement.executeQuery("SELECT * FROM user");
		while (rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt("id"));
			user.setName(rs.getString("Name"));
			user.setDob(rs.getString("DOB"));
			user.setAddress(rs.getString("Address"));
			user.setPhoneNumber(rs.getString("Phone_Number"));
			user.setRollNumber(rs.getInt("Roll_Number"));
			user.setUserName(rs.getString("Username"));
			user.setPassword(rs.getString("Password"));
			user.setEmailAddress(rs.getString("EmailAddress"));
			users.add(user);
		}
		return users;
	}

	public int insertUser(User user) throws SQLException {

		String insertStatement = "INSERT INTO studentdb.user(Name,DOB,Address,Phone_Number,Roll_Number,Username,Password,EmailAddress)"
				+ "VALUES(?,?,?,?,?,?,?,?);";

		PreparedStatement preparedStatement = conn.prepareStatement(insertStatement);

		preparedStatement.setString(1, user.getName());
		preparedStatement.setDate(2, new Date(1989, 12, 10));
		preparedStatement.setString(3, user.getAddress());
		preparedStatement.setString(4, user.getPhoneNumber());
		preparedStatement.setLong(5, user.getRollNumber());
		preparedStatement.setString(6, user.getUserName());
		preparedStatement.setString(7, user.getPassword());
		preparedStatement.setString(8, user.getEmailAddress());
		int row = preparedStatement.executeUpdate();
		System.out.println(row); // 1
		return row;
	}

	public int updateUser(User user) throws SQLException {

		String updateStatement = "UPDATE INTO studentdb.user( Id,Name,DOB,Address,Phone_Number,Roll_Number,Username,Password,EmailAddress)"
				+ "VALUES(?,?,?,?,?,?,?,?,?);";
		PreparedStatement preparedStatement = conn.prepareStatement(updateStatement);

		preparedStatement.setInt(1, user.getUserId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setDate(3, new Date(1989, 12, 10));
		preparedStatement.setString(4, user.getAddress());
		preparedStatement.setString(5, user.getPhoneNumber());
		preparedStatement.setLong(6, user.getRollNumber());
		preparedStatement.setString(7, user.getUserName());
		preparedStatement.setString(8, user.getPassword());
		preparedStatement.setString(9, user.getEmailAddress());
		int row = preparedStatement.executeUpdate();

		// rows affected
		System.out.println(row);

		return row;
	}

	public void deleteUser(User user) throws SQLException {

	}

	public static void main(String[] args) {
		try {

			User user = new User();
			user.setAddress("NOIDAAAAA");
			user.setEmailAddress("test");
			user.setName("testdfhsfhf");
			user.setPassword("pass");
			user.setPhoneNumber("734534");
			user.setRollNumber(123);
			user.setUserName("dasdas");

			new UserDAO().insertUser(user);
			new UserDAO().getAllUsers().forEach(System.out::println);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getMaxUserId() throws SQLException {
		statement = conn.createStatement();
		rs = statement.executeQuery("SELECT max(Roll_Number) FROM user");
		int rollNumber = 0;
		if (rs.next()) {
			rollNumber = rs.getInt(1);
		}
		return rollNumber;
	}
}
