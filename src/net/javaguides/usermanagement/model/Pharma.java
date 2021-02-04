package net.javaguides.usermanagement.model;

public class Pharma {
	protected int id;
	protected String item;
	protected String company;
	protected String price;

	
	public Pharma(String item, String company, String price) {
		super();
		this.item = item;
		this.company = company;
		this.price = price;
	}

	public Pharma(int id, String item, String company, String price) {
		super();
		this.id = id;
		this.item = item;
		this.company = company;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
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
