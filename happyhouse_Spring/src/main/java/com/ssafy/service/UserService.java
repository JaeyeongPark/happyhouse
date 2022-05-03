package com.ssafy.service;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.dto.UserDTO;


public interface UserService {
	
	public int insertUser(UserDTO u) throws SQLException;
	
	public int updateUser(UserDTO u) throws SQLException;
	
	public int deletetUser(String id) throws SQLException;

	public UserDTO login(Map<String, String> map) throws SQLException;

	public String searchpw(String searchid) throws SQLException;

}
