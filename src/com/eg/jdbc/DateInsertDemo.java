package com.eg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertDemo {

	public static void main(String[] args) throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl","training","training");
		Scanner scanner = new Scanner(System.in);
		System.out.print("enter user name : ");
		String userName = scanner.next();
		System.out.print("enter date of joining value (dd-mm-yyyy) : ");
		String doj = scanner.next();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate = sdf.parse(doj);
		long l = udate.getTime();
		java.sql.Date sdate = new java.sql.Date(l);
		
		PreparedStatement ps = connection.prepareStatement("insert into users_m values(?,?)");
		ps.setString(1, userName);
		ps.setDate(2, sdate);
		
		int rc = ps.executeUpdate();
		if(rc == 0)
			System.out.println("record is not inserted");
		else
			System.out.println("record is inserted");
		connection.close();
	}
}
