package com.ssafy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.dto.BoardDTO;
@Mapper
public interface BoardDAO {
	
	public int insertboard(BoardDTO b) throws SQLException;
	
	public List<BoardDTO> listboard() throws SQLException;
	
	public BoardDTO listondeboard(String no) throws SQLException;
	
	public int deleteboard(BoardDTO b) throws SQLException;
	
	public int updateboard(BoardDTO b) throws SQLException;

}
