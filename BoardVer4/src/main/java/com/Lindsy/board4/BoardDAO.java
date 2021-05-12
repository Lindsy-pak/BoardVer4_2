package com.Lindsy.board4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Lindsy.board4.board.BoardVO;

public class BoardDAO {
	public static int insBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_board (title, ctnt, iuser) VALUES (?, ?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIuser());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.iboard, A.title, A.regdt, B.unm "
				+ " FROM t_board A LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " ORDER BY A.iboard DESC";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO vo  = new BoardVO();
				
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	
	public static BoardVO selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data  = null;
		
		String sql = "SELECT A.title, A.regdt, A.ctnt, B.iuser, B.unm"
				+ " FROM t_board A LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser"
				+ " WHERE iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard); //물음표에 iboard가 들어간다
			rs = ps.executeQuery();
			
			if(rs.next()) {
				data = new BoardVO();
				
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				int iuser = rs.getInt("iuser");
				
				data.setIboard(iboard);
				data.setTitle(title);
				data.setCtnt(ctnt);
				data.setRegdt(regdt);
				data.setUnm(unm);
				data.setIuser(iuser);
			}	
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return data; //에러터지든 안터지든 data를 보냄
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static int delBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "DELETE FROM t_board"
				+ " WHERE iboard = ? AND iuser = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0;
	}
	
	public static int modBoard(BoardVO data) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "UPDATE t_board SET title = ?, ctnt = ?"
				+ " WHERE iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, data.getTitle());
			ps.setString(2, data.getCtnt());
			ps.setInt(3, data.getIboard());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0;
	}
	
	
	
	
	
}
