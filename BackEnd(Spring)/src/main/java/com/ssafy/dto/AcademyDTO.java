package com.ssafy.dto;

public class AcademyDTO {
	private String academycode;
	private String eduofficecode;
	private String eduoffice;
	private String type;
	private String academyname;
	private String state;
	private String maxnum;
	private String posnum;
	private String edutype;
	private String edulist;
	private String edudetail;
	private String postcode;
	private String address;
	private String sidoname;
	private String gugunname;
	private String dongname;
	private String dongcode;
	public AcademyDTO() {
		super();
	}
	public AcademyDTO(String academycode, String eduofficecode, String eduoffice, String type, String academyname,
			String state, String maxnum, String posnum, String edutype, String edulist, String edudetail,
			String postcode, String address, String sidoname, String gugunname, String dongname, String dongcode) {
		super();
		this.academycode = academycode;
		this.eduofficecode = eduofficecode;
		this.eduoffice = eduoffice;
		this.type = type;
		this.academyname = academyname;
		this.state = state;
		this.maxnum = maxnum;
		this.posnum = posnum;
		this.edutype = edutype;
		this.edulist = edulist;
		this.edudetail = edudetail;
		this.postcode = postcode;
		this.address = address;
		this.sidoname = sidoname;
		this.gugunname = gugunname;
		this.dongname = dongname;
		this.dongcode = dongcode;
	}
	public String getAcademycode() {
		return academycode;
	}
	public void setAcademycode(String academycode) {
		this.academycode = academycode;
	}
	public String getEduofficecode() {
		return eduofficecode;
	}
	public void setEduofficecode(String eduofficecode) {
		this.eduofficecode = eduofficecode;
	}
	public String getEduoffice() {
		return eduoffice;
	}
	public void setEduoffice(String eduoffice) {
		this.eduoffice = eduoffice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAcademyname() {
		return academyname;
	}
	public void setAcademyname(String academyname) {
		this.academyname = academyname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(String maxnum) {
		this.maxnum = maxnum;
	}
	public String getPosnum() {
		return posnum;
	}
	public void setPosnum(String posnum) {
		this.posnum = posnum;
	}
	public String getEdutype() {
		return edutype;
	}
	public void setEdutype(String edutype) {
		this.edutype = edutype;
	}
	public String getEdulist() {
		return edulist;
	}
	public void setEdulist(String edulist) {
		this.edulist = edulist;
	}
	public String getEdudetail() {
		return edudetail;
	}
	public void setEdudetail(String edudetail) {
		this.edudetail = edudetail;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSidoname() {
		return sidoname;
	}
	public void setSidoname(String sidoname) {
		this.sidoname = sidoname;
	}
	public String getGugunname() {
		return gugunname;
	}
	public void setGugunname(String gugunname) {
		this.gugunname = gugunname;
	}
	public String getDongname() {
		return dongname;
	}
	public void setDongname(String dongname) {
		this.dongname = dongname;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	@Override
	public String toString() {
		return "AcademyDTO [academycode=" + academycode + ", eduofficecode=" + eduofficecode + ", eduoffice="
				+ eduoffice + ", type=" + type + ", academyname=" + academyname + ", state=" + state + ", maxnum="
				+ maxnum + ", posnum=" + posnum + ", edutype=" + edutype + ", edulist=" + edulist + ", edudetail="
				+ edudetail + ", postcode=" + postcode + ", address=" + address + ", sidoname=" + sidoname
				+ ", gugunname=" + gugunname + ", dongname=" + dongname + ", dongcode=" + dongcode + "]";
	}
	
	
	
	
	
	
	
}
