package com.woniu.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql:///struts";
	private static String user = "root";
	private static String password = "";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getconn() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	public static void free(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs != null) rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					if(conn != null) conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
	}
}
