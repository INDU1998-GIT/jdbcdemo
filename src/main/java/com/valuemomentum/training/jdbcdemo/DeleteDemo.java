package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) {
		Connection con;    //object creation
		Statement stmt;
	
		int cnt=0;
		try
		{
			//register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//open a connection
			System.out.println("connecting to database...");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Sashi@98");
		String sql="DELETE from candidates where rtrim(last_name) like 'y%g';";
		System.out.println(" ");
		stmt=con.createStatement();
		cnt=stmt.executeUpdate(sql);
		
		if(cnt>0)
		{
			System.out.println("Record for young is deleted");
		}
		else
		{
			System.out.println("record not found");
		}
		con.close();
		
	}
		catch(Exception ce)
		{
		System.out.println(ce);	
		}

}
}
