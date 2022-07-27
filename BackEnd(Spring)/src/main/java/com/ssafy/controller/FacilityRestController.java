package com.ssafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.AddressDTO;
import com.ssafy.dto.AptDTO;
import com.ssafy.dto.FacilityCategorySearchDTO;
import com.ssafy.dto.listParameterDTO;
import com.ssafy.service.FacilityService;
import com.ssafy.util.PageNavigation;

@RestController
@CrossOrigin("*")
@RequestMapping("/facility")
public class FacilityRestController {
	
	//public static final Logger logger = LoggerFactory.getLogger(FacilityRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private FacilityService fser;
	
	@GetMapping
	public ResponseEntity<?> searchlist(@ModelAttribute FacilityCategorySearchDTO fcdto,
			@ModelAttribute listParameterDTO lidto){
		System.out.println(fcdto);
		//	logger.debug("facilitylist 호출");
		Map<String, Object> map = new HashMap<String, Object>();
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String, Object> map1 = new HashMap();
		
		try {
		map.put("listParameterDTO", lidto);
		map.put("FacilityCategorySearchDTO", fcdto);
		
		List<?> facilitylist = fser.facilitylist(map);
		PageNavigation navigation = fser.makePageNavigation(map);
		
		map1.put("facilitylist", facilitylist);
		map1.put("PageNavigation", navigation);
		map1.put("AddressDTO", fcdto);
		map1.put("listParameterDTO", lidto);
		return new ResponseEntity<Map<String,Object>>(map1,HttpStatus.OK);
		}catch (Exception e) {
			//		logger.error("시설리스트 실패 : {}", e);
			map1.put("msg", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(map1,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/detail")
	public ResponseEntity<?> facilitydetail(@RequestParam("category")String category, 
			@RequestParam("code")String code){
		System.out.println(category);
		System.out.println(code);
		Map<String, Object> map = new HashMap<String, Object>();
		ResponseEntity<Map<String,Object>> resEntity = null;
		
		try {
			List<?> facilitydetail = fser.facilitydetail(category, code);
			System.out.println(facilitydetail);
			map.put("facilitydetail", facilitydetail);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
		}catch (Exception e) {
			//		logger.error("시설리스트 실패 : {}", e);
			map.put("msg", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NO_CONTENT);
		}
		
	}
}
