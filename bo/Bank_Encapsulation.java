package com.bank.bo;


public class Bank_Encapsulation {
	
	private String customer_name;
	private String customer_address;
	private String adharcard_no;
	private String mobile_no;
	private String account_type;
	private String gender;
	private int account_no;
	
	private String name;
	private String username;
	private String pwd;
	
	private String fullname;
	private float amount;
	
	//setter and getter
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getAdharcard_no() {
		return adharcard_no;
	}
	public void setAdharcard_no(String adharcard_no) {
		this.adharcard_no = adharcard_no;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	//toString()
	@Override
	public String toString() {
		return "Bank_Encapsulation [customer_name=" + customer_name + ", customer_address=" + customer_address
				+ ", adharcard_no=" + adharcard_no + ", mobile_no=" + mobile_no + ", account_type=" + account_type
				+ ", gender=" + gender + ", account_no=" + account_no + ", name=" + name + ", username=" + username
				+ ", pwd=" + pwd + "]";
	}
	
	
}//class
