package com.ssafy.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.BoardDTO;
import com.ssafy.dto.listParameterDTO;
import com.ssafy.service.BoardService;
import com.ssafy.util.PageNavigation;

@RestController
@CrossOrigin("*")
public class BoardRestController {
	
	@Autowired
	private BoardService boardser;
	
	@GetMapping
	public ResponseEntity<Map<String,Object>> boardlist(@ModelAttribute listParameterDTO lidto) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listParameterDTO", lidto);
		
		List<BoardDTO> bdto = boardser.listboard(map);
		PageNavigation navigation = boardser.makePageNavigation(map);
		
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String, Object> map1 = new HashMap();
		map1.put("BoardDTO", bdto);
		map1.put("PageNavigation", navigation);
		map1.put("listParameterDTO", lidto);
//		List<BoardDTO> list = boardser.listboard();
//	    Map<String, Object> map = new HashMap<String, Object>();
//	    map.put("boardlist", list);
		resEntity = new ResponseEntity<Map<String,Object>>(map1,HttpStatus.OK);
	    return resEntity;
	}
	
	
	@GetMapping("/mostsearch")
    public Map<String, Object> mainsort() throws Exception {

        List<BoardDTO> list = boardser.listwholeboard();

        Comparator<BoardDTO> com = new Comparator<BoardDTO>() {
            @Override
            public int compare(BoardDTO o1, BoardDTO o2) {

                return Integer.parseInt(o2.getSearch()) - Integer.parseInt(o1.getSearch());
            }
        };

        Collections.sort(list, com);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardlist", list);

        return map;
    }

	@GetMapping("/{no}")
	public Map<String, Object> boardinfo(@PathVariable String no) throws SQLException {
		boardser.countSerach(no);
		
	    BoardDTO boardDTO = boardser.listondeboard(no);
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("info",boardDTO);
	    
	    return map;
	}
	
	@PostMapping
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
	
	@PutMapping("/{no}")
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

	@DeleteMapping("/{no}")
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
