package com.eg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Type2Test {
private static final String EMP_SELECT_QUERY = "SELECT * FROM EMPLOYEE_M";
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:oci8:@orcl", "training", "training");//type 2 driver need to install ojdbc6
			if(connection != null)
				statement = connection.createStatement();
			if(statement != null)
				resultSet = statement.executeQuery(EMP_SELECT_QUERY);
			if(resultSet != null){
				while(resultSet.next()){
					System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getInt(5)+" "+resultSet.getString(6)+" "+resultSet.getInt(7)+" "+resultSet.getString(8)+" "+resultSet.getInt(9)+" "+resultSet.getString(10)+" "+resultSet.getInt(11));
				}
			}	
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(resultSet != null)
					resultSet.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(statement != null)
					statement.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(connection != null)
					connection.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
}
