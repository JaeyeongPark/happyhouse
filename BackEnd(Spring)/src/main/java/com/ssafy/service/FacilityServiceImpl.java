package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dto.FacilityCategorySearchDTO;
import com.ssafy.dto.listParameterDTO;
import com.ssafy.mapper.FacilityMapper;
//import com.ssafy.mapper.map;
import com.ssafy.util.PageNavigation;

@Service
public class FacilityServiceImpl implements FacilityService{

	@Autowired
	private FacilityMapper mapper;

	@Override
	public List<?> facilitylist(Map<String, Object> map) throws SQLException {
		listParameterDTO lidto = (listParameterDTO)map.get("listParameterDTO");
		
		int pgno = lidto.getPg() != null ? Integer.parseInt(lidto.getPg()) : 1;
		int countPerPage = 50;
		int start= (pgno - 1) * countPerPage;
		
		listParameterDTO listParameterDto = new listParameterDTO();
		listParameterDto.setKey(lidto.getKey() == null ? "" : lidto.getKey().trim());
		listParameterDto.setWord(lidto.getWord() == null ? "" : lidto.getWord().trim());
		listParameterDto.setStart(start);
		listParameterDto.setCurrentPerPage(countPerPage);
		listParameterDto.setPg(lidto.getPg());
		
		map.remove("listParameterDTO");
		map.put("listParameterDTO", listParameterDto);
		
		FacilityCategorySearchDTO fdto = (FacilityCategorySearchDTO)map.get("FacilityCategorySearchDTO");
		String category = fdto.getCategory();
		if(category.equals("academy")) {
			return mapper.academylist(map);
		}
		if(category.equals("kinder")) {
			return mapper.kinderlist(map);
		}
		if(category.equals("nursery")) {
			return mapper.nurserylist(map);
		}
		if(category.equals("school")) {
			return mapper.schoollist(map);
		}
		if(category.equals("protectionzone")) {
			return mapper.protectionzonelist(map);
		}
		if(category.equals("park")) {
			return mapper.parklist(map);
		}
		
		return null;

	}

	@Override
	public PageNavigation makePageNavigation(Map<String, Object> map) throws Exception {
		listParameterDTO lidto = (listParameterDTO)map.get("listParameterDTO");

		PageNavigation pageNavigation = new PageNavigation();
		int currentPage = lidto.getPg() != null ? Integer.parseInt(lidto.getPg()) : 1;
		int naviSize = 3;
		int countPerPage = 50;
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setCountPerPage(countPerPage);
		pageNavigation.setNaviSize(naviSize);
		
		listParameterDTO listParameterDto = new listParameterDTO();
		listParameterDto.setKey(lidto.getKey() == null ? "" : lidto.getKey().trim());
		listParameterDto.setWord(lidto.getWord() == null ? "" : lidto.getWord().trim());
		
		map.remove("listParameterDTO");
		map.put("listParameterDTO", listParameterDto);

		int totalCount = mapper.getTotalCount(map);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / countPerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		pageNavigation.setStartRange(currentPage <= naviSize);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		System.out.println(3);
		return pageNavigation;
	}

	@Override
	public List<?> facilitydetail(String category, String code) throws SQLException {
		if(category.equals("academy")) {
			System.out.println("1 "+category+" "+code);
			return mapper.academydetail(category,code);
		}
		if(category.equals("kinder")) {
			System.out.println("2 "+category+" "+code);
			return mapper.kinderdetail(category,code);
		}
		if(category.equals("nursery")) {
			System.out.println("3 "+category+" "+code);
			return mapper.nurserydetail(category,code);
		}
		if(category.equals("school")) {
			System.out.println("4 "+category+" "+code);
			return mapper.schooldetail(category,code);
		}
		if(category.equals("protectionzone")) {
			System.out.println("5 "+category+" "+code);
			return mapper.protectionzonedetail(category,code);
		}
		if(category.equals("park")) {
			System.out.println("6 "+category+" "+code);
			return mapper.parkdetail(category,code);
		}
		return null;
	}
	
	

}
