package com.ssafy.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.ssafy.dto.UserDTO;
import com.ssafy.service.BoardService;
import com.ssafy.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userser;
	
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, HttpSession session) throws SQLException {
		UserDTO udto = userser.login(map);
		//System.out.println(udto);
		
		if(udto == null) {
			return "redirect:/";
		}else {
			session.setAttribute("userInfo", udto);
			return "redirect:/";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	@PostMapping("/")
	@ResponseBody
	public Map<String, Object> register(@RequestBody UserDTO udto) throws SQLException {
		int flag = userser.insertUser(udto);
		Map<String, Object> map = new HashMap<String, Object>();
		if(flag == 0) {
			map.put("flag", flag);
		}else {
			map.put("flag", flag);
		}
		return map;
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public Map<String, Object> update(@PathVariable("id") String id, @RequestBody UserDTO udto) throws SQLException {
		int flag = userser.updateUser(udto);
		Map<String, Object> map = new HashMap<String, Object>();
		if(flag == 0) {
			map.put("flag", flag);
		}else {
			map.put("flag", flag);
		}
		return map;
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public Map<String, Object> del(@PathVariable("id") String id) throws SQLException {
		int flag = userser.deletetUser(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if(flag == 0) {
			map.put("flag", flag);
		}else {
			map.put("flag", flag);
		}
		return map;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Map<String, Object> searchpw(@PathVariable String id) throws SQLException {
		String pw = userser.searchpw(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if(pw!=null) {
			map.put("flag", 1);
			map.put("pw", pw);
		}else {
			map.put("flag", 0);
		}
		
		return map;
	}
}
