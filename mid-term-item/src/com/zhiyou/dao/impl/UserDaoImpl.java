package com.zhiyou.dao.impl;

import java.sql.ResultSet;

import com.zhiyou.dao.UserDao;
import com.zhiyou.pojo.User;
import com.zhiyou.util.DatabaseUtil;

public class UserDaoImpl implements UserDao{
	//�������ݿ����ӵĹ�����
	DatabaseUtil dbUtil = new DatabaseUtil();
	
	@Override
	public ResultSet queryUserByUsernameAndPassword(User user) {
		String sql = "select * from user where u_name=? and u_pass=?";
		Object[] objs = {user.getU_name(),user.getU_password()};
		return dbUtil.query(sql, objs);
	}
}
