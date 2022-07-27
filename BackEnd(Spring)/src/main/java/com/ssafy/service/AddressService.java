package com.ssafy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.AddressDTO;

public interface AddressService {
	
	public List<AddressDTO> listsido() throws SQLException;
	
	public List<AddressDTO> listgugun(String sidoName) throws SQLException;

	public List<AddressDTO> listdong(String sidoName, String gugunName) throws SQLException;
	
	public AddressDTO getdongcode(String sidoName, String gugunName, String dongName) throws SQLException;
	
	public List<String> getcategoryvalue(String dongcode, String category) throws SQLException;
	
	 public AddressDTO getAllAddress(String dongcode) throws SQLException;
	
}
