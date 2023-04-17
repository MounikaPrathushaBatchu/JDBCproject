package com.eg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl","training","training");
		Statement statement = connection.createStatement();
		statement.executeUpdate("CREATE TABLE STUDENT_M(SNO NUMBER(3),SNAME VARCHAR2(50),SMARKS NUMBER(5,2))");
		System.out.println("TABLE is created");
		statement.close();
		connection.close();
	}
}
