package com.member.lib.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection3
{
	private static final String URL="jdbc:oracle:thin:@localhost:1521/xe";
	private static final String ID="c##test";
	private static final String PWD="test";
	private static final String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
	static
	{
		try
		{
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection open()
	{
		try
		{
			return DriverManager.getConnection(URL,ID,PWD);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args)
	{
		Connection con = open();
		String sql = "select l_num, l_lentdate, l_recdate, m_num, b_num from lent";
		
	}

}
