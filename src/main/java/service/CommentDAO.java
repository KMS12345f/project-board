package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CommentDTO;

public class CommentDAO {
	Connection con;			
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void getConnection() throws ClassNotFoundException, SQLException{
		
		con = null;
		pstmt = null;
		rs = null;
		
		if(con == null) {
			
			String url = "jdbc:mysql://localhost:3306/freeBoard?useSSL=false"; 
			String dbUser = "root";
			String dbPassword = "rootroot";
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, dbUser, dbPassword);
		}
	}

	public List<CommentDTO> commentList(int fnum) {
		List<CommentDTO> list = new ArrayList<CommentDTO>();
	
		try {
			getConnection();
	
			String sql = "select * from comment where fnum =? order by cnum desc";
		
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setInt(1, fnum);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				CommentDTO dto = new CommentDTO();
				
				dto.setCnum(rs.getInt("cnum"));
				dto.setFnum(rs.getInt("fnum"));
				dto.setComment(rs.getString("comment"));
				dto.setWriter(rs.getString("writer"));
				dto.setRegDate3(rs.getDate("regDate3"));
				
				list.add(dto);
				
			}
	
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void commentInsert(String fnum, String comtext, String comwriter) {
		try {
			getConnection();
			
			
			String sql = "insert into comment(fnum, comment, writer) values "
					+ "(?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, fnum);
			pstmt.setString(2, comtext);
			pstmt.setString(3, comwriter);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
			
	}

	public void commentDelete(String cnum) {
		try {
			getConnection();
			
			
			String sql = "delete from comment where cnum = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, cnum);

			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
			
	}
	
}
