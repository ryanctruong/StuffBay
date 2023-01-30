package com.tutorialspoint.test;

public class Item {
	private String name;
	private int id;
	private String url;
	private String description;
	private String price;
	private String category;
	private boolean canEdit;

	public Item(String name, int id, String url, String description, String  price, String category) {
		this.setName(name);
		this.setId(id);
		this.setUrl(url);
		this.setDescription(description);
		this.setPrice(price);
		this.setCategory(category);

		canEdit = false;
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

	public double getPrice() {
		double asDoub = Double.valueOf(price);
		return asDoub;
	}

	public void setPrice(String price2) {
		this.price = price2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public boolean isCanEdit() {
		return canEdit;
	}
	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}






