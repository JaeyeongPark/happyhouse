package com.ssafy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.dto.BoardDTO;
import com.ssafy.util.PageNavigation;
@Mapper
public interface BoardDAO {
	
	public int insertboard(BoardDTO b) throws SQLException;
	
	public List<BoardDTO> listboard(Map<String, Object> map) throws SQLException;
	
	public BoardDTO listondeboard(String no) throws SQLException;
	
	public int deleteboard(BoardDTO b) throws SQLException;
	
	public int updateboard(BoardDTO b) throws SQLException;
	
	public int getTotalCount(Map<String, Object> map) throws SQLException;
	
	public void countsearch(String no);
	
	public List<BoardDTO> listwholeboard() throws Exception;

}
