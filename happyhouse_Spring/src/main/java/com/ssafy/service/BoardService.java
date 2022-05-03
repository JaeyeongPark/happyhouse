package com.ssafy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.BoardDTO;

public interface BoardService {
	
	public int insertboard(BoardDTO b) throws SQLException;
	
	public List<BoardDTO> listboard() throws SQLException;
	
	public BoardDTO listondeboard(String no) throws SQLException;
	
	public int deleteboard(BoardDTO b) throws SQLException;
	
	public int updateboard(BoardDTO b) throws SQLException;

}
