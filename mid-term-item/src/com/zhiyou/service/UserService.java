package com.zhiyou.service;

import com.zhiyou.pojo.User;

public interface UserService {
	/**
	 * �ж��Ƿ��¼�ɹ�
	 * @param user
	 * @return ������1֤���˺�����ƥ��ɹ�,�ض���admin.jsp;
	 * ��֮����false��˵��ƥ�䲻�ɹ�,��¼ʧ��,�ض���login.jsp,��������¼ʧ��ԭ��
	 */
	public boolean isLoginSuccess(User user);
}
