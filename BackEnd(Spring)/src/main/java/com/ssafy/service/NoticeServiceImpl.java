package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dto.BoardCategoriSearchDTO;
import com.ssafy.dto.NoticeDTO;
import com.ssafy.dto.listParameterDTO;
import com.ssafy.mapper.BoardMapper;
import com.ssafy.mapper.NoticeMapper;
import com.ssafy.util.PageNavigation;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper mapper;
	
	@Override
	public List<NoticeDTO> listnotice(Map<String, Object> map) throws SQLException {
		listParameterDTO lidto = (listParameterDTO) map.get("listParameterDTO");
		

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
//		System.out.println(listParameterDto);
		List<NoticeDTO> ndto = mapper.listnotice(map);
		System.out.println("출력");
		System.out.println(ndto);
		System.out.println("출력"+mapper.listnotice(map));
		
		return mapper.listnotice(map);
		
		
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, Object> map) throws Exception {
		listParameterDTO lidto = (listParameterDTO) map.get("listParameterDTO");
		// part1 pagenavigation 계산
		PageNavigation pageNavigation = new PageNavigation();
		int currentPage = lidto.getPg() != null ? Integer.parseInt(lidto.getPg()) : 1;
		int naviSize = 3;
		int countPerPage = 10;
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
	public NoticeDTO noticedetail(String no) {
		// TODO Auto-generated method stub
		return mapper.noticedetail(no);
	}

}
