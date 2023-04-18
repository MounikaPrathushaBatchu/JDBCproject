package com.eg.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class StudentDetails {

	public static void main(String[] args) throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl","training","training");
		CallableStatement cst = connection.prepareCall("{call get_student_m_info(?,?,?)}");
		cst.setInt(1, 4);
		cst.registerOutParameter(2, Types.VARCHAR);
		cst.registerOutParameter(3, Types.FLOAT);
		cst.execute();
		System.out.println("Student name  : "+cst.getString(2));
		System.out.println("Student marks : "+cst.getFloat(3));
		connection.close();
	}
}