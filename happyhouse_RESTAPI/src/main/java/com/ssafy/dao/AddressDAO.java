package com.ssafy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.dto.AddressDTO;

@Mapper
public interface AddressDAO {
	
	public List<AddressDTO> listsido() throws SQLException;
	
	public List<AddressDTO> listgugun(String sidoName) throws SQLException;

	public List<AddressDTO> listdong(String sidoName, String gugunName) throws SQLException;

}
