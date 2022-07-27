package com.ssafy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dto.AddressDTO;
import com.ssafy.mapper.AddressMapper;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressMapper mapper;
	
	@Override
	public List<AddressDTO> listsido() throws SQLException {
		return mapper.listsido();
	}

	@Override
	public List<AddressDTO> listgugun(String sidoName) throws SQLException {
		// TODO Auto-generated method stub
		return mapper.listgugun(sidoName);
	}

	@Override
	public List<AddressDTO> listdong(String sidoName, String gugunName) throws SQLException {
		// TODO Auto-generated method stub
		return mapper.listdong(sidoName, gugunName);
	}

	@Override
	public AddressDTO getdongcode(String sidoName, String gugunName, String dongName) throws SQLException {
		
		return mapper.getdongcode(sidoName, gugunName, dongName);
	}

	@Override
	public List<String> getcategoryvalue(String dongcode, String category) throws SQLException {
		// TODO Auto-generated method stub
		return mapper.getcategoryvalue(dongcode, category);
	}
	
	
	@Override
    public AddressDTO getAllAddress(String dongcode) throws SQLException {

        return mapper.getAllAddress(dongcode);
    }
	

}
