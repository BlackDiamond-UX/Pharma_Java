package com.youcode.Pharmacie.model;


public class Pharma {
	protected int id;
	protected String article;
	protected String company;
	protected String price;
	
	public Pharma() {
	}
	
	public Pharma(String article, String company, String price) {
		super();
		this.article = article;
		this.company = company;
		this.price = price;
	}

	public Pharma(int id, String article, String company, String price) {
		super();
		this.id = id;
		this.article = article;
		this.company = company;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}



