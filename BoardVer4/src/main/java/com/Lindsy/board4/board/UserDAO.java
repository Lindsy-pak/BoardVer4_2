package com.Lindsy.board4.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.Lindsy.board4.DBUtils;
import com.Lindsy.board4.user.UserVO;

public class UserDAO {
	public static int joinUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_user (uid, upw, unm, gender) VALUES(?, ?, ?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender()); 
//			get했다는 것은 set으로 이미 값을 넣어주었기 때문 사용가능함 (joinServlet에서 set을 해준것)
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	//로그인 성공: 1, 아이디 없음 : 2, 비밀번호틀림 : 3, 에러: 0
	public static int loginUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "Select * from t_user WHERE uid = ?";
		/* SELECT * FROM t_user WHERE uid = 'jimin' AND upw = 'terry';
		   query문에서 이렇게 and를 사용하면 뭐가 틀린지 모름 = 분기를 할 수 없음 */
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			
			rs = ps.executeQuery();
			 
			if(rs.next()) {
				//아이디가 있는경우 & 비밀번호 체크 
				String dbpw = rs.getString("upw"); //데이터베이스 번호와 받은 비밀번호가 맞는지 확인
				//if( dbpw.equals(param.getUpw()))
				
				if(BCrypt.checkpw(param.getUpw(), dbpw)) {
					int iuser = rs.getInt("iuser");//list안에서 iuser와 unm값을 받아오기 위해서 
					String unm = rs.getString("unm");
					
					param.setIuser(iuser);
					param.setUnm(unm);
					
					return 1;
				} else {
					return 3;
				}
			} else {
				//아이디가 없는경우 
				return 2; 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0; //캐치에 있으면 밑에 리턴 안해도 됌 
		} finally {
			DBUtils.close(con, ps, rs);
		}
		//return 0;
	}
}
