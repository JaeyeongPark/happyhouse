package com.ssafy.dto;

public class SchoolDTO {
	private String schoolcode;
	private String eduoffice;
	private String schoolnum;
	private String schoolname;
	private String type;
	private String anniversary;
	private String dongcode;
	private String address;
	private String lat;
	private String lng;
	private String contactnumber;
	private String website;
	private String boynum;
	private String girlnum;
	private String studentnum;
	private String sidoname;
	private String gugunname;
	private String dongname;
	public SchoolDTO() {
		super();
	}
	public SchoolDTO(String schoolcode, String eduoffice, String schoolnum, String schoolname, String type,
			String anniversary, String dongcode, String address, String lat, String lng, String contactnumber,
			String website, String boynum, String girlnum, String studentnum, String sidoname, String gugunname,
			String dongname) {
		super();
		this.schoolcode = schoolcode;
		this.eduoffice = eduoffice;
		this.schoolnum = schoolnum;
		this.schoolname = schoolname;
		this.type = type;
		this.anniversary = anniversary;
		this.dongcode = dongcode;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.contactnumber = contactnumber;
		this.website = website;
		this.boynum = boynum;
		this.girlnum = girlnum;
		this.studentnum = studentnum;
		this.sidoname = sidoname;
		this.gugunname = gugunname;
		this.dongname = dongname;
	}
	public String getSchoolcode() {
		return schoolcode;
	}
	public void setSchoolcode(String schoolcode) {
		this.schoolcode = schoolcode;
	}
	public String getEduoffice() {
		return eduoffice;
	}
	public void setEduoffice(String eduoffice) {
		this.eduoffice = eduoffice;
	}
	public String getSchoolnum() {
		return schoolnum;
	}
	public void setSchoolnum(String schoolnum) {
		this.schoolnum = schoolnum;
	}
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAnniversary() {
		return anniversary;
	}
	public void setAnniversary(String anniversary) {
		this.anniversary = anniversary;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getBoynum() {
		return boynum;
	}
	public void setBoynum(String boynum) {
		this.boynum = boynum;
	}
	public String getGirlnum() {
		return girlnum;
	}
	public void setGirlnum(String girlnum) {
		this.girlnum = girlnum;
	}
	public String getStudentnum() {
		return studentnum;
	}
	public void setStudentnum(String studentnum) {
		this.studentnum = studentnum;
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
	@Override
	public String toString() {
		return "SchoolDTO [schoolcode=" + schoolcode + ", eduoffice=" + eduoffice + ", schoolnum=" + schoolnum
				+ ", schoolname=" + schoolname + ", type=" + type + ", anniversary=" + anniversary + ", dongcode="
				+ dongcode + ", address=" + address + ", lat=" + lat + ", lng=" + lng + ", contactnumber="
				+ contactnumber + ", website=" + website + ", boynum=" + boynum + ", girlnum=" + girlnum
				+ ", studentnum=" + studentnum + ", sidoname=" + sidoname + ", gugunname=" + gugunname + ", dongname="
				+ dongname + "]";
	}

	
}
