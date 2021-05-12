package com.Lindsy.board4.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lindsy.board4.MyUtils;
import com.Lindsy.board4.board.UserDAO;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		
		//로그인이 되어있는 상태 >로그인 페이지로 가면 >board/list페이지로 이동시키기
		if(loginUser != null) {
			response.sendRedirect("/board/list");
			return;
		} //둘중에 하나만 실행 되도록 해야한다. 
		MyUtils.openJSP("user/login", request, response);
	}
	
	// 로그인처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");

		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(upw);

		
		int result = UserDAO.loginUser(vo); //db와 확인하기 위해서

		if(result ==1) { //로그인 성공
			HttpSession hs = request.getSession();
			vo.setUpw(null);
			hs.setAttribute("loginUser", vo);
			//vo가 가리키는 UserVO객체는 (iuser, uid, unm 값만 담고있다)
			
//			hs.setAttribute("loginSuccess", true);
			//브라우저를 끄지 않는 이상 정보를 들고 있다. 
			response.sendRedirect("/board/list");
			return;
		}
		String errMsg = null;
		switch (result) {
		case 0:
			errMsg = "에러가 발생하였습니다.";
			break;
		case 2:
			errMsg = "아이디를 확인해주세요.";
			break;
		case 3:
			errMsg = "비밀번호를 확인해주세요.";
			break;
		}
		request.setAttribute("errMsg", errMsg);
		doGet(request, response); // 바로 위의 메소드를 실행한거
		// response.sendRedirect("login?err=" + result); 이렇게 하면 값전달은 무조건 쿼리스트링으로
	}
}
//doGet의 request와 doPost의 request가 다르다.
