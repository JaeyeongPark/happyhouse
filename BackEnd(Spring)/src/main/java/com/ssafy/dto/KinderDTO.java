package com.ssafy.dto;

public class KinderDTO {
	private String kindercode;
	private String eduoffice;
	private String edusupportoffice;
	private String kindername;
	private String type;
	private String representative;
	private String director;
	private String address;
	private String oldaddress;
	private String contactnumber;
	private String website;
	private String operationtime;
	private String maxnum;
	private String sidoname;
	private String gugunname;
	private String dongname;
	private String dongcode;
	
	
	
	
	@Override
	public String toString() {
		return "KinderDTO [kindercode=" + kindercode + ", eduoffice=" + eduoffice + ", edusupportoffice="
				+ edusupportoffice + ", kindername=" + kindername + ", type=" + type + ", representative="
				+ representative + ", director=" + director + ", address=" + address + ", oldaddress=" + oldaddress
				+ ", contactnumber=" + contactnumber + ", website=" + website + ", operationtime=" + operationtime
				+ ", maxnum=" + maxnum + ", sidoname=" + sidoname + ", gugunname=" + gugunname + ", dongname="
				+ dongname + ", dongcode=" + dongcode + "]";
	}
	public KinderDTO() {
		super();
	}
	public KinderDTO(String kindercode, String eduoffice, String edusupportoffice, String kindername, String type,
			String representative, String director, String address, String oldaddress, String contactnumber,
			String website, String operationtime, String maxnum, String sidoname, String gugunname, String dongname,
			String dongcode) {
		super();
		this.kindercode = kindercode;
		this.eduoffice = eduoffice;
		this.edusupportoffice = edusupportoffice;
		this.kindername = kindername;
		this.type = type;
		this.representative = representative;
		this.director = director;
		this.address = address;
		this.oldaddress = oldaddress;
		this.contactnumber = contactnumber;
		this.website = website;
		this.operationtime = operationtime;
		this.maxnum = maxnum;
		this.sidoname = sidoname;
		this.gugunname = gugunname;
		this.dongname = dongname;
		this.dongcode = dongcode;
	}
	public String getKindercode() {
		return kindercode;
	}
	public void setKindercode(String kindercode) {
		this.kindercode = kindercode;
	}
	public String getEduoffice() {
		return eduoffice;
	}
	public void setEduoffice(String eduoffice) {
		this.eduoffice = eduoffice;
	}
	public String getEdusupportoffice() {
		return edusupportoffice;
	}
	public void setEdusupportoffice(String edusupportoffice) {
		this.edusupportoffice = edusupportoffice;
	}
	public String getKindername() {
		return kindername;
	}
	public void setKindername(String kindername) {
		this.kindername = kindername;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRepresentative() {
		return representative;
	}
	public void setRepresentative(String representative) {
		this.representative = representative;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOldaddress() {
		return oldaddress;
	}
	public void setOldaddress(String oldaddress) {
		this.oldaddress = oldaddress;
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
	public String getOperationtime() {
		return operationtime;
	}
	public void setOperationtime(String operationtime) {
		this.operationtime = operationtime;
	}
	public String getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(String maxnum) {
		this.maxnum = maxnum;
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
	
	
	
	
	
}
