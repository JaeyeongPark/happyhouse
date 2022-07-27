package com.ssafy.dto;

public class UserDTO {
	private String id;
	private String password;
	private String name;
	private String email;
	private String age;
	private String phonenumber;
	private String dongcode;
	private String sidoName;
	private String gugunName;
	private String dongName;
	public UserDTO() {
		super();
	}
	public UserDTO(String id, String password, String name, String email, String age, String phonenumber,
			String dongcode, String sidoName, String gugunName, String dongName) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
		this.phonenumber = phonenumber;
		this.dongcode = dongcode;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age
				+ ", phonenumber=" + phonenumber + ", dongcode=" + dongcode + ", sidoName=" + sidoName + ", gugunName="
				+ gugunName + ", dongName=" + dongName + "]";
	}
	
}
