package com.ssafy.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.dto.UserDTO;

@Mapper
public interface UserDAO {
	public int insertUser(UserDTO u) throws SQLException;
	
	public int updateUser(UserDTO u) throws SQLException;
	
	public int deletetUser(String id) throws SQLException;

	public UserDTO login(Map<String, String> map) throws SQLException;

	public String searchpw(String searchid) throws SQLException;
	
	public UserDTO userinfo(String id) throws SQLException;


}
