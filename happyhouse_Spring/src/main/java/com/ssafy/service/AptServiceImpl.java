package com.ssafy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.AptDAO;
import com.ssafy.dto.AddressDTO;
import com.ssafy.dto.AptDTO;
import com.ssafy.dto.listParameterDTO;
import com.ssafy.util.PageNavigation;
@Service
public class AptServiceImpl implements AptService{
	@Autowired
	private AptDAO dao;
	
	@Override
	public List<AptDTO> aptlist(Map<String, Object> map) throws SQLException {
		listParameterDTO lidto = (listParameterDTO)map.get("listParameterDTO");
		AddressDTO addto = (AddressDTO)map.get("AddressDTO");
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
		map.put("AddressDTO", addto);
		map.put("listParameterDTO", listParameterDto);
		//System.out.println(map);
		return dao.aptlist(map);
	}
	
	@Override
	public PageNavigation makePageNavigation(Map<String, Object> map)throws Exception {
		listParameterDTO lidto = (listParameterDTO)map.get("listParameterDTO");
		AddressDTO addto = (AddressDTO)map.get("AddressDTO");
		
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
		
		int totalCount = dao.getTotalCount(map);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / countPerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		pageNavigation.setStartRange(currentPage <= naviSize);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		
		return pageNavigation;
	}

}
