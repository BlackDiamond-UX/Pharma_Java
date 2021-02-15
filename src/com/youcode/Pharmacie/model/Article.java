package com.youcode.Pharmacie.model;


public class Article {
	protected int id;
	protected String nom;
	protected String company;
	protected int price;
	protected int qun;
	
	public Article() {
		super();
	}
	
	public Article(String nom, String company, int price, int qun) {
		super();
		this.nom = nom;
		this.company = company;
		this.price = price;
		this.qun = qun;
	}

	public Article(int id, String nom, String company, int price, int qun) {
		super();
		this.id = id;
		this.nom = nom;
		this.company = company;
		this.price = price;
		this.qun = qun;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQun() {
		return qun;
	}

	public void setQun(int qun) {
		this.qun = qun;
	}
}



