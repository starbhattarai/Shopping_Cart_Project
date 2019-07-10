package com.tara.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tara.model.UserBean;

public class LoginDao {
	
	public UserBean getUser(String userName) {
		
		UserBean user = new UserBean();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Success before connection");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","tara","Tara@12345");
			//System.out.println("Success after connection");
			st = con.createStatement();
			rs = st.executeQuery("select * from User where userName=" + "'" + userName + "'");
			
			while(rs.next()) {
					user.setUserId(rs.getInt("userId"));
					user.setUserName(rs.getString("userName"));
					user.setPassword(rs.getString("userPassword"));
				}
		}catch(Exception e){
			System.out.println(e);
		}finally {

			try {if(rs!=null)rs.close();}catch(SQLException e) {System.out.println(e);}
			try {if(st!=null)st.close();}catch(SQLException e) {System.out.println(e);}
			try {if(con!=null)con.close();}catch(SQLException e) {System.out.println(e);}
		}
		
		
		return user;
	}
}
