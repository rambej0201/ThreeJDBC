package com.dss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestDbDynamic {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		//Step-1 loading the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded");
		System.out.println("------------------------------------");
		
		//Step-2 connecting with the database
		Connection ct = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","R@m123");
		System.out.println("Connected with the database");
		System.out.println("------------------------------------");
		
		//create statement
		Statement ent = ct.createStatement();
		
		//lets use Scanner class to get the inputs from the user side 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the table name");
		String tname = sc.next();
		
		/*String q1 = "create table Emps(eid number, ename varchar2(40), esal number)";*/
		String q0 = "create table ONERAM."+tname+"(eid number, ename varchar2(40), esal number)";
		ent.executeUpdate(q0);
		
		System.out.println("created table name is "+tname);
		
		while (true) {
			System.out.println("Enter Employee ID");
			int eid = sc.nextInt();
			
			System.out.println("Enter Employee Name");
			String ename = sc.next();
			
			System.out.println("Enter Employee Salary");
			int esal = sc.nextInt();
			
			String q1 = "insert into ONERAM."+tname+" values("+eid+",'"+ename+"',"+esal+")";
			System.out.println(q1+" data incerted");
			ent.executeUpdate(q1);
			System.out.println("Do you want one more record to be inserted say y/n");
			String op = sc.next();
			if(op.equals("n")) {
				break;
			}
		}
		Thread.sleep(15000);
		
		System.out.println("Enter the table name you would like to drop");
		String drop = sc.next();
		String q2 = "drop table ONERAM."+drop;
		System.out.println("table dropped with query "+q2);

	}

}
