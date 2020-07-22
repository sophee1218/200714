package com.member.lib.common;

import java.sql.*;

public class Connection3
{

	public static void main(String[] args)
	{
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			Class.forName("oracle.jbdc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "c##test", "test");

			String sql = "select num, name, id from user_info";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				System.out.println(rs.getInt("num")+rs.getString("name")+rs.getString("id"));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(stmt!=null)
				{
				stmt.close();
				}
				if(con!=null)
				{
					con.close();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}