package com.zhiyou.dao;

import java.sql.ResultSet;

import com.zhiyou.pojo.User;

public interface UserDao {
	/**
	 * 根据账号和密码查询数据
	 * @param user 封装账号和密码对象
	 * @return 账号密码匹配，则返回一条结果集；如果不匹配返回空集
	 */
	public ResultSet queryUserByUsernameAndPassword(User user);
}
