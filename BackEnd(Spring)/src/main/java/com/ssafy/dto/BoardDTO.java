package com.ssafy.dto;

public class BoardDTO {
	private String boardno;
	private String id;
	private String subject;
	private String content;
	private String nicepoint;
	private String joindate;
	private String dongcode;
	private String category;
	private String categoryvalue;
	private String sidoName;
	private String gugunName;
	private String dongName;
	public BoardDTO() {
		super();
	}
	public BoardDTO(String boardno, String id, String subject, String content, String nicepoint, String joindate,
			String dongcode, String category, String categoryvalue, String sidoName, String gugunName,
			String dongName) {
		super();
		this.boardno = boardno;
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.nicepoint = nicepoint;
		this.joindate = joindate;
		this.dongcode = dongcode;
		this.category = category;
		this.categoryvalue = categoryvalue;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
	}
	public String getBoardno() {
		return boardno;
	}
	public void setBoardno(String boardno) {
		this.boardno = boardno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNicepoint() {
		return nicepoint;
	}
	public void setNicepoint(String nicepoint) {
		this.nicepoint = nicepoint;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
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
		return "BoardDTO [boardno=" + boardno + ", id=" + id + ", subject=" + subject + ", content=" + content
				+ ", nicepoint=" + nicepoint + ", joindate=" + joindate + ", dongcode=" + dongcode + ", category="
				+ category + ", categoryvalue=" + categoryvalue + ", sidoName=" + sidoName + ", gugunName=" + gugunName
				+ ", dongName=" + dongName + "]";
	}
	
	
	
	
	
}
