package com.zhiyou.service;

import com.zhiyou.pojo.User;

public interface UserService {
	/**
	 * 判断是否登录成功
	 * @param user
	 * @return 若返回1证明账号密码匹配成功,重定向到admin.jsp;
	 * 反之返回false则说明匹配不成功,登录失败,重定向到login.jsp,并给出登录失败原因
	 */
	public boolean isLoginSuccess(User user);
}
