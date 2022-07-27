package com.ssafy.dto;

public class AddressDTO {
	private String sidoName;
	private String gugunName;
	private String dongName;
	private String dongCode;
	
	public AddressDTO() {
		super();
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

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	@Override
	public String toString() {
		return "AddressDTO [sidoName=" + sidoName + ", gugunName=" + gugunName + ", dongName=" + dongName
				+ ", dongCode=" + dongCode + "]";
	}
	
	
	

}
