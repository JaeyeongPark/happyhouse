package com.ssafy.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {

	List<NoticeDTO> listnotice(Map<String, Object> map);
	
	public int getTotalCount(Map<String, Object> map) throws SQLException;

	NoticeDTO noticedetail(String no);

}
