package com.ssafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.BoardCategoriSearchDTO;
import com.ssafy.dto.BoardCommentDTO;
import com.ssafy.dto.BoardDTO;
import com.ssafy.dto.NoticeDTO;
import com.ssafy.dto.listParameterDTO;
import com.ssafy.service.BoardService;
import com.ssafy.service.NoticeService;
import com.ssafy.util.PageNavigation;

@RestController
@CrossOrigin("*")
@RequestMapping("/notice")
public class NoticeRestController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private NoticeService noticeser;
	
	
	@GetMapping
	public ResponseEntity<Map<String,Object>> noticelist(@ModelAttribute listParameterDTO lidto){
		System.out.println("들어오나?");
		//logger.debug("boardlist 호출");
		try {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listParameterDTO", lidto);
		
		List<NoticeDTO> ndto = noticeser.listnotice(map);
		PageNavigation navigation = noticeser.makePageNavigation(map);
		
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String, Object> map1 = new HashMap();
		map1.put("NoticeDTO", ndto);
		map1.put("PageNavigation", navigation);
		map1.put("listParameterDTO", lidto);
		
		resEntity = new ResponseEntity<Map<String,Object>>(map1,HttpStatus.OK);
		
	    return resEntity;
		}catch (Exception e) {
			//	logger.error("게시판리스트 실패 : {}", e);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("msg", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<Map<String,Object>> noticedetail(@PathVariable String no){
		System.out.println("noticedetail들어오냐");
		//logger.debug("boarddetail 호출");
		try {
//		boardser.countSerach(no);
		
	    NoticeDTO noticedetail = noticeser.noticedetail(no);
	   
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("noticedetail",noticedetail);
	   
	    ResponseEntity<Map<String,Object>> resEntity = null;
	    resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	    
	    return resEntity;
		}catch (Exception e) {
			//		logger.error("게시판디테일 실패 : {}", e);
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("msg", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(map1,HttpStatus.NO_CONTENT);
		}
	}

}
