	package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dto.UserDTO;
import com.ssafy.dto.UserInterestDTO;
import com.ssafy.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;


	@Override
	public int insertUser(UserDTO u) throws SQLException {
		return mapper.insertUser(u);
	}

	@Override
	public int updateUser(UserDTO u) throws SQLException {
		return mapper.updateUser(u);
	}

	@Override
	public int deletetUser(String id) throws SQLException {
		return mapper.deletetUser(id);
	}

	@Override
	public UserDTO login(UserDTO u) throws SQLException {
		return mapper.login(u);
	}

	@Override
	public String searchpw(String searchid) throws SQLException {
		return mapper.searchpw(searchid);
	}

	@Override
	public UserDTO userinfo(String id) throws SQLException {
		return mapper.userinfo(id);
	}

	@Override
	public List<UserInterestDTO> userinterestlist(String id) throws SQLException {
		// TODO Auto-generated method stub
		return mapper.userinterestlist(id);
	}

	@Override
	public int userinterregist(UserInterestDTO uidto) throws SQLException {
		// TODO Auto-generated method stub
		return mapper.userinterregist(uidto);
	}

	@Override
	public UserInterestDTO userinterconfirm(UserInterestDTO uidto) throws SQLException {
		// TODO Auto-generated method stub
		return mapper.userinterconfirm(uidto);
	}

	@Override
	public int userinterdelete(UserInterestDTO uidto) throws SQLException {
		// TODO Auto-generated method stub
		return mapper.userinterdelete(uidto);
	}

	@Override
	public List<UserInterestDTO> userinterdelist(String id) throws SQLException {
		
		return mapper.userinterdelist(id);
	}

//	@Override
//	public UserInterestDTO userinterestdetail(Map<String, Object> map) throws SQLException {
//		// TODO Auto-generated method stub
//		return mapper.userinterestdetail(map);
//	}

}
