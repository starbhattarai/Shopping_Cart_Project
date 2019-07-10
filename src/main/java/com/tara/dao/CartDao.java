package com.tara.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tara.model.ItemBean;

public class CartDao {

	public void addItemtoCart(ItemBean obj) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Success before connection");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","tara","Tara@12345");
			//System.out.println("Success after connection");
			st = con.createStatement();
			String sql1 = "select itemId,itemQuantity from Cart where itemId = "+obj.getItemId();
			rs = st.executeQuery(sql1);
			if(rs.next() == true) {
				int tempQuantity = rs.getInt("itemQuantity");
				tempQuantity+=1;
				String sql2 = "update Cart set itemQuantity = "+tempQuantity+" where itemId = "+obj.getItemId();
				st.executeUpdate(sql2);
			}else {
				String sql = "insert into Cart values( "+obj.getItemId()+" , "+"'"+obj.getItemName()+"'"+" , "+obj.getItemPrice()+" , "+1+" , "+"'"+obj.getItemImage()+"'"+")";
				st.executeUpdate(sql);
			}
			
		}catch(Exception e){
			System.out.println(e);
		}finally {

			try {if(rs!=null)rs.close();}catch(SQLException e) {System.out.println(e);}
			try {if(st!=null)st.close();}catch(SQLException e) {System.out.println(e);}
			try {if(con!=null)con.close();}catch(SQLException e) {System.out.println(e);}
		}
	}
	
	public List getAllCartItem() {
		
		List cartData = new ArrayList();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Success before connection");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","tara","Tara@12345");
			//System.out.println("Success after connection");
			st = con.createStatement();
			rs = st.executeQuery("select * from Cart");
			
			while(rs.next()) {
					cartData.add(rs.getInt("itemId"));
					cartData.add(rs.getString("itemName"));
					cartData.add(rs.getInt("itemPrice"));
					cartData.add(rs.getInt("itemQuantity"));
					cartData.add(rs.getString("itemImage"));
			}
		}catch(Exception e){
			System.out.println(e);
		}finally {

			try {if(rs!=null)rs.close();}catch(SQLException e) {System.out.println(e);}
			try {if(st!=null)st.close();}catch(SQLException e) {System.out.println(e);}
			try {if(con!=null)con.close();}catch(SQLException e) {System.out.println(e);}
		}
		
		
		return cartData;
		
	}
	
	public void checkOutAllCartItem() {
		
		ItemDao itemdao = new ItemDao();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Success before connection");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","tara","Tara@12345");
			//System.out.println("Success after connection");
			st = con.createStatement();
			rs = st.executeQuery("select * from Cart");
			
			while(rs.next()) {
					int itemId = rs.getInt("itemId");
					int itemQuantity=rs.getInt("itemQuantity");
					itemdao.decreseItem(itemId, itemQuantity);
			}
			st.executeQuery("delete from Cart");
		}catch(Exception e){
			System.out.println(e);
		}finally {

			try {if(rs!=null)rs.close();}catch(SQLException e) {System.out.println(e);}
			try {if(st!=null)st.close();}catch(SQLException e) {System.out.println(e);}
			try {if(con!=null)con.close();}catch(SQLException e) {System.out.println(e);}
		}
		
	}
}
