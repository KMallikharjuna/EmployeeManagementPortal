package com.lp.emp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.lp.emp.constants.DBConstants;

public class DBConnection {
	private static Connection con;
	public static Connection getConnection() {
		String url = DBConstants.CON_URL;
		String pwd = DBConstants.PASSWORD;
		String driver = DBConstants.DRIVER_CLASS;
		String user = DBConstants.USERNAME;
		
		try {
			Class.forName(driver);
			System.out.println("Driver found");
			con = DriverManager.getConnection(url,user,pwd);
			System.out.println("Connected with DB.");
		} 
		catch(ClassNotFoundException e) {
			System.out.println("Unable to find the driver class.");
		}
		catch (SQLException e) {
			System.out.println("Unable to connect with the Database.");
		}
		
		return con;
	}
}
