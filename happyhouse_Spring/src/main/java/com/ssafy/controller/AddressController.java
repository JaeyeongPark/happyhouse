package com.ssafy.controller;

import java.sql.SQLException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.AddressDTO;
import com.ssafy.service.AddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin("*")
public class AddressController {
	@Autowired
	private AddressService adser;
	
	@GetMapping("/{type}")
	public ResponseEntity<?> sidolist(@PathVariable("type") String type, 
			@RequestParam("sidoName") String sidoName, @RequestParam("gugunName") String gugunName) throws SQLException{
		
		//System.out.println("여기들어왔다~~");
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String, Object> map = new HashMap();
		
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
		
		resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		return resEntity;
	}
}
