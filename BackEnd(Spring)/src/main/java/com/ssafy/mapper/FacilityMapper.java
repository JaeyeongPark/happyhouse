package com.ssafy.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.dto.AcademyDTO;
import com.ssafy.dto.AptDTO;
import com.ssafy.dto.KinderDTO;
import com.ssafy.dto.NurseryDTO;
import com.ssafy.dto.ParkDTO;
import com.ssafy.dto.ProtectionZoneDTO;
import com.ssafy.dto.SchoolDTO;

@Mapper
public interface FacilityMapper {
	
	List<AcademyDTO> academylist(Map<String, Object> map) throws SQLException;
	List<KinderDTO> kinderlist(Map<String, Object> map) throws SQLException;
	List<NurseryDTO> nurserylist(Map<String, Object> map) throws SQLException;
	List<SchoolDTO> schoollist(Map<String, Object> map) throws SQLException;
	List<ProtectionZoneDTO> protectionzonelist(Map<String, Object> map) throws SQLException;
	List<ParkDTO>  parklist(Map<String, Object> map) throws SQLException;
	
	List<AcademyDTO> academydetail(String category, String code) throws SQLException;
	List<KinderDTO> kinderdetail(String category, String code) throws SQLException;
	List<NurseryDTO> nurserydetail(String category, String code) throws SQLException;
	List<SchoolDTO> schooldetail(String category, String code) throws SQLException;
	List<ProtectionZoneDTO> protectionzonedetail(String category, String code) throws SQLException;
	List<ParkDTO> parkdetail(String category, String code) throws SQLException;
	
	int getTotalCount(Map<String, Object> map) throws SQLException;

}
