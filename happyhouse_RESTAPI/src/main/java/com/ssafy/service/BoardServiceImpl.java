package com.ssafy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.BoardDAO;
import com.ssafy.dto.AddressDTO;
import com.ssafy.dto.BoardDTO;
import com.ssafy.dto.listParameterDTO;
import com.ssafy.util.PageNavigation;
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO bdao;
	

	@Override
	public int insertboard(BoardDTO b) throws SQLException {
		return bdao.insertboard(b);
	}

	@Override
	public List<BoardDTO> listboard(Map<String, Object> map) throws SQLException {
		listParameterDTO lidto = (listParameterDTO)map.get("listParameterDTO");
		//System.out.println(map);
		
		int pgno = lidto.getPg() != null ? Integer.parseInt(lidto.getPg()) : 1;
		int countPerPage = 3;
		int start= (pgno - 1) * countPerPage;
		
		listParameterDTO listParameterDto = new listParameterDTO();
		listParameterDto.setKey(lidto.getKey() == null ? "" : lidto.getKey().trim());
		listParameterDto.setWord(lidto.getWord() == null ? "" : lidto.getWord().trim());
		listParameterDto.setStart(start);
		listParameterDto.setCurrentPerPage(countPerPage);
		//System.out.println("서비스단에선");
		//System.out.println(sido + " " + gugun + " " + dong+" "+pgno+" "+listParameterDto.toString());
		map.clear();
		listParameterDto.setPg(lidto.getPg());
		map.put("listParameterDTO", listParameterDto);
		
		return bdao.listboard(map);
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

	@Override
	public PageNavigation makePageNavigation(Map<String, Object> map) throws Exception {
		listParameterDTO lidto = (listParameterDTO)map.get("listParameterDTO");
		
		PageNavigation pageNavigation = new PageNavigation();
		int currentPage = lidto.getPg() != null ? Integer.parseInt(lidto.getPg()) : 1;
		int naviSize = 3;
		int countPerPage = 3;
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setCountPerPage(countPerPage);
		pageNavigation.setNaviSize(naviSize);
		
		listParameterDTO listParameterDto = new listParameterDTO();
		listParameterDto.setKey(lidto.getKey() == null ? "" : lidto.getKey().trim());
		listParameterDto.setWord(lidto.getWord() == null ? "" : lidto.getWord().trim());
		
		map.remove("listParameterDTO");
		map.put("listParameterDTO", listParameterDto);
		
		int totalCount = bdao.getTotalCount(map);
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
        bdao.countsearch(no);

    }

	@Override
	public List<BoardDTO> listwholeboard() throws Exception {
		// TODO Auto-generated method stub
		return bdao.listwholeboard();
	}

}
