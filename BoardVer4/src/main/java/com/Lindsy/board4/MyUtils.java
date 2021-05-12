package com.Lindsy.board4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lindsy.board4.user.UserVO;

public class MyUtils {
	public static void openJSP(String fileNm, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/view/" + fileNm + ".jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	
	public static int parseStringToInt(String val) {
		try {
			int result = Integer.parseInt(val);
			return result;
		} catch(Exception e) {
			return 0;
		}
	}
	
	public static int getParamInt(String key, HttpServletRequest request) {
		String val = request.getParameter(key);
		int intVal = parseStringToInt(val);
		return intVal;
	}
	
	public static UserVO getLoginUser(HttpServletRequest request) {
		//로그인한 유저의 정보를 가져온다 
		if(request == null) { return null; } //예외처리 
		HttpSession hs = request.getSession();
		return (UserVO) hs.getAttribute("loginUser");
	}
	public static int getLoginUserPk(HttpServletRequest request) {
		//로그인한 유저의 pK:iuser의 값을 가져온다
		if(request == null) { return 0; }
		return getLoginUser(request).getIuser(); //중복된 소스는 쓰지 않는다. 
	}
}
