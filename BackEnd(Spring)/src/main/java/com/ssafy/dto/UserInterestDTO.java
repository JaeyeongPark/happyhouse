package com.ssafy.dto;

public class UserInterestDTO {
	private String id;
	private String dongcode;
	private String category;
	private String categoryvalue;
	private String code;
	private String address;
	public UserInterestDTO() {
		super();
	}
	public UserInterestDTO(String id, String dongcode, String category, String categoryvalue, String code,
			String address) {
		super();
		this.id = id;
		this.dongcode = dongcode;
		this.category = category;
		this.categoryvalue = categoryvalue;
		this.code = code;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategoryvalue() {
		return categoryvalue;
	}
	public void setCategoryvalue(String categoryvalue) {
		this.categoryvalue = categoryvalue;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserInterestDTO [id=" + id + ", dongcode=" + dongcode + ", category=" + category + ", categoryvalue="
				+ categoryvalue + ", code=" + code + ", address=" + address + "]";
	}
	
	
	
	
	
	
	
}
