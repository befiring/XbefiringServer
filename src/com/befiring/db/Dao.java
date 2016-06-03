package com.befiring.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.befiring.bean.User;


public class Dao {

	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/xbefiring";
	public static final String DBUSER="root";
	public static final String DBPASS="";
	private static Connection conn = null;
	public static PreparedStatement pstmt = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(getConnection());

	}
	public Dao() {                                        //默认构造函数
        try {
            if (conn == null) {                            //如果连接对象为空
                Class.forName(DBDRIVER);                //加载驱动类
                conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);//获得连接对象
                System.out.println("conn created");
            }
        } catch (Exception ee) {
            ee.printStackTrace();
            System.out.println("conn not created");
        }
    }
	
	public static ResultSet executeQuery(String sql) {    //查询方法
        try {
            if(conn==null)  new Dao();  //如果连接对象为空，则重新调用构造方法
            return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(sql);//执行查询
        } catch (SQLException e) {
            e.printStackTrace();
            return null;                //返回null值
        } finally {
        }
    }
	
	public static int executeUpdate(User user) {        //更新方法
		 
		 String sql = "INSERT INTO user(name,age)" + "VALUES(?,?)";
	        try {
	        	pstmt = conn.prepareStatement(sql);
	        	pstmt.setString(1, user.getName());
				pstmt.setInt(2, user.getAge());
	            if(conn==null)  new Dao();    //如果连接对象为空，则重新调用构造方法
	            return pstmt.executeUpdate();//执行更新
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return -1;
	        } finally {
	        }
	    }
	 
	 public static void close() {//关闭方法
	        try {
	            conn.close();//关闭连接对象       
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	            conn = null;    //设置连接对象为null值
	        }
	    }
	
//	public static Connection getConnection(){
//		Connection conn=null;
//		
//		try {
//			Class.forName(DBDRIVER);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
////		try {
////			conn.close();
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		return conn;
//	}

}
