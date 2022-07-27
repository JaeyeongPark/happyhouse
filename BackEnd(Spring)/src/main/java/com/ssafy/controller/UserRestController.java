package com.ssafy.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.UserDTO;
import com.ssafy.dto.UserInterestDTO;
import com.ssafy.service.JwtServiceImpl;
import com.ssafy.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserRestController {
	
	//public static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@Autowired
	UserService userser;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String,Object>> login(@RequestBody UserDTO udto){
		
		//	logger.debug("login 호출");
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpStatus status = null;
		
		try {
			UserDTO loginuser = userser.login(udto);
			if(loginuser != null) {
				String token = jwtService.create("id", loginuser.getId(), "access-token");
				//		logger.debug("로그인 토큰정보 : {}", token);
				map.put("access-token", token);
				map.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}else {
				map.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		}catch (Exception e) {
			//logger.error("로그인 실패 : {}", e);
			map.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(map, status);
	}
	
	
	@GetMapping("/info/{id}")
	public ResponseEntity<Map<String, Object>> userinfo(@PathVariable String id, HttpServletRequest request) throws SQLException {
		
		//logger.debug("userinfo 호출");
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
		
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			//	logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				UserDTO userDto = userser.userinfo(id);
				map.put("userInfo", userDto);
				map.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				//	logger.error("정보조회 실패 : {}", e);
				map.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			//	logger.error("사용 불가능 토큰!!!");
			map.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		
		return new ResponseEntity<Map<String, Object>>(map, status);
	}
	
	@PostMapping("/interest")
	@Transactional
	public ResponseEntity<Map<String, Object>> userinterregist(@RequestBody UserInterestDTO uidto){
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
		try {
			System.out.println(uidto);
			int userinterregist = userser.userinterregist(uidto);
			if(userinterregist==1) {
				map.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}else {
				map.put("message", FAIL);
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} catch (Exception e) {
			map.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		
		
		return new ResponseEntity<Map<String, Object>>(map, status);
	}
	
	@PostMapping("/interestconfirm")
	@Transactional
	public ResponseEntity<Map<String, Object>> userinterconfirm(@RequestBody UserInterestDTO uidto){
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
		try {
			UserInterestDTO userinterconfirm = userser.userinterconfirm(uidto);
		
			if(userinterconfirm != null) {
				map.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}else {
				map.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			map.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		
		
		return new ResponseEntity<Map<String, Object>>(map, status);
	}
	
	@DeleteMapping("/interest")
	@Transactional
	public ResponseEntity<Map<String, Object>> userinterdelete(@ModelAttribute UserInterestDTO uidto){
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
		try {
			System.out.println("히얼?");
			System.out.println(uidto);
			int userinterdelete = userser.userinterdelete(uidto);
			if(userinterdelete==1) {
				map.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}else {
				map.put("message", FAIL);
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} catch (Exception e) {
			map.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		
		
		return new ResponseEntity<Map<String, Object>>(map, status);
	}
	
	@GetMapping("/interest/{id}")
	public ResponseEntity<Map<String, Object>> userinterlist(@PathVariable("id") String id){
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
		try {
			System.out.println(id);
			List<UserInterestDTO> userinterdelist = userser.userinterdelist(id);
			
			map.put("userinterdelist", userinterdelist);
			status = HttpStatus.ACCEPTED;
			
		} catch (Exception e) {
			map.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		
		
		return new ResponseEntity<Map<String, Object>>(map, status);
	}
//	@GetMapping("/interest/{id}")
//	public Map<String, Object> userinterest(@PathVariable String id) throws SQLException {
//		List<UserInterestDTO> userinterestlist = userser.userinterestlist(id);
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("userinterestlist", userinterestlist);
//		
//		return map;
//	}
//	
//	
	@GetMapping("/{id}/{pn}")
	public Map<String, Object> searchpw(@PathVariable("id") String id,@PathVariable("pn") String pn) throws SQLException {
		UserDTO udto = userser.userinfo(id);
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(udto.getPhonenumber().equals(pn)) {
			map.put("password", udto.getPassword());
		}else {
			map.put("password", "0");
		}
		
		return map;
		
		//udto에 id 토대로 유저정보 가져오고 유저정보의 전화번호와 파라미터 전화번호가 같으면 password 반환 아니면 password를 0으로 반환
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Map<String, Object>> register(@RequestBody UserDTO udto) throws SQLException {
		int insertUser = userser.insertUser(udto);
		Map<String, Object> map = new HashMap<String, Object>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
		if(insertUser == 1) {
			map.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		}else {
			map.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(map, status);
		
		
		//파라미터로 들어온 유저정보를 등록하고 결과를 flag에 반환
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Map<String, Object> update(@PathVariable("id") String id, @RequestBody UserDTO udto) throws SQLException {
		System.out.println(id+"여기옴??"+udto);
		int flag = userser.updateUser(udto);
		Map<String, Object> map = new HashMap<String, Object>();
		if(flag == 0) {
			map.put("flag", flag);
		}else {
			map.put("userInfo", udto);
			map.put("flag", flag);
		}
		return map;
		
		//파라미터로 받은 유저정보를 토대로 기존의 유저정보를 수정하고 flag반환
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public Map<String, Object> del(@PathVariable("id") String id) throws SQLException {
		int flag = userser.deletetUser(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if(flag == 0) {
			map.put("flag", flag);
		}else {
			map.put("flag", flag);
		}
		return map;
		
		//id를 토대로 유저를 삭제하고 flag 반환
	}
	
}
