package com.ssafy.dto;

public class AptDTO {
	private String no;
	private String aptCode;
	private String dongCode;
	private String bulidYear;
	private String apartmentName;
	private String lat;
	private String lng;
	private String dealAmount;
	private String dealYear;
	private String dealMonth;
	private String dealDay;
	private String area;
	private String floor;
	private String sidoName;
	private String gugunName;
	private String dongName;
	private String roadName;
	public AptDTO() {
		super();
	}
	public AptDTO(String no, String aptCode, String dongCode, String bulidYear, String apartmentName, String lat,
			String lng, String dealAmount, String dealYear, String dealMonth, String dealDay, String area, String floor,
			String sidoName, String gugunName, String dongName, String roadName) {
		super();
		this.no = no;
		this.aptCode = aptCode;
		this.dongCode = dongCode;
		this.bulidYear = bulidYear;
		this.apartmentName = apartmentName;
		this.lat = lat;
		this.lng = lng;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
		this.roadName = roadName;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getAptCode() {
		return aptCode;
	}
	public void setAptCode(String aptCode) {
		this.aptCode = aptCode;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getBulidYear() {
		return bulidYear;
	}
	public void setBulidYear(String bulidYear) {
		this.bulidYear = bulidYear;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
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
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getDealYear() {
		return dealYear;
	}
	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}
	public String getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}
	public String getDealDay() {
		return dealDay;
	}
	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
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
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	@Override
	public String toString() {
		return "AptDTO [no=" + no + ", aptCode=" + aptCode + ", dongCode=" + dongCode + ", bulidYear=" + bulidYear
				+ ", apartmentName=" + apartmentName + ", lat=" + lat + ", lng=" + lng + ", dealAmount=" + dealAmount
				+ ", dealYear=" + dealYear + ", dealMonth=" + dealMonth + ", dealDay=" + dealDay + ", area=" + area
				+ ", floor=" + floor + ", sidoName=" + sidoName + ", gugunName=" + gugunName + ", dongName=" + dongName
				+ ", roadName=" + roadName + "]";
	}
	
	
	
	

}
