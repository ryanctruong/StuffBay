package com.tutorialspoint.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.List;


public class ConnectDB {
	//DB connection variable

	static Connection connection = null;	static String databaseName = "";
	static String url = "jdbc:mysql://localhost:3306/" +databaseName;

	static String username = "root";
	static String password = "Welcome2@";

	public static void addItemtoDB(String s1, String s2, String s3, double d1, String s4) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			connection.setAutoCommit(true);
			PreparedStatement ps1 = connection.prepareStatement("INSERT INTO `stuffbaydatabase`.`product` (`product_name`, `product_url`, `product_desc`, `product_price`, `product_category`) VALUES (?, ?, ?,?,?);"); 
			ps1.setString(1,s1);
			ps1.setString(2,s2);
			ps1.setString(3,s3);
			ps1.setDouble(4,d1);
			ps1.setString(5, s4);

			int status1 = ps1.executeUpdate();
			if(status1 != 0) {
				System.out.println("Database has Connected for table");
				System.out.println("Record was Inserted");	
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static ArrayList<Item> getItemfromDB() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			Statement stmt=connection.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from `stuffbaydatabase`.`product`");  
			final ArrayList<Item> items = new ArrayList<Item>();
			while(rs.next())  {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
				items.add(new Item (rs.getString(2), 0, rs.getString(3), rs.getString(4), String.valueOf(rs.getDouble(5)), rs.getString("product_category")));
			}
			connection.close();  
			return items;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}







	public static ArrayList<Item> getItemfromDB1(String category) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement ps1 ;
			if(!category.equals("All")) {
				ps1 = connection.prepareStatement("select * from `stuffbaydatabase`.`product` where product_category like ? ;"); 
				ps1.setString(1,"%" + category + "%");
			}else {
				ps1 = connection.prepareStatement("select * from `stuffbaydatabase`.`product` ;"); 
			}


			ResultSet rs=ps1.executeQuery();


			final ArrayList<Item> items = new ArrayList<Item>();
			while(rs.next())  {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
				items.add(new Item (rs.getString(2), 0, rs.getString(3), rs.getString(4), String.valueOf(rs.getDouble(5)), rs.getString("product_category")));
			}
			connection.close();  
			return items;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
