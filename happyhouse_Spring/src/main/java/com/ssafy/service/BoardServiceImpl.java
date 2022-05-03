package com.ssafy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.BoardDAO;
import com.ssafy.dto.BoardDTO;
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO bdao;
	

	@Override
	public int insertboard(BoardDTO b) throws SQLException {
		return bdao.insertboard(b);
	}

	@Override
	public List<BoardDTO> listboard() throws SQLException {
		return bdao.listboard();
	}

	@Override
	public int deleteboard(BoardDTO b) throws SQLException {
		return bdao.deleteboard(b);
	}

	@Override
	public int updateboard(BoardDTO b) throws SQLException {
		return bdao.updateboard(b);
	}

	@Override
	public BoardDTO listondeboard(String no) throws SQLException {
		return bdao.listondeboard(no);
	}

}
