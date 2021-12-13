package service;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sha256 {
	static Connection con;			
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	public static void getConnection() throws ClassNotFoundException, SQLException{
		
		con = null;
		pstmt = null;
		rs = null;
		
		if(con == null) {
			
			String url = "jdbc:mysql://localhost:3306/aaaa?useSSL=false"; 
			String dbUser = "root";
			String dbPassword = "rootroot";
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, dbUser, dbPassword);
		}
	}

		public static String insertSHA256(String id, String userpwd) {
			String sql = "insert into sha256 values (?, ?)";
			
			try {
				getConnection();

				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(userpwd.getBytes("UTF-8"));
				StringBuffer hexString = new StringBuffer();
				
				for(int i = 0; i < hash.length; i++) {
					String hex = Integer.toHexString(0xff & hash[i]);
					if(hex.length() == 1) hexString.append("0");
					hexString.append(hex);
				}

				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, id);
				pstmt.setString(2, hexString.toString());
				
				pstmt.executeUpdate();

			}catch(Exception e) {
				throw new RuntimeException(e);
			}
			return null;

		}
		
		public static String testSHA256(String id, String userpwd) {
			String dbpwd = null;
			
			String sql = "select id, pwd from sha256 where id = ? and pwd = ?";
			
			try {
				getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, userpwd);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {

					rs.getString("id");
				dbpwd = rs.getString("pwd");
				
				System.out.println(dbpwd);
				
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
			return dbpwd;
			
		}	

}
