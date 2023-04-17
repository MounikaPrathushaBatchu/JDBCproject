package com.eg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class App1 {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl","training","training");
		
		System.out.println("Connection Established");
	}
}
