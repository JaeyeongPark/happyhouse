package com.ssafy.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.dto.UserDTO;
import com.ssafy.dto.UserInterestDTO;

@Mapper
public interface UserMapper {
	public int insertUser(UserDTO u) throws SQLException;
	
	public int updateUser(UserDTO u) throws SQLException;
	
	public int deletetUser(String id) throws SQLException;

	public UserDTO login(UserDTO u) throws SQLException;

	public String searchpw(String searchid) throws SQLException;
	
	public UserDTO userinfo(String id) throws SQLException;
	
	public List<UserInterestDTO> userinterestlist(String id) throws SQLException;
	
	public int userinterregist (UserInterestDTO uidto) throws SQLException;
	
	public UserInterestDTO userinterconfirm (UserInterestDTO uidto) throws SQLException;
	
	public int userinterdelete (UserInterestDTO uidto) throws SQLException;
	
	public List<UserInterestDTO> userinterdelist (String id) throws SQLException;

//	public UserInterestDTO userinterestdetail(Map<String, Object> map) throws SQLException;

}
