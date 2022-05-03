package com.ssafy.controller;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.dto.BoardDTO;
import com.ssafy.dto.UserDTO;
import com.ssafy.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

@Autowired
private BoardService boardser;


@GetMapping("/listboardform")
public String listboardform(@RequestParam Map<String, String> map) throws SQLException {
    return "board/listboard";
}

@GetMapping("/boardlist")
@ResponseBody
public Map<String, Object> boardlist() throws SQLException {
	List<BoardDTO> list = boardser.listboard();
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("boardlist", list);
    
    return map;
}

@GetMapping("/boardlist/{no}")
@ResponseBody
public Map<String, Object> boardinfo(@PathVariable String no) throws SQLException {
    BoardDTO boardDTO = boardser.listondeboard(no);
    System.out.println(boardDTO);
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("info",boardDTO);
    
    return map;
}

@GetMapping("/registboardform")
public String registboardform() {
    return "board/registboard";
}

@PostMapping("/boardlist")
@ResponseBody
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


@GetMapping("/updateboardform")
public ModelAndView updateboardform(@RequestParam("no") String no,
		@RequestParam("id") String id) throws SQLException {
	ModelAndView mav = new ModelAndView();
	mav.addObject("no",no);
	mav.setViewName("board/updateboard");
	return mav;
		
	
	
}

@PutMapping("/boardlist/{no}")
@ResponseBody
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

@DeleteMapping("/boardlist/{no}")
@ResponseBody
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