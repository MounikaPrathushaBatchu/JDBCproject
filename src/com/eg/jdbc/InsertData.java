package com.eg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl","training","training");
		Statement statement = connection.createStatement();
		connection.setAutoCommit(false);
		statement.executeUpdate("INSERT INTO STUDENT_M(SNO,SNAME,SMARKS) VALUES (615,'D',29.62)");
		statement.executeUpdate("INSERT INTO STUDENT_M(SNO,SNAME,SMARKS) VALUES (515,'m',0.00)");
		Savepoint savepoint = connection.setSavepoint();
		statement.executeUpdate("INSERT INTO STUDENT_M(SNO,SNAME,SMARKS) VALUES (415,'m',0.00)");
		//connection.releaseSavepoint(savepoint);
		System.out.println("VALUE IS INSERTED INTO TABLE");
		connection.commit();
		statement.close();
		connection.close();
	}
}