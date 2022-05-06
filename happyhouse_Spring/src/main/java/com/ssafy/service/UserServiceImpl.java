package com.ssafy.service;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.UserDAO;
import com.ssafy.dto.UserDTO;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO udao;


	@Override
	public int insertUser(UserDTO u) throws SQLException {
		return udao.insertUser(u);
	}

	@Override
	public int updateUser(UserDTO u) throws SQLException {
		return udao.updateUser(u);
	}

	@Override
	public int deletetUser(String id) throws SQLException {
		return udao.deletetUser(id);
	}

	@Override
	public UserDTO login(Map<String, String> map) throws SQLException {
		return udao.login(map);
	}

	@Override
	public String searchpw(String searchid) throws SQLException {
		return udao.searchpw(searchid);
	}

	@Override
	public UserDTO userinfo(String id) throws SQLException {
		return udao.userinfo(id);
	}


}
