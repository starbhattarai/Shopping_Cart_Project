package com.tara.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tara.model.ItemBean;

public class ItemDao {
	
	public void decreseItem(int itemId,int itemQuantity) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Success before connection");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","tara","Tara@12345");
			//System.out.println("Success after connection");
			st = con.createStatement();
			rs = st.executeQuery("select itemId,itemQuantity from Item where itemId = " + itemId);
			int tempItemQuantity=0;
			while(rs.next()) {
				if(rs.getInt("itemQuantity")>0) {
					tempItemQuantity = rs.getInt("itemQuantity");
				}
				}
			tempItemQuantity -= itemQuantity;
			String sql = "update Item set itemQuantity = "+tempItemQuantity+" where itemId = "+itemId;
			st.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e);
		}finally {

			try {if(rs!=null)rs.close();}catch(SQLException e) {System.out.println(e);}
			try {if(st!=null)st.close();}catch(SQLException e) {System.out.println(e);}
			try {if(con!=null)con.close();}catch(SQLException e) {System.out.println(e);}
		}
	}
	
	public List getAllItem() {
	
		List data = new ArrayList();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Success before connection");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","tara","Tara@12345");
			//System.out.println("Success after connection");
			st = con.createStatement();
			rs = st.executeQuery("select * from Item");
			
			while(rs.next()) {
				if(rs.getInt("itemQuantity")>0) {
					data.add(rs.getInt("itemId"));
					data.add(rs.getString("itemName"));
					data.add(rs.getInt("itemPrice"));
					data.add(rs.getInt("itemQuantity"));
					data.add(rs.getString("itemImage"));
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}finally {

			try {if(rs!=null)rs.close();}catch(SQLException e) {System.out.println(e);}
			try {if(st!=null)st.close();}catch(SQLException e) {System.out.println(e);}
			try {if(con!=null)con.close();}catch(SQLException e) {System.out.println(e);}
		}
		
		
		return data;
		
	}
}
