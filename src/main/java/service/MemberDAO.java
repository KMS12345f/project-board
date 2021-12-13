package service;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MemberDTO;

public class MemberDAO {
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

	public int idCheck(String uId) {
		
		String sql = "select * from member where id = ?";
		
		try {
			getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return 1;
			}else if(uId.equals("")) {
				return 2;
			}else {
				return 0;
			}
			
		}catch(Exception e) {
			System.out.println("아이디 비교 실패");
		}finally{
			try
			{
			rs.close();
			pstmt.close();
			con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return -1;
	
	}

	public void insertMember(String id, String pwd, String name, String phone, String birth, String email, String gender) {
		
		String sql = "insert into member(id, pwd, name, phone, birth, email, gender) values "
				+ "(?, ?, ?, ?, ?, ?, ?)";

		try {
			getConnection();

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, birth);			
			pstmt.setString(6, email);
			pstmt.setString(7, gender);
			
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

	public List<MemberDTO> selectAllMember() {

		List<MemberDTO> memList = new ArrayList<MemberDTO>();
		
			String sql = "select * from member";
			
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
					MemberDTO dto = new MemberDTO();
				
					dto.setId(rs.getString("id"));
					dto.setPwd(rs.getString("pwd"));
					dto.setName(rs.getString("name"));
					dto.setPhone(rs.getString("phone"));
					dto.setBirth(rs.getString("birth"));
					dto.setEmail(rs.getString("email"));
					dto.setGender(rs.getString("gender"));
					dto.setRegDate1(rs.getDate("regDate1"));
				
					memList.add(dto);
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
			return memList;
		}

	public void deletMember(String uId) {

		String sql = "delete from member where id = ? ";
		System.out.println(uId);
		try {
			getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, uId);
			
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

	public List<MemberDTO> selectOneMember(String uId) {
		
		List<MemberDTO> memList = new ArrayList<MemberDTO>();
		
		String sql = "select * from member where id = ?";
		try {
			
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, uId);

			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				MemberDTO dto = new MemberDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setRegDate1(rs.getDate("regDate1"));
			
				memList.add(dto);
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
		return memList;
	}

	public String updateMember(String uName, String uPhone, String uEmail, String uID) {
		String sql = "update member set name = ?, phone = ?, email = ?"
				+ " where id = ?";
		
		try {
			getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, uName);
			pstmt.setString(2, uPhone);
			pstmt.setString(3, uEmail);
			pstmt.setString(4, uID);			
			
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
		return uID;
	}

	public String loginCheck(String uId, String uPwd) {
		String name = null;
		
		String sql = "select id, pwd, name from member where id = ? and pwd = ?";
		try {
			getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uId);
			pstmt.setString(2, uPwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {

				rs.getString("id");
				rs.getString("pwd");
				name = rs.getString("name");
				
				return name;

			}else {
				return "";
			}
			
		}catch(Exception e) {
			System.out.println("아이디 비교 실패");
		}finally{
			try
			{
			rs.close();
			pstmt.close();
			con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;

	}
	
	public String loginId(String uId, String uPwd) {
		String id = null;
		
		String sql = "select id, pwd from member where id = ? and pwd = ?";
		
		try {
			getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uId);
			pstmt.setString(2, uPwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {

				id = rs.getString("id");
				rs.getString("pwd");

			}else {
				return "";
			}
		}catch(Exception e) {
			System.out.println("아이디 비교 실패");
		}finally{
			try
			{
			rs.close();
			pstmt.close();
			con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return id;

	}

	public List<MemberDTO> search(String name) {
		
		List<MemberDTO> memList = new ArrayList<MemberDTO>();
		
		String sql = "select * from member where name like ?";
		
		try {
			
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, '%'+name+'%');

			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				MemberDTO dto = new MemberDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setRegDate1(rs.getDate("regDate1"));
			
				memList.add(dto);

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
		return memList;
	}

}
