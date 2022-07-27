package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mapper.BoardMapper;
import com.ssafy.dto.BoardCommentDTO;
import com.ssafy.dto.BoardDTO;
import com.ssafy.dto.BoardCategoriSearchDTO;
import com.ssafy.dto.listParameterDTO;
import com.ssafy.util.PageNavigation;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper;

	@Override
	public int insertboard(BoardDTO b) throws SQLException {
		return mapper.insertboard(b);
	}

	@Override
	public List<BoardDTO> listboard(Map<String, Object> map) throws SQLException {
		listParameterDTO lidto = (listParameterDTO) map.get("listParameterDTO");
		BoardCategoriSearchDTO cadto = (BoardCategoriSearchDTO) map.get("BoardCategoriSearchDTO");
		// System.out.println(map);

		int pgno = lidto.getPg() != null ? Integer.parseInt(lidto.getPg()) : 1;
		int countPerPage = 8;
		int start = (pgno - 1) * countPerPage;

		listParameterDTO listParameterDto = new listParameterDTO();
		listParameterDto.setKey(lidto.getKey() == null ? "" : lidto.getKey().trim());
		listParameterDto.setWord(lidto.getWord() == null ? "" : lidto.getWord().trim());
		listParameterDto.setStart(start);
		listParameterDto.setCurrentPerPage(countPerPage);

		map.clear();
		listParameterDto.setPg(lidto.getPg());
		map.put("listParameterDTO", listParameterDto);
		map.put("BoardCategoriSearchDTO", cadto);
		return mapper.listboard(map);
	}

	@Override
	public int deleteboard(BoardDTO b) throws SQLException {
		return mapper.deleteboard(b);
	}

	@Override
	public int updateboard(BoardDTO b) throws SQLException {
		return mapper.updateboard(b);
	}

	@Override
	public BoardDTO boarddetail(String no) throws SQLException {
		return mapper.boarddetail(no);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, Object> map) throws Exception {
		listParameterDTO lidto = (listParameterDTO) map.get("listParameterDTO");
		// part1 pagenavigation 계산
		PageNavigation pageNavigation = new PageNavigation();
		int currentPage = lidto.getPg() != null ? Integer.parseInt(lidto.getPg()) : 1;
		int naviSize = 5;
		int countPerPage = 8;
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setCountPerPage(countPerPage);
		pageNavigation.setNaviSize(naviSize);
		// part2(토탈카운트를 가져오기 위한 용도)
		listParameterDTO listParameterDto = new listParameterDTO();
		listParameterDto.setKey(lidto.getKey() == null ? "" : lidto.getKey().trim());
		listParameterDto.setWord(lidto.getWord() == null ? "" : lidto.getWord().trim());
		map.remove("listParameterDTO");
		map.put("listParameterDTO", listParameterDto);
		int totalCount = mapper.getTotalCount(map);

		// part3 pagenavigation 계산
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / countPerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		pageNavigation.setStartRange(currentPage <= naviSize);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	public void countSerach(String no) {
		mapper.countsearch(no);

	}

	@Override
	public List<BoardDTO> listwholeboard() throws Exception {
		// TODO Auto-generated method stub
		return mapper.listwholeboard();
	}

	@Override
	public List<BoardCommentDTO> boardcomment(String no) throws SQLException {
		// TODO Auto-generated method stub
		return mapper.boardcomment(no);
	}

	@Override
	public int registcomment(BoardCommentDTO commentDTO) throws Exception {
		return mapper.registcomment(commentDTO);
	}

	@Override
	public int deletecomment(String no) throws Exception {
		// TODO Auto-generated method stub
		return mapper.deletecomment(no);
	}

	@Override
	public int updatecomment(BoardCommentDTO commentDTO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.updatecomment(commentDTO);
	}

}
