package com.befiring.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.befiring.bean.User;

public class DBHelper {

//	public static Connection conn = Dao.getConnection();
//	public static PreparedStatement pstmt = null;
//
//	public static void insert(User user) {
//		// TODO Auto-generated method stub
//		String sql = "INSERT INTO user(name,age)" + "VALUES(?,?)";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, user.getName());
//			pstmt.setInt(2, user.getAge());
////			pstmt.setInt(3, user.getSex());
//			pstmt.executeUpdate();
//			pstmt.close();
//			conn.close();
//			System.out.println("insert success");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("insert failed");
//		}
//	}
}
