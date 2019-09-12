package com.zhiyou.dao.impl;

import java.sql.ResultSet;

import com.zhiyou.dao.UserDao;
import com.zhiyou.pojo.User;
import com.zhiyou.util.DatabaseUtil;

public class UserDaoImpl implements UserDao{
	//定义数据库连接的工具类
	DatabaseUtil dbUtil = new DatabaseUtil();
	
	@Override
	public ResultSet queryUserByUsernameAndPassword(User user) {
		String sql = "select * from user where u_name=? and u_pass=?";
		Object[] objs = {user.getU_name(),user.getU_password()};
		return dbUtil.query(sql, objs);
	}
}
