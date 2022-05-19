package com.ssafy.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.AddressDTO;
import com.ssafy.dto.AptDTO;
import com.ssafy.dto.StationDTO;
import com.ssafy.dto.listParameterDTO;
import com.ssafy.service.AptService;
import com.ssafy.util.PageNavigation;

@RestController
@CrossOrigin("*")
public class AptRestController {
	@Autowired
	AptService aptser;
	
	@GetMapping("/apt")
	public ResponseEntity<?> searchlist(@ModelAttribute AddressDTO addto, 
			@ModelAttribute listParameterDTO lidto) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		//System.out.println(addto);
		//System.out.println(lidto);
		map.put("AddressDTO", addto);
		map.put("listParameterDTO", lidto);
		
		Map<String, Object> aptmap = aptser.aptlist(map);
		List<AptDTO> Aptdto = (List<AptDTO>)aptmap.get("aptlist");
		List<StationDTO> sdto = (List<StationDTO>)aptmap.get("nearstationlist");
		
		PageNavigation navigation = aptser.makePageNavigation(map);
		
		//System.out.println(lidto);
		
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String, Object> map1 = new HashMap();
		map1.put("AptDTO", Aptdto);
		map1.put("stationDTO", sdto);
		map1.put("PageNavigation", navigation);
		map1.put("searchaddress", addto.getSidoName()+" "+addto.getGugunName()+" "+addto.getDongName());
		map1.put("AddressDTO", addto);
		map1.put("listParameterDTO", lidto);
		resEntity = new ResponseEntity<Map<String,Object>>(map1,HttpStatus.OK);
		
		return resEntity;
	}

}