package com.ssafy.dto;

public class NoticeDTO {
	String noticeno;
	String id;
	String subject;
	String content;
	String joindate;
	public NoticeDTO(String noticeno, String id, String subject, String content, String joindate) {
		super();
		this.noticeno = noticeno;
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.joindate = joindate;
	}
	public NoticeDTO() {
		super();
	}
	public String getNoticeno() {
		return noticeno;
	}
	public void setNoticeno(String noticeno) {
		this.noticeno = noticeno;
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
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "NoticeDTO [noticeno=" + noticeno + ", id=" + id + ", subject=" + subject + ", content=" + content
				+ ", joindate=" + joindate + "]";
	}
	
	
}
