package com.example.tests;

public class AccountObject {
	public String first_name;
	public String last_name;
	public String username;
	public String password;
	public String country_code;
	public String mobile;

	public AccountObject(String first_name,
			String last_name, String username, String password,
			String country_code, String mobile) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.country_code = country_code;
		this.mobile = mobile;
	}
}