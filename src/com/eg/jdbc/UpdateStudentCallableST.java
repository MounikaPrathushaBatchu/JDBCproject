package com.eg.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class UpdateStudentCallableST {

	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl","training","training");
		CallableStatement cst = connection.prepareCall("{call UPDATE_STUDENT_M(?,?,?)}");
		cst.setInt(1, 11);
		cst.setString(2, "K");
		cst.setDouble(3, 38.02);
		cst.execute();
		System.out.println("one record updated using procedure");
		connection.close();
	}
}
