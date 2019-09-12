package com.zhiyou.dao;

import java.sql.ResultSet;

import com.zhiyou.pojo.Lessee;

public interface LesseeDao {
	//����l_id��ѯ������Ҫ��ʾ����������
	ResultSet queryLesseeCountById(String sql,Object[] objs);
	
	//��ѯ���з��������ļ�¼
	ResultSet queryLesseeByCondition(String sql,Object[] objs);

	//����l_idɾ����¼
	int deleteLesseeById(int l_id);

	//���lessee��Ϣ
	int addLesseeInformation(Lessee lessee);

	//����l_id��ѯ���û�������Ϣ
	ResultSet queryLesseeDetailById(int id);

	//�޸�lessee����
	int updateLesseeInformation(Lessee lessee);
	
}
