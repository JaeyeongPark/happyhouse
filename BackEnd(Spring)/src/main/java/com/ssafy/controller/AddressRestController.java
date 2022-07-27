package com.ssafy.controller;

import java.sql.SQLException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.AddressDTO;
import com.ssafy.service.AddressService;

@RestController
@CrossOrigin("*")
public class AddressRestController {
	
//	public static final Logger logger = LoggerFactory.getLogger(AddressRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private AddressService adser;
	
	@GetMapping("/address/{type}")
	public ResponseEntity<?> sidolist(@PathVariable("type") String type, 
			@RequestParam("sidoName") String sidoName, 
			@RequestParam("gugunName") String gugunName, 
			@RequestParam("dongName") String dongName,
			@RequestParam("dongcode") String dongcode1,
			@RequestParam("category") String category
			) {
		//	logger.debug("addresslist 호출");
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String, Object> map = new HashMap();
		try {
		if(type.equals("sido")) {
			List<AddressDTO> sidolist = adser.listsido();
			map.put("sidolist", sidolist);
		}
		else if(type.equals("gugun")) {
			List<AddressDTO> gugunlist = adser.listgugun(sidoName);
			map.put("gugunlist", gugunlist);
		}
		else if(type.equals("dong")) {
			List<AddressDTO> donglist = adser.listdong(sidoName, gugunName);
			//System.out.println(donglist);
			map.put("donglist", donglist);
		}
		else if(type.equals("dongcode")) {
			AddressDTO dongcode = adser.getdongcode(sidoName, gugunName, dongName);
		
			map.put("dongcode", dongcode);
		}
		else if(type.equals("categoryvalue")) {
		 List<String> categoryvaluelist = adser.getcategoryvalue(dongcode1, category);
		 map.put("categoryvaluelist", categoryvaluelist);
		 
		}
		else if(type.equals("alladdress")) {
			System.out.println("123");
            AddressDTO allAddress = adser.getAllAddress(dongcode1);
            System.out.println(allAddress);
            map.put("allAddress",allAddress);
        }
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch (Exception e) {
			//	logger.error("주소리스트 실패 : {}", e);
			map.put("msg", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NO_CONTENT);
		}
	}
	
	
}
