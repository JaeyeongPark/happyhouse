package com.ssafy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ssafy.dto.AptDTO;
import com.ssafy.util.PageNavigation;

public interface AptService {

	List<AptDTO> aptlist(Map<String, Object> map) throws SQLException;
	PageNavigation makePageNavigation(Map<String, Object> map) throws Exception;
}
