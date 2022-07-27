package com.ssafy.dto;

public class ParkDTO {
	private String parkcode;
	private String parkname;
	private String type;
	private String newaddress;
	private String address;
	private String lat;
	private String lng;
	private String area;
	private String sportsfacility;
	private String usementfacility;
	private String convenfacility;
	private String edufacility;
	private String etcfacility;
	private String management;
	private String contactnumber;
	private String sidoname;
	private String gugunname;
	private String dongname;
	private String dongcode;
	public ParkDTO() {
		super();
	}
	public ParkDTO(String parkcode, String parkname, String type, String newaddress, String address, String lat,
			String lng, String area, String sportsfacility, String usementfacility, String convenfacility,
			String edufacility, String etcfacility, String management, String contactnumber, String sidoname,
			String gugunname, String dongname, String dongcode) {
		super();
		this.parkcode = parkcode;
		this.parkname = parkname;
		this.type = type;
		this.newaddress = newaddress;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.area = area;
		this.sportsfacility = sportsfacility;
		this.usementfacility = usementfacility;
		this.convenfacility = convenfacility;
		this.edufacility = edufacility;
		this.etcfacility = etcfacility;
		this.management = management;
		this.contactnumber = contactnumber;
		this.sidoname = sidoname;
		this.gugunname = gugunname;
		this.dongname = dongname;
		this.dongcode = dongcode;
	}
	public String getParkcode() {
		return parkcode;
	}
	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}
	public String getParkname() {
		return parkname;
	}
	public void setParkname(String parkname) {
		this.parkname = parkname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNewaddress() {
		return newaddress;
	}
	public void setNewaddress(String newaddress) {
		this.newaddress = newaddress;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSportsfacility() {
		return sportsfacility;
	}
	public void setSportsfacility(String sportsfacility) {
		this.sportsfacility = sportsfacility;
	}
	public String getUsementfacility() {
		return usementfacility;
	}
	public void setUsementfacility(String usementfacility) {
		this.usementfacility = usementfacility;
	}
	public String getConvenfacility() {
		return convenfacility;
	}
	public void setConvenfacility(String convenfacility) {
		this.convenfacility = convenfacility;
	}
	public String getEdufacility() {
		return edufacility;
	}
	public void setEdufacility(String edufacility) {
		this.edufacility = edufacility;
	}
	public String getEtcfacility() {
		return etcfacility;
	}
	public void setEtcfacility(String etcfacility) {
		this.etcfacility = etcfacility;
	}
	public String getManagement() {
		return management;
	}
	public void setManagement(String management) {
		this.management = management;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
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
		return "ParkDTO [parkcode=" + parkcode + ", parkname=" + parkname + ", type=" + type + ", newaddress="
				+ newaddress + ", address=" + address + ", lat=" + lat + ", lng=" + lng + ", area=" + area
				+ ", sportsfacility=" + sportsfacility + ", usementfacility=" + usementfacility + ", convenfacility="
				+ convenfacility + ", edufacility=" + edufacility + ", etcfacility=" + etcfacility + ", management="
				+ management + ", contactnumber=" + contactnumber + ", sidoname=" + sidoname + ", gugunname="
				+ gugunname + ", dongname=" + dongname + ", dongcode=" + dongcode + "]";
	}
	
	
	
	
}
