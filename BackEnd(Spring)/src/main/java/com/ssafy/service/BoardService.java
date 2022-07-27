package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.dto.BoardCommentDTO;
import com.ssafy.dto.BoardDTO;
import com.ssafy.util.PageNavigation;

public interface BoardService {
	public int insertboard(BoardDTO b) throws SQLException;
	
	public List<BoardDTO> listboard(Map<String, Object> map) throws SQLException;
	
	public BoardDTO boarddetail(String no) throws SQLException;
	
	public List<BoardCommentDTO> boardcomment(String no) throws SQLException;
	
	public int deleteboard(BoardDTO b) throws SQLException;
	
	public int updateboard(BoardDTO b) throws SQLException;
	
	PageNavigation makePageNavigation(Map<String, Object> map) throws Exception;
	
	public void countSerach(String no);
	
	public List<BoardDTO> listwholeboard() throws Exception;
	
	public int registcomment(BoardCommentDTO commentDTO) throws Exception;

	public int deletecomment(String no) throws Exception;
	
	public int updatecomment(BoardCommentDTO commentDTO) throws Exception;
}
