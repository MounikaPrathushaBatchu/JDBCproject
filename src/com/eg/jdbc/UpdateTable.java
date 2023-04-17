package com.eg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTable {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl","training","training");
		Statement statement = connection.createStatement();
		statement.executeUpdate("UPDATE STUDENT_M SET SMARKS = 27.95 WHERE SNO = 1 ");
		System.out.println("VALUE IS UPDATED");
		statement.close();
		connection.close();
	}
}