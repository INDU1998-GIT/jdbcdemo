package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.CallableStatement;

public class CallableDemo {
Connection con;
CallableStatement cstmt;
	ResultSet rs;
		
	CallableDemo()
	{
		
	}
	
	void createConnection()
	{
		
		try
		{
			//register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//open a connection
			System.out.println("connecting to database...");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mysqljdbc","root","Sashi@98");
		

	}
		catch(Exception e)
		
		{
			System.out.println(e);
		}
		
}

	
public void getSkills(int candidateId)
{
	try
	{
		String query = "{ call get_candidate_skill(?) }";
		cstmt=(CallableStatement) con.prepareCall(query);
		cstmt.setInt(1,candidateId);
		
		rs=cstmt.executeQuery();
		while(rs.next())
		{
			System.out.println(String.format("%s - %s", rs.getString("first_name")+"   "+rs.getString("last_name"),
		rs.getString("skill")));
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
public static void main(String[] args) {
	
CallableDemo cd1=new CallableDemo();
cd1.createConnection();
cd1.getSkills(133);
	
	
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
