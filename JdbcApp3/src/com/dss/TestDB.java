package com.dss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Step-1 loading the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded");
		System.out.println("--------------------------------------");
		
		//step-2 connecting with the database
		Connection ti = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","R@m123");
		System.out.println("Connected with the database");
		System.out.println("---------------------------------------");
		
		Statement ment = ti.createStatement();
		
		/*String q0 = ;
		String q1 = ;
		String q2 = ;
		String q3 = ;
		String q4 = ;
		String q5 = ;
		String q6= ;*/
		
		ment.addBatch("create table ONERAM.rsemp(eid number, ename varchar2(40), esal number)");
		ment.addBatch("insert into ONERAM.rsemp values(111,'Bhanu',10101)");
		ment.addBatch("insert into ONERAM.rsemp values(222,'Om',20202)");
		ment.addBatch("insert into ONERAM.rsemp values(333,'Sweety',30303)");
		ment.addBatch("insert into ONERAM.rsemp values(444,'Anvita',40404)");
		ment.addBatch("update ONERAM.rsemp set esal = esal+300 where esal > 20205");
		ment.addBatch("drop table ONERAM.rsemp");
		
		int [] x = ment.executeBatch();
		
		for (int xx : x) {
			System.out.println(xx);
		}
		
		ti.close();

	}

}
