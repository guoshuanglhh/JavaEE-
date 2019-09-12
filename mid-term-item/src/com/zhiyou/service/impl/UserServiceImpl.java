package com.zhiyou.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.impl.UserDaoImpl;
import com.zhiyou.pojo.User;
import com.zhiyou.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();
	@Override
	public boolean isLoginSuccess(User user) {
		ResultSet rst = userDao.queryUserByUsernameAndPassword(user);
		try {
			if(rst.next()){//�˺�������ȷ
				//����true˵��ƥ��ɹ�
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
