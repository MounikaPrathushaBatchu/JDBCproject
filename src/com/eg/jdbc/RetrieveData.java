package com.eg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class RetrieveData {

	public static void main(String[] args) throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl","training","training");
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM USERS_M");
		ResultSet rs= ps.executeQuery();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		while(rs.next()){
			String name = rs.getString(1);
			java.sql.Date sdate = rs.getDate(2);
			String s = sdf.format(sdate);
			System.out.println(name +"\t"+s);
		}
		connection.close();
	}
}