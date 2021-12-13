package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FreeBoardDTO;
import model.MemberDTO;

public class FreeBoardDAO {
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
	
	public void insertBoard(String title, String content, String writer) {
			
			String sql = "insert into freeBoard(title, content, writer, regDate2) values "
					+ "(?, ?, ?, now())";
	
			try {
				getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setString(3, writer);
				
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

	public List<FreeBoardDTO> selectAllFree(){
		
		List<FreeBoardDTO> List = new ArrayList<FreeBoardDTO>();
		
		String sql = "select * from freeBoard order by fnum desc";
		
		try {
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				FreeBoardDTO dto = new FreeBoardDTO();
			
				dto.setFnum(rs.getInt("fnum"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setViewCount(rs.getInt("viewcount"));
				dto.setRegDate2(rs.getDate("regDate2"));
			
				List.add(dto);

			}
			
			}catch(SQLException ex){
				System.out.println("select 실패");
			}finally{
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			return List;
		}

	public void deleteFree(String fNum) {
		System.out.println("==========1"+fNum);
		try {
			getConnection();
			
			String sql = "delete from freeboard where fnum = ?";
			System.out.println("==========2");
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, fNum);
		
			System.out.println("==========3");
			
			pstmt.executeUpdate();
	
		}catch(Exception e) {
			System.out.println("삭제 실패");
		}finally{
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<FreeBoardDTO> selectOneView(String fNum, int fCount) {
		List<FreeBoardDTO> List = new ArrayList<FreeBoardDTO>();
		
		String sql = "select * from freeBoard where fnum = ?";
		
		try {
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, fNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				FreeBoardDTO dto = new FreeBoardDTO();
			
				dto.setFnum(rs.getInt("fnum"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setViewCount(rs.getInt("viewcount"));
				dto.setRegDate2(rs.getDate("regDate2"));
			
				List.add(dto);

			}
			rs.close();
			pstmt.close();
			
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String sqln = "update freeBoard set viewCount = ?  where fnum = ?";
					
			pstmt = con.prepareStatement(sqln);
			
			pstmt.setInt(1, fCount);
			pstmt.setString(2, fNum);
			
			pstmt.executeUpdate();		
					
			
			}catch(SQLException ex){
				System.out.println("update 실패");
			}finally{
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			return List;
		}

	public List<FreeBoardDTO> selectOneList(String fNum) {
		
		List<FreeBoardDTO> List = new ArrayList<FreeBoardDTO>();
		
		String sql = "select * from freeBoard where fnum = ?";
		
		try {
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, fNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				FreeBoardDTO dto = new FreeBoardDTO();
			
				dto.setFnum(rs.getInt("fnum"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setViewCount(rs.getInt("viewcount"));
				dto.setRegDate2(rs.getDate("regDate2"));
			
				List.add(dto);

			}
		}catch(SQLException ex){
			System.out.println("update 실패");
		}finally{
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return List;
	}

	public String updateBoard(String num, String title, String content) {
		
		String sql = "update freeBoard set title = ?, content = ? "
				+ " where fnum = ?";
		
		try {
			getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, num);
			
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
	
		return num;
	}

	public List<FreeBoardDTO> search(String Search, String Value) {

		List<FreeBoardDTO> List = new ArrayList<FreeBoardDTO>();
		
		String sql = "select * from freeboard where " + Search + " like '%"+ Value +"%' order by fnum desc";
		
		try {
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
					
			while(rs.next())
			{
				FreeBoardDTO dto = new FreeBoardDTO();
			
				dto.setFnum(rs.getInt("fnum"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setViewCount(rs.getInt("viewcount"));
				dto.setRegDate2(rs.getDate("regDate2"));
			
				List.add(dto);

			}
			
			}catch(SQLException ex){
				System.out.println("select 실패");
			}finally{
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			return List;
		}
	
}
