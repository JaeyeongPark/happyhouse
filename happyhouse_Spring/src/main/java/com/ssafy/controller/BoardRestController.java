package com.ssafy.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.BoardDTO;
import com.ssafy.service.BoardService;

@RestController
@CrossOrigin("*")
public class BoardRestController {
	
	@Autowired
	private BoardService boardser;
	
	@GetMapping("/board")
	public Map<String, Object> boardlist() throws SQLException {
		List<BoardDTO> list = boardser.listboard();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("boardlist", list);
	    
	    return map;
	}

	@GetMapping("/board/{no}")
	public Map<String, Object> boardinfo(@PathVariable String no) throws SQLException {
	    BoardDTO boardDTO = boardser.listondeboard(no);
	    System.out.println(boardDTO);
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("info",boardDTO);
	    
	    return map;
	}
	
	@PostMapping("/board")
	@Transactional
	public Map<String, Object> regboard(@RequestBody BoardDTO boardDTO) throws SQLException {
		int flag = boardser.insertboard(boardDTO);
		Map<String, Object> map = new HashMap<String, Object>();
		if(flag == 0) {
			map.put("flag", flag);
		}else {
			map.put("flag", flag);
		}
		return map;
	}
	
	@PutMapping("/board/{no}")
	@Transactional
	public Map<String, Object> updateboard(@PathVariable("no") String no, @RequestBody BoardDTO bdto) throws SQLException {

		int flag = boardser.updateboard(bdto);
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(flag == 0) {
			map.put("flag", flag);
		}else {
			map.put("flag", flag);
		}
		return map;
	}

	@DeleteMapping("/board/{no}")
	@Transactional
	public Map<String, Object> deleteboard(@PathVariable("no") String no) throws SQLException {
		BoardDTO bdto = new BoardDTO();
		bdto.setNo(no);
		int flag = boardser.deleteboard(bdto);
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(flag == 0) {
			map.put("flag", flag);
		}else {
			map.put("flag", flag);
		}
		return map;
	}
}
