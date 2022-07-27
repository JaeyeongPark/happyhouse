package com.ssafy.dto;

public class NurseryDTO {
	private String nurserycode;
	private String nurseryname;
	private String type;
	private String operation;
	private String postcode;
	private String address;
	private String contactnumber;
	private String roomcnt;
	private String roomarea;
	private String playground;
	private String teacher;
	private String maxnum;
	private String curnum;
	private String lat;
	private String lng;
	private String bus;
	private String website;
	private String sidoname;
	private String gugunname;
	private String dongname;
	private String dongcode;
	public NurseryDTO() {
		super();
	}
	public NurseryDTO(String nurserycode, String nurseryname, String type, String operation, String postcode,
			String address, String contactnumber, String roomcnt, String roomarea, String playground, String teacher,
			String maxnum, String curnum, String lat, String lng, String bus, String website, String sidoname,
			String gugunname, String dongname, String dongcode) {
		super();
		this.nurserycode = nurserycode;
		this.nurseryname = nurseryname;
		this.type = type;
		this.operation = operation;
		this.postcode = postcode;
		this.address = address;
		this.contactnumber = contactnumber;
		this.roomcnt = roomcnt;
		this.roomarea = roomarea;
		this.playground = playground;
		this.teacher = teacher;
		this.maxnum = maxnum;
		this.curnum = curnum;
		this.lat = lat;
		this.lng = lng;
		this.bus = bus;
		this.website = website;
		this.sidoname = sidoname;
		this.gugunname = gugunname;
		this.dongname = dongname;
		this.dongcode = dongcode;
	}
	public String getNurserycode() {
		return nurserycode;
	}
	public void setNurserycode(String nurserycode) {
		this.nurserycode = nurserycode;
	}
	public String getNurseryname() {
		return nurseryname;
	}
	public void setNurseryname(String nurseryname) {
		this.nurseryname = nurseryname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
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
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getRoomcnt() {
		return roomcnt;
	}
	public void setRoomcnt(String roomcnt) {
		this.roomcnt = roomcnt;
	}
	public String getRoomarea() {
		return roomarea;
	}
	public void setRoomarea(String roomarea) {
		this.roomarea = roomarea;
	}
	public String getPlayground() {
		return playground;
	}
	public void setPlayground(String playground) {
		this.playground = playground;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(String maxnum) {
		this.maxnum = maxnum;
	}
	public String getCurnum() {
		return curnum;
	}
	public void setCurnum(String curnum) {
		this.curnum = curnum;
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
	public String getBus() {
		return bus;
	}
	public void setBus(String bus) {
		this.bus = bus;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
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
		return "NurseryDTO [nurserycode=" + nurserycode + ", nurseryname=" + nurseryname + ", type=" + type
				+ ", operation=" + operation + ", postcode=" + postcode + ", address=" + address + ", contactnumber="
				+ contactnumber + ", roomcnt=" + roomcnt + ", roomarea=" + roomarea + ", playground=" + playground
				+ ", teacher=" + teacher + ", maxnum=" + maxnum + ", curnum=" + curnum + ", lat=" + lat + ", lng=" + lng
				+ ", bus=" + bus + ", website=" + website + ", sidoname=" + sidoname + ", gugunname=" + gugunname
				+ ", dongname=" + dongname + ", dongcode=" + dongcode + "]";
	}
	
	
	
}
