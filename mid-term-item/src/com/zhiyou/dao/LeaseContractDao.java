package com.zhiyou.dao;

import java.sql.ResultSet;

import com.zhiyou.pojo.LeaseContract;

public interface LeaseContractDao {
	//����l_id��ѯ������Ҫ��ʾ����������
	ResultSet queryLeaseContractCountById(String sql, Object[] objs);
	//��ѯ���з��������ļ�¼
	ResultSet queryLeaseContractByCondition(String sql,Object[] objs);
	//��ѯ����δ����ķ���id
	ResultSet queryUserableInformation();
	//��Ӻ�ͬ��Ϣ
	int addLeaseContractInformation(LeaseContract leaseContract);
	//����idɾ����ͬ��Ϣ
	int deleteLeaseContractById(int lc_id);
	//����id��ѯ��ͬ��ϸ��Ϣ
	ResultSet queryLeaseContractDetailById(int id);
	//�޸ĺ�ͬ��Ϣ
	int updateLeaseContractInformation(LeaseContract leaseContract);
}
