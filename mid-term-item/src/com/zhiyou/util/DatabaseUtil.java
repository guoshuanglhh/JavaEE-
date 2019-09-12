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
	//连接数据库
	static{//定义为静态代码块随着类的加载完成
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
	 * 增删改
	 * @param sql	需要执行的sql语句
	 * @param objs	封装了数据的数组,需要和sql语句中的占位符一一对应
	 * @return	sql执行成功返回受影响的行数，反之返回0
	 */
	public int update(String sql,Object[] objs){
		int a = 0;//默认增删改是失败的
		try {
			ps = conn.prepareStatement(sql);
			//给占位符赋值
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
	 * 查询
	 * @param sql	需要执行的sql语句
	 * @param objs	封装了数据的数组,需要和sql语句中的占位符一一对应
	 * @return	封装数据的结果集，失败返回null
	 */
	public ResultSet query(String sql,Object[] objs){
		try {
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			for(int i=0;i<objs.length;i++){
				ps.setObject(i+1,objs[i]);
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//释放资源
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
