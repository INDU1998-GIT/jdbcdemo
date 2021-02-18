package com.valuemomentum.training.jdbcdemo;

import java.sql.*;
public class BatchDemo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mysqljdbc","root","Sashi@98");
		Statement stmt=con.createStatement();
		
		//create batch
		stmt.addBatch("insert into candidate_skills values(101,5)");
		stmt.addBatch("update skills set name='webdesigning' where id=4");
		stmt.addBatch("delete from candidates where id=81");
		
		//disable auto-commit mode
		con.setAutoCommit(false);
		try
		{
			stmt.executeBatch();
			con.commit();
			System.out.println("batch is successfully extended");
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
				System.out.println("batch is failed");
				System.out.println("exception is" +e);
			}
			catch(Exception e1)
			{
				System.out.println("Exception is:"+e1);
			}
		}
		//end of outer catch
		//clean up
		
		stmt.close();
		con.close();
		
		
		

	}

}
