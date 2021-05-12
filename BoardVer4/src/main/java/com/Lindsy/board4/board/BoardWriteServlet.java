package com.Lindsy.board4.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Lindsy.board4.BoardDAO;
import com.Lindsy.board4.MyUtils;
import com.Lindsy.board4.user.UserVO;

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");

		if (loginUser == null) {
			response.sendRedirect("/user/login"); 
		}
		MyUtils.openJSP("board/write", request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//제목, 내용, 글쓴이 pk값을 boardVO객체에 담아주세요
		
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		
		BoardVO vo = new BoardVO();
		
		int iuser = loginUser.getIuser();
		String title = request.getParameter("title"); //jsp에서 name에 있는 이름을 들고오는것
		String ctnt = request.getParameter("ctnt");
		
		vo.setIuser(iuser);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		BoardDAO.insBoard(vo);
		
		response.sendRedirect("list");
		
		
		
		
		
		
		
		
	}

}
