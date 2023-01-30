package com.tutorialspoint.test;

import java.io.Serializable;
//import java.net.URI;
//import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

//import javax.faces.application.FacesMessage;
//import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
//import javax.faces.bean.ViewScoped;
//import javax.faces.event.ComponentSystemEvent;
//import javax.faces.validator.ValidatorException;




@ManagedBean(name = "itemData", eager = true)
@RequestScoped
public class ItemData implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	private String url;
	private String description;
	private String price;
	private String category;
	private String categorySearchItem;
	private ArrayList<Item> items = new ArrayList<Item>();
	public ArrayList<Item> getItems() {
		//get data from database

		return  items;
	}


	public void onLoad(AjaxBehaviorEvent event)
	{
		items =  ConnectDB.getItemfromDB();
	}
	public String addItem() {
		Item item = new Item(name, id, url, description, price, category);
		items.add(item);
		ConnectDB.addItemtoDB(name, url, description, Double.parseDouble(price), category);
		return null;
	}


	public void searchCategory() {


		items = ConnectDB.getItemfromDB1(categorySearchItem);


	}

	
		

	private List<String> category_list = new ArrayList<>();
	public List<String> get_category_name() {
		try {
			Connection connection=null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stuffbaydatabase","root","Welcome2@");
			PreparedStatement ps=null;
			ps=connection.prepareStatement("select * from stuffbaydatabase.categories");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				category_list.add(rs.getString("product_category"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return category_list;
	}

	public List<String> getCategory_list() {
		return category_list;
	}

	public void setCategory_list(List<String> category_list) {
		this.category_list = category_list;
	}




	public String deleteItem(Item item) {
		items.remove(item);
		return null;

	}

	public String editItem (Item item) {
		item.setCanEdit(true);
		return null;
	}

	public String saveItems() {
		for(Item item : items) {
			item.setCanEdit(false);
		}
		return null;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getCategorySearchItem() {
		return categorySearchItem;
	}


	public void setCategorySearchItem(String categorySearchItem) {
		this.categorySearchItem = categorySearchItem;
	}
}