package com.ssafy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.AptDAO;
import com.ssafy.dto.AddressDTO;
import com.ssafy.dto.AptDTO;
import com.ssafy.dto.StationDTO;
import com.ssafy.dto.listParameterDTO;
import com.ssafy.util.PageNavigation;
@Service
public class AptServiceImpl implements AptService{
	@Autowired
	private AptDAO dao;
	
	@Override
	public Map<String, Object> aptlist(Map<String, Object> map) throws SQLException {
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
		
		map.clear();
		listParameterDto.setPg(lidto.getPg());
		map.put("AddressDTO", addto);
		map.put("listParameterDTO", listParameterDto);
		
		List<AptDTO> aptlist = dao.aptlist(map);
		
		//알고리즘 구현하기
		List<StationDTO> stationlist = dao.stationlist();
		List<StationDTO> nearstationlist = new ArrayList<StationDTO>();
		
		for (int i = 0; i < aptlist.size(); i++) {
			double aptlat = Double.parseDouble(aptlist.get(i).getLat());
			double aptlng = Double.parseDouble(aptlist.get(i).getLng());
			double min = 987987987.0;
			StationDTO sdto = new StationDTO();
			
			for (int j = 0; j < stationlist.size(); j++) {
				double stalat = Double.parseDouble(stationlist.get(j).getLat());
				double stalng = Double.parseDouble(stationlist.get(j).getLng());
				
				double theta = aptlng - stalng;
		        double dist = 
		        		Math.sin(aptlat*Math.PI / 180.0) * Math.sin(stalat*Math.PI / 180.0) + 
		        		Math.cos(aptlat*Math.PI / 180.0) * Math.cos(stalat*Math.PI / 180.0) * Math.cos(theta*Math.PI / 180.0);
		        dist = Math.acos(dist);
		        dist = dist*180/Math.PI;
		        dist = dist*60*1.1515;
		        
		        dist = dist*1609.344;
		        if(dist < min) {
		        	min = dist;
		        	sdto = stationlist.get(j);
		        }
			}
			nearstationlist.add(sdto);
		}
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("aptlist", aptlist);
		map1.put("nearstationlist", nearstationlist);
		
		return map1;
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
