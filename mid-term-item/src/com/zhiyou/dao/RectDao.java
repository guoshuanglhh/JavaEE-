package com.zhiyou.dao;

import java.sql.ResultSet;

import com.zhiyou.pojo.Rects;

public interface RectDao {
	//����l_id��ѯ������Ҫ��ʾ����������
	ResultSet queryRectCountById(String sql, Object[] objs);
	//��ѯ���з��������ļ�¼
	ResultSet queryRectByCondition(String sql,Object[] objs);
	//��ѯ����δ����ķ���id
	ResultSet queryAllNotRentHouseId();
	//��ӷ�����Ϣ
	int addRectInformation(Rects rects);
	//����idɾ��������Ϣ,ͬʱ���⻧flag=0����ʾ,����״̬��Ϊδ����
	int deleteRectById(int r_id);
	//����id��ѯ������ϸ��Ϣ
	ResultSet queryRectDetailById(int id);
	//�޸ķ�����Ϣ
	int updateRectInformation(Rects rects);
}
