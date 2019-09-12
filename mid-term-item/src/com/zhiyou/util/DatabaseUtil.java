package com.zhiyou.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtil {
	private static String URL = "jdbc:mysql://localhost:3306/apartment?serverTimezone=Asia/Shanghai";
	private static String USER = "root";
	private static String PASSWORD = "root";
	private static Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	//�������ݿ�
	static{//����Ϊ��̬�����������ļ������
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ɾ��
	 * @param sql	��Ҫִ�е�sql���
	 * @param objs	��װ�����ݵ�����,��Ҫ��sql����е�ռλ��һһ��Ӧ
	 * @return	sqlִ�гɹ�������Ӱ�����������֮����0
	 */
	public int update(String sql,Object[] objs){
		int a = 0;//Ĭ����ɾ����ʧ�ܵ�
		try {
			ps = conn.prepareStatement(sql);
			//��ռλ����ֵ
			for(int i=0;i<objs.length;i++){
				ps.setObject(i+1, objs[i]);
			}
			a = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	/**
	 * ��ѯ
	 * @param sql	��Ҫִ�е�sql���
	 * @param objs	��װ�����ݵ�����,��Ҫ��sql����е�ռλ��һһ��Ӧ
	 * @return	��װ���ݵĽ������ʧ�ܷ���null
	 */
	public ResultSet query(String sql,Object[] objs){
		try {
			ps = conn.prepareStatement(sql);
			//��ռλ����ֵ
			for(int i=0;i<objs.length;i++){
				ps.setObject(i+1,objs[i]);
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//�ͷ���Դ
	public void close(){
		try{
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
