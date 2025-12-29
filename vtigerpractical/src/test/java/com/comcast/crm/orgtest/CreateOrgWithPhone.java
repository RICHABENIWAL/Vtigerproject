package com.comcast.crm.orgtest;

import java.sql.ResultSet;

import org.testng.annotations.Test;

import com.comcast.crm.genric.databaseutility.DatabaseUtility;

public class CreateOrgWithPhone {
	
	@Test
	public void db() throws Throwable {
		
		
		DatabaseUtility du = new DatabaseUtility();
		du.getConnection("jdbc:mysql://localhost:3306/company_db", "root", "root");
		ResultSet result= du.executeSelectQuery("select * from employee");
		System.out.println(result);
		while(result.next()){
		  String data1=result.getString(1) ;
		  String data2=result.getString(2) ;
		  String data3=result.getString(3); 
				  System.out.println(data1+" "+data2+" "+data3);
				  
		}
		
		
		
		int result1 = du.executeUpdateQuery("'20' , 'rohi', 'sharma', 'e@gmail.com', '9876543210', 'IT', '70000', '2025-10-18'");
		System.out.println(result1);
		
		du.closeDbConnection();

	}

}
