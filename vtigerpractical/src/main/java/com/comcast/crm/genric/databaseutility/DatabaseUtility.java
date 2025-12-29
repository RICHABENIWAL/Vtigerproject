package com.comcast.crm.genric.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	
	Connection con;
	
	public void getConnection(String url, String un, String pw) throws SQLException {
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
	    con=DriverManager.getConnection(url, un, pw);
		
		}catch (Exception e) {}
		
	}
	
	public void getConnection() throws SQLException {
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_db\", \"root\", \"root");
		}catch(Exception e) {}
	}
		
	public void closeDbConnection() {
		
		try {
			con.close();
        }catch(Exception e) {}
	}
	
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
		Statement stat = con.createStatement();
		 result = stat.executeQuery(query);
		}catch (Exception e) {
			}
		return result;
	}
	
	public int executeUpdateQuery(String query) throws SQLException {
		int result = 0;
		try {
		Statement stat = con.createStatement();
		result = stat.executeUpdate(query);
		}catch (Exception e) {
		}
		return result;
	}
	

	
	}

