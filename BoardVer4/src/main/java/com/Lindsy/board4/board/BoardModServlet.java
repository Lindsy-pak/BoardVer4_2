package com.Lindsy.board4.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lindsy.board4.BoardDAO;
import com.Lindsy.board4.MyUtils;

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO data = BoardDAO.selBoard(iboard);
		request.setAttribute("data", data);
		
		MyUtils.openJSP("board/mod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int iuser = MyUtils.getLoginUserPk(request);
		
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		vo.setIuser(iuser);
		vo.setTitle(title);
		vo.setCtnt(ctnt);

		BoardDAO.modBoard(vo);
		
		response.sendRedirect("detail?iboard=" +iboard);
	}

}
