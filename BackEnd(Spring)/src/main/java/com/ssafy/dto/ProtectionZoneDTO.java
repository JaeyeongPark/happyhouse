package com.ssafy.dto;

public class ProtectionZoneDTO {
	private String protectionzonecode;
	private String type;
	private String protectionzonename;
	private String address;
	private String oldaddress;
	private String lat;
	private String lng;
	private String management;
	private String police;
	private String cctv;
	private String cctvcnt;
	private String roadlength;
	private String sidoname;
	private String gugunname;
	private String dongname;
	private String dongcode;
	public ProtectionZoneDTO() {
		super();
	}
	public ProtectionZoneDTO(String protectionzonecode, String type, String protectionzonename, String address,
			String oldaddress, String lat, String lng, String management, String police, String cctv, String cctvcnt,
			String roadlength, String sidoname, String gugunname, String dongname, String dongcode) {
		super();
		this.protectionzonecode = protectionzonecode;
		this.type = type;
		this.protectionzonename = protectionzonename;
		this.address = address;
		this.oldaddress = oldaddress;
		this.lat = lat;
		this.lng = lng;
		this.management = management;
		this.police = police;
		this.cctv = cctv;
		this.cctvcnt = cctvcnt;
		this.roadlength = roadlength;
		this.sidoname = sidoname;
		this.gugunname = gugunname;
		this.dongname = dongname;
		this.dongcode = dongcode;
	}
	public String getProtectionzonecode() {
		return protectionzonecode;
	}
	public void setProtectionzonecode(String protectionzonecode) {
		this.protectionzonecode = protectionzonecode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProtectionzonename() {
		return protectionzonename;
	}
	public void setProtectionzonename(String protectionzonename) {
		this.protectionzonename = protectionzonename;
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
	public String getManagement() {
		return management;
	}
	public void setManagement(String management) {
		this.management = management;
	}
	public String getPolice() {
		return police;
	}
	public void setPolice(String police) {
		this.police = police;
	}
	public String getCctv() {
		return cctv;
	}
	public void setCctv(String cctv) {
		this.cctv = cctv;
	}
	public String getCctvcnt() {
		return cctvcnt;
	}
	public void setCctvcnt(String cctvcnt) {
		this.cctvcnt = cctvcnt;
	}
	public String getRoadlength() {
		return roadlength;
	}
	public void setRoadlength(String roadlength) {
		this.roadlength = roadlength;
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
		return "ProtectionZoneDTO [protectionzonecode=" + protectionzonecode + ", type=" + type
				+ ", protectionzonename=" + protectionzonename + ", address=" + address + ", oldaddress=" + oldaddress
				+ ", lat=" + lat + ", lng=" + lng + ", management=" + management + ", police=" + police + ", cctv="
				+ cctv + ", cctvcnt=" + cctvcnt + ", roadlength=" + roadlength + ", sidoname=" + sidoname
				+ ", gugunname=" + gugunname + ", dongname=" + dongname + ", dongcode=" + dongcode + "]";
	}
	
	
	
	
	
}
