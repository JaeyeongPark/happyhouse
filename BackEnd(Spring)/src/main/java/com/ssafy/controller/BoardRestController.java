package com.ssafy.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.BoardCommentDTO;
import com.ssafy.dto.BoardDTO;
import com.ssafy.dto.BoardCategoriSearchDTO;
import com.ssafy.dto.listParameterDTO;
import com.ssafy.service.BoardService;
import com.ssafy.util.PageNavigation;

@RestController
@CrossOrigin("*")
@RequestMapping("/board")
public class BoardRestController {
	
	//public static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private BoardService boardser;
	
	@GetMapping
	public ResponseEntity<Map<String,Object>> boardlist(@ModelAttribute listParameterDTO lidto, @ModelAttribute BoardCategoriSearchDTO cadto){
		//logger.debug("boardlist 호출");
		try {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listParameterDTO", lidto);
		map.put("BoardCategoriSearchDTO", cadto);
		List<BoardDTO> bdto = boardser.listboard(map);
		PageNavigation navigation = boardser.makePageNavigation(map);
		
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String, Object> map1 = new HashMap();
		map1.put("BoardDTO", bdto);
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
	public ResponseEntity<Map<String,Object>> boarddetail(@PathVariable String no){
		
		//logger.debug("boarddetail 호출");
		try {
//		boardser.countSerach(no);
		
	    BoardDTO boarddetail = boardser.boarddetail(no);
	    List<BoardCommentDTO> boardcomment = boardser.boardcomment(no);
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("boarddetail",boarddetail);
	    map.put("boardcomment",boardcomment);
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
	
	@PostMapping
	@Transactional
	public ResponseEntity<String> regboard(@RequestBody BoardDTO boardDTO) {
		
		
//		for (int i = 0; i < 50; i++) {
//			String sub = "여기짱"+i;
//			String con = "진짜좋습니다"+i;
//			boardDTO.setSubject(sub);
//			boardDTO.setContent(con);
//			boardser.insertboard(boardDTO);
//		}
//		
//		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		
		//	logger.debug("regboard 호출");
		try {
			
			
			if(boardser.insertboard(boardDTO)==1) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}else {
				return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
			}
			
		} catch (SQLException e) {
			//	logger.error("게시판등록 실패 : {}", e);
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
		
	}
	@PostMapping("/comment")
    @Transactional
    public ResponseEntity<String> regcomment(@RequestBody BoardCommentDTO commentDTO){
        System.out.println(commentDTO);
        //    logger.debug("regboard 호출");
        try {
        	if(boardser.registcomment(commentDTO)==1) {
                return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
            }else {
                return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
            }
        }catch (Exception e) {
        	return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
        
    }


    @DeleteMapping("/comment/{commentno}")
    @Transactional
    public ResponseEntity<String> deletecomment(@PathVariable("commentno") String commentno){

        //logger.debug("deleteboard 호출");
        System.out.println("들오옴:"+commentno);
		try {
			if(boardser.deletecomment(commentno) == 1) {
	            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	        }else {
	            return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	        }
		} catch (Exception e) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}

        
    }
	
	
	@PutMapping("/{no}")
	@Transactional
	public ResponseEntity<String> updateboard(@PathVariable("no") String no, @RequestBody BoardDTO bdto){

		//logger.debug("updateboard 호출");
		try {
			if(boardser.updateboard(bdto) == 1) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}else {
				return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
			}
		} catch (SQLException e) {
			//	logger.error("게시판수정 실패 : {}", e);
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/{no}")
	@Transactional
	public ResponseEntity<String> deleteboard(@PathVariable("no") String no){
		
		//logger.debug("deleteboard 호출");
		System.out.println("들오옴:"+no);
		BoardDTO bdto = new BoardDTO();
		bdto.setBoardno(no);
		
		try {
			if(boardser.deleteboard(bdto) == 1) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}else {
				return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
			}
		} catch (SQLException e) {
			//	logger.error("게시판삭제 실패 : {}", e);
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/comment")
    @Transactional
    public ResponseEntity<String> updatecomment(@RequestBody BoardCommentDTO commentDTO){

        //logger.debug("updateboard 호출");
        try {
            if(boardser.updatecomment(commentDTO) == 1) {
                return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
            }else {
                return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
            }
        } catch (SQLException e) {
            return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
        }
    }
}
