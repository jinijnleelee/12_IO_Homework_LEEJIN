package edu.kr.io.vo;

public class Book {

	//private int bkNum;
	private String bkName;
	private String Writer;
	private int price;
	private String company;
	
	
	
	public Book() {}
	
	public Book( String bkName, String writer, int price, String company) {
		super();
		
		this.bkName = bkName;
		Writer = writer;
		this.price = price;
		this.company = company;
	}
	
	
	

//	public int getBkNum() {
//		return bkNum;
//	}
//
//	public void setBkNum(int bkNum) {
//		this.bkNum = bkNum;
//	}

	public String getBkName() {
		return bkName;
	}

	public void setBkName(String bkName) {
		this.bkName = bkName;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	
	@Override
	public String toString() {
		return  bkName + "      " +  Writer + "      " + price + "      " 
	+ company;
	}	
	
	
	
	
	
}
