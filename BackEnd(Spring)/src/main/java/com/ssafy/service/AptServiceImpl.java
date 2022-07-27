package com.ssafy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dto.AddressDTO;
import com.ssafy.dto.AptDTO;
//import com.ssafy.dto.StationDTO;
import com.ssafy.dto.listParameterDTO;
import com.ssafy.mapper.AptMapper;
import com.ssafy.util.PageNavigation;
@Service
public class AptServiceImpl implements AptService{
	@Autowired
	private AptMapper mapper;
	
	@Override
	public Map<String, Object> aptlist(Map<String, Object> map) throws SQLException {
		listParameterDTO lidto = (listParameterDTO)map.get("listParameterDTO");
		AddressDTO addto = (AddressDTO)map.get("AddressDTO");
		String dealYear = (String)map.get("dealYear");
		
		int pgno = lidto.getPg() != null ? Integer.parseInt(lidto.getPg()) : 1;
		int countPerPage = 1000;
		int start= (pgno - 1) * countPerPage;
		
		listParameterDTO listParameterDto = new listParameterDTO();
		listParameterDto.setKey(lidto.getKey() == null ? "" : lidto.getKey().trim());
		listParameterDto.setWord(lidto.getWord() == null ? "" : lidto.getWord().trim());
		listParameterDto.setStart(start);
		listParameterDto.setCurrentPerPage(countPerPage);
		
		map.clear();
		listParameterDto.setPg(lidto.getPg());
		map.put("AddressDTO", addto);
		map.put("listParameterDTO", listParameterDto);
		map.put("dealYear", dealYear);
		List<AptDTO> aptlist = mapper.aptlist(map);

		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("aptlist", aptlist);
//		map1.put("nearstationlist", nearstationlist);
		return map1;
	}
	
	@Override
	public PageNavigation makePageNavigation(Map<String, Object> map)throws Exception {
		listParameterDTO lidto = (listParameterDTO)map.get("listParameterDTO");
		AddressDTO addto = (AddressDTO)map.get("AddressDTO");
		
		PageNavigation pageNavigation = new PageNavigation();
		int currentPage = lidto.getPg() != null ? Integer.parseInt(lidto.getPg()) : 1;
		int naviSize = 3;
		int countPerPage = 1000;
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setCountPerPage(countPerPage);
		pageNavigation.setNaviSize(naviSize);
		
		listParameterDTO listParameterDto = new listParameterDTO();
		listParameterDto.setKey(lidto.getKey() == null ? "" : lidto.getKey().trim());
		listParameterDto.setWord(lidto.getWord() == null ? "" : lidto.getWord().trim());
		listParameterDto.setPg(lidto.getPg());
		map.remove("listParameterDTO");
		map.put("listParameterDTO", listParameterDto);
		System.out.println("3 : "+map);
		System.out.println(map);
		int totalCount = mapper.getTotalCount(map);
		System.out.println(totalCount);
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
	public AptDTO aptdetail(Map<String, Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return mapper.aptdetail(map);
	}

}
