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
	public Dao() {                                        //Ĭ�Ϲ��캯��
        try {
            if (conn == null) {                            //������Ӷ���Ϊ��
                Class.forName(DBDRIVER);                //����������
                conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);//������Ӷ���
                System.out.println("conn created");
            }
        } catch (Exception ee) {
            ee.printStackTrace();
            System.out.println("conn not created");
        }
    }
	
	public static ResultSet executeQuery(String sql) {    //��ѯ����
        try {
            if(conn==null)  new Dao();  //������Ӷ���Ϊ�գ������µ��ù��췽��
            return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(sql);//ִ�в�ѯ
        } catch (SQLException e) {
            e.printStackTrace();
            return null;                //����nullֵ
        } finally {
        }
    }
	
	public static int executeUpdate(User user) {        //���·���
		 
		 String sql = "INSERT INTO user(name,age)" + "VALUES(?,?)";
	        try {
	        	pstmt = conn.prepareStatement(sql);
	        	pstmt.setString(1, user.getName());
				pstmt.setInt(2, user.getAge());
	            if(conn==null)  new Dao();    //������Ӷ���Ϊ�գ������µ��ù��췽��
	            return pstmt.executeUpdate();//ִ�и���
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return -1;
	        } finally {
	        }
	    }
	 
	 public static void close() {//�رշ���
	        try {
	            conn.close();//�ر����Ӷ���       
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	            conn = null;    //�������Ӷ���Ϊnullֵ
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
