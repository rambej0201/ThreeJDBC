package com.dss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Step-1 loading the driver 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded");
		System.out.println("----------------------------------------------");
		
		//Step-2 Connecting with the database through Connection object
		Connection on = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","R@m123");
		System.out.println("Connected with the database");
		System.out.println("----------------------------------------------");
		
		//Step-3 adding quries to batch through statement object
		
		Statement tem = on.createStatement();
		
		//tem.addBatch("create table ONERAM.Blue(Car varchar2(40),Maker varchar2(40), Price number)");
		tem.addBatch("insert into ONERAM.Blue('Corolla','Toyota',22000)");
		tem.addBatch("insert into ONERAM.Blue('Civic','Honda',22500)");
		tem.addBatch("insert into ONERAM.Blue('S-Class','Mercedeez',45000)");
		tem.addBatch("insert into ONERAM.Blue('Newly Launched','Tesla',30000)");
		tem.addBatch("select * from ONERAM.Blue");
		
		
		int [] y = tem.executeBatch();
		
		for (int yy : y) {
			System.out.println(yy);
		}
		
		on.close();

	}

}
