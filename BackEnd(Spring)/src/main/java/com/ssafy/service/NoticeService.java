package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.dto.BoardDTO;
import com.ssafy.dto.NoticeDTO;
import com.ssafy.util.PageNavigation;

public interface NoticeService {
	public List<NoticeDTO> listnotice(Map<String, Object> map) throws SQLException;
	
	PageNavigation makePageNavigation(Map<String, Object> map) throws Exception;

	public NoticeDTO noticedetail(String no);
}
