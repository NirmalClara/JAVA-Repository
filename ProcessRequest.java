package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.db.connection.*;

public class ProcessRequest {
	
	public static ArrayList<ArrayList<String>> retrieveData(String Group)
	{
		try
		{
			Connection conn = dbConnection.getConn();
			String sql_query = "select * from rcms_rpt_ddi_dump where Group_ID = '"+Group+"'";
			Statement sql = conn.createStatement();
			ResultSet rs=sql.executeQuery(sql_query);
			ArrayList<ArrayList<String>> resultData=new ArrayList<ArrayList<String>>();
			while(rs.next()){
				ArrayList<String> rowData=new ArrayList<String>();
				rowData.add(String.valueOf(rs.getInt(1)));
				rowData.add(String.valueOf(rs.getInt(2)));
				rowData.add(rs.getString(3));
				resultData.add(rowData);
			}
			return resultData;
		}
		
		catch(SQLException e)
		{
			System.out.println("Caught SQlException");
			e.printStackTrace();
			return null;
		}
	}
}
