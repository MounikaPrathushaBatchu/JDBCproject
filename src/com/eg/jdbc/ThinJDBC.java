package com.eg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//example for type-4 JDBC
public class ThinJDBC {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl", "training", "training");
			if(connection != null)
				statement = connection.createStatement();
			if(statement != null)
				resultSet = statement.executeQuery("SELECT * FROM STUDENT_M ORDER BY SNO ASC");
			if(resultSet != null){
				int columnIndex = resultSet.findColumn("SNO");
				System.out.println("Index of SNO column is: "+columnIndex);
				System.out.println("SNO\tSNAME\tSMARKS");
				while(resultSet.next()){
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
				}
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet != null)
					resultSet.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(statement != null)
					statement.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
