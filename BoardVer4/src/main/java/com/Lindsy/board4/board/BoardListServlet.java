package com.Lindsy.board4.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lindsy.board4.BoardDAO;
import com.Lindsy.board4.MyUtils;
import com.Lindsy.board4.user.UserVO;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession(); //로그인한 유저의 정보를 가져옴
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");

		// 로그인 안되어 있으면 로그인화면으로 이동
		if (loginUser == null) {
			response.sendRedirect("/user/login"); // user안넣으면 board/login이 된다. 주의하기
			return;
		}
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = BoardDAO.selBoardList();
		request.setAttribute("list", list);

		// 로그인 했으면 board.list.jsp파일 응답
		MyUtils.openJSP("board/list", request, response); // else부분

//		HttpSession hs = request.getSession();
//		
//		Boolean loginSuccess = (Boolean)hs.getAttribute("loginSuccess");
//		System.out.println("loginSuccess : " + loginSuccess);
//		if(loginSuccess == null || loginSuccess == false) {
//			response.sendRedirect("/user/login");
//			return;
//		}
		
		//list에 게시판 목록 뿌리기 
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
