package com.zhiyou.dao;

import java.sql.ResultSet;

import com.zhiyou.pojo.User;

public interface UserDao {
	/**
	 * �����˺ź������ѯ����
	 * @param user ��װ�˺ź��������
	 * @return �˺�����ƥ�䣬�򷵻�һ��������������ƥ�䷵�ؿռ�
	 */
	public ResultSet queryUserByUsernameAndPassword(User user);
}
