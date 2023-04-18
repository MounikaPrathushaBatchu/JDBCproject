package com.eg.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentCallable {

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl","training","training");
		CallableStatement cst = connection.prepareCall("{call STUDENT_M_PRO1(?,?,?)}");
		cst.setInt(1, 11);
		cst.setString(2, "K");
		cst.setDouble(3, 58.02);
		cst.execute();
		System.out.println("one record inserted using procedure");
		connection.close();
	}
}
