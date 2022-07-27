package com.ssafy.dto;

public class BoardCommentDTO {
	private String commentno;
	private String id;
	private String boardno;
	private String comment;
	
	public BoardCommentDTO(String commentno, String id, String boardno, String comment) {
		super();
		this.commentno = commentno;
		this.id = id;
		this.boardno = boardno;
		this.comment = comment;
	}
	public BoardCommentDTO() {
		super();
	}
	
	public String getCommentno() {
		return commentno;
	}
	public void setCommentno(String commentno) {
		this.commentno = commentno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBoardno() {
		return boardno;
	}
	public void setBoardno(String boardno) {
		this.boardno = boardno;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "BoardCommentDTO [commentno=" + commentno + ", id=" + id + ", boardno=" + boardno + ", comment="
				+ comment + "]";
	}

}
