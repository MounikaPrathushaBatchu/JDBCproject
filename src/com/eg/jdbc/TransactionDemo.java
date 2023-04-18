package com.eg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionDemo {

	public static void main(String[] args) throws Exception {
		Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl", "training", "training");
		Statement statement = connection.createStatement();
		
		System.out.println("data before transaction");
		ResultSet resultSet = statement.executeQuery("SELECT * FROM ACCOUNTS_M");
		while(resultSet.next()){
			System.out.println(resultSet.getString(1)+"------"+resultSet.getInt(2));
		}
		System.out.println(".............transaction starts ..............");
		
		connection.setAutoCommit(false);
		statement.executeUpdate("UPDATE ACCOUNTS_M SET BALANCE = BALANCE-1000 WHERE NAME='A'");
		statement.executeUpdate("UPDATE ACCOUNTS_M SET BALANCE = BALANCE+1000 WHERE NAME='B'");
		System.out.println("CAN YOU PLEASE CONFIRM THIS TRANSACTION OF 1000 ----[Yes|No]");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.next();
		if(option.equalsIgnoreCase("yes")){
			connection.commit();
			System.out.println("transaction committed");
		} else {
			connection.rollback();
			System.out.println("transaction rollbacked");
		}
		
		System.out.println("data after transaction");
		ResultSet resultSet1 = statement.executeQuery("SELECT * FROM ACCOUNTS_M");
		while(resultSet1.next()){
			System.out.println(resultSet1.getString(1)+"------"+resultSet1.getInt(2));
		}
		connection.close();
	}
}
