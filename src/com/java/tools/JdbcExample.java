package com.java.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.jdbc.JDBCConnection;

public class JdbcExample {
	
	String host;
	int port;
	String path;
	String database;
	
	public JdbcExample(String host, int port, String path, String database) {
		this.database = database;
		this.path = path;
		this.port = port;
		this.host = host;
		
		initConnection(host, port);
		
	}
	
	public void initConnection(String host, int port){
		
	}
		
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try{
			Class.forName("org.hsqldb.jdbcDriver").newInstance();
			System.out.println("Connecting to a database..");
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost", "sa", "");
			stmt = conn.createStatement();
			
			String sql,sql1;
			
			sql = "Select * from Employee";
			
			sql1 = "Create table Department (DepName varchar(3),DepId integer)";
			
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.executeUpdate();
			
			
			
			
			try(ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()){
				int id = rs.getInt("empId");
				String name = rs.getString("empName");
				String depName = rs.getString("depName");
				
				
				System.out.println("values from DB:"+id +" "+name+" "+depName +" ");
				
			}
			rs.close();
			}
			
			stmt.close();
			conn.close();
			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
