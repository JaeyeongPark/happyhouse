package com.ssafy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.dto.UserDTO;

@Component
@SuppressWarnings("deprecation")
public class ConfirmInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		UserDTO udto = (UserDTO)session.getAttribute("userInfo");
		if(udto == null) {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		return true;
	}
}
