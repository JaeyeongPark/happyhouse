package com.ssafy.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.AddressDTO;
import com.ssafy.dto.AptDTO;
import com.ssafy.dto.listParameterDTO;
import com.ssafy.service.AptService;
import com.ssafy.util.PageNavigation;

@RestController
@CrossOrigin("*")
public class AptRestController {
	//public static final Logger logger = LoggerFactory.getLogger(AptRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	AptService aptser;
	
	@GetMapping("/apt")
	public ResponseEntity<?> searchlist(@ModelAttribute AddressDTO addto, 
			@ModelAttribute listParameterDTO lidto, @RequestParam("dealYear")String dealYear) throws Exception{
		//	logger.debug("aptlist 호출");
		Map<String, Object> map = new HashMap<String, Object>();
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String, Object> map1 = new HashMap();
		
		try {
		map.put("AddressDTO", addto);
		map.put("listParameterDTO", lidto);
		map.put("dealYear", dealYear);
		System.out.println("1 : "+map);
		Map<String, Object> aptmap = aptser.aptlist(map);
		List<AptDTO> Aptdto = (List<AptDTO>)aptmap.get("aptlist");
		System.out.println("2 : "+map);
		PageNavigation navigation = aptser.makePageNavigation(map);
		
		map1.put("AptDTO", Aptdto);
		map1.put("PageNavigation", navigation);
		map1.put("AddressDTO", addto);
		map1.put("listParameterDTO", lidto);
		return new ResponseEntity<Map<String,Object>>(map1,HttpStatus.OK);
		}catch (Exception e) {
			//	logger.error("아파트리스트 실패 : {}", e);
			map1.put("msg", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(map1,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/apt/detail")
	public ResponseEntity<?> searchlist(@ModelAttribute AptDTO adto) throws Exception{
		//	logger.debug("aptlist 호출");
		Map<String, Object> map = new HashMap<String, Object>();
		ResponseEntity<Map<String,Object>> resEntity = null;
		
		try {
//			System.out.println(adto);
		map.put("adto", adto);
		
		AptDTO aptdetail = aptser.aptdetail(map);
		System.out.println(aptdetail);
		map.clear();
		map.put("aptdetail", aptdetail);
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch (Exception e) {
			//	logger.error("아파트리스트 실패 : {}", e);
			map.put("msg", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NO_CONTENT);
		}
	}
}
