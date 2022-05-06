package com.ssafy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.dto.AptDTO;
import com.ssafy.dto.StationDTO;
import com.ssafy.dto.listParameterDTO;
@Mapper
public interface AptDAO {

	List<AptDTO> aptlist(Map<String, Object> map) throws SQLException;
	List<StationDTO> stationlist() throws SQLException;
	int getTotalCount(Map<String, Object> map) throws SQLException;
}
