package com.eg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentBatchExcecution {

	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl","training","training");
		Statement statement = connection.createStatement();
		statement.addBatch("INSERT INTO STUDENT_M VALUES (14,'N',12.34)");
		statement.addBatch("INSERT INTO STUDENT_M VALUES (15,'O',45.6)");
		statement.addBatch("INSERT INTO STUDENT_M VALUES (16,'P',78.9)");
		statement.addBatch("UPDATE STUDENT_M SET SMARKS = 11.11 WHERE SNO = 14");
		statement.addBatch("DELETE FROM STUDENT_M WHERE SNO = 5");
		int[] result = statement.executeBatch();
		System.out.println("Quries : "+result.length);
		for(int x : result)
			System.out.println(x);
		connection.close();
	}
}