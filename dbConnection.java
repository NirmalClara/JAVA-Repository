package com.db.connection;

import java.util.*;
import java.sql.*;

public class dbConnection {

		public static Connection getConn () throws SQLException
		{
			Connection conn = null;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@10.128.77.23:1521:rcms", "rcms", "japan123");
				return conn;
			}
			catch(SQLException | ClassNotFoundException e)
			{
				System.out.println("SQLException caught");
				return null;
			}
		}
}
