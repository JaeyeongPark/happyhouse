package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//import com.ssafy.mapper.map;
import com.ssafy.util.PageNavigation;


public interface FacilityService {
	
	List<?> facilitylist(Map<String, Object> map) throws SQLException;
	List<?> facilitydetail(String category, String code) throws SQLException;
	PageNavigation makePageNavigation(Map<String, Object> map) throws Exception;

}
