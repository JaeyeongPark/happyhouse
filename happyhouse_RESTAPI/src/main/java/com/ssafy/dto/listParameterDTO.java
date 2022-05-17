package com.ssafy.dto;

public class listParameterDTO {
	private String pg;
	private String key;
	private String word;
	private int start;
	private int currentPerPage;
	
	
	
	
	public String getPg() {
		return pg;
	}
	public void setPg(String pg) {
		this.pg = pg;
	}
	public listParameterDTO() {
		super();
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCurrentPerPage() {
		return currentPerPage;
	}
	public void setCurrentPerPage(int currentPerPage) {
		this.currentPerPage = currentPerPage;
	}
	@Override
	public String toString() {
		return "listParameterDTO [pg=" + pg + ", key=" + key + ", word=" + word + ", start=" + start
				+ ", currentPerPage=" + currentPerPage + "]";
	}

}
