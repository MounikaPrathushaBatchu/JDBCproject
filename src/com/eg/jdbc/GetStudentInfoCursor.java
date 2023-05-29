package com.eg.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.internal.OracleTypes;

public class GetStudentInfoCursor {

	public static void main(String[] args) throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl","training","training");
		CallableStatement cst = connection.prepareCall("{call getAllStudntInfo(?,?)}");
		cst.setFloat(1, 30);
		cst.registerOutParameter(2, OracleTypes.CURSOR);
		cst.execute();
		ResultSet rs = (ResultSet)cst.getObject(2);
		System.out.println("SNO\tSNAME\tSMARKS");
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		connection.close();
	}
}
