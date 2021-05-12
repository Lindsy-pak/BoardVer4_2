package com.Lindsy.board4.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Lindsy.board4.BoardDAO;
import com.Lindsy.board4.MyUtils;

@WebServlet("/board/del")
public class BoardDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request); //자기가 적은 글만 삭제하도록 함 
		
		BoardVO data = new BoardVO();
		data.setIboard(iboard);
		data.setIuser(iuser);

		BoardDAO.delBoard(data);
		
		response.sendRedirect("/board/list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
