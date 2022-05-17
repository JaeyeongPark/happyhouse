package com.ssafy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.AddressDAO;
import com.ssafy.dto.AddressDTO;
@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressDAO adao;
	
	@Override
	public List<AddressDTO> listsido() throws SQLException {
		return adao.listsido();
	}

	@Override
	public List<AddressDTO> listgugun(String sidoName) throws SQLException {
		// TODO Auto-generated method stub
		return adao.listgugun(sidoName);
	}

	@Override
	public List<AddressDTO> listdong(String sidoName, String gugunName) throws SQLException {
		// TODO Auto-generated method stub
		return adao.listdong(sidoName, gugunName);
	}
	

}
