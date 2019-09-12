package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.LeaseContract;
import com.zhiyou.pojo.Page;

public interface LeaseContractService {
	//��ȡҳ����Ҫ���ݵ�condition
	String getCondition(LeaseContract leaseContract);
	//����pageNum��ȡ��ҳ�����������ز���
	Page getLeaseContractPageinformation(String num, LeaseContract leaseContract);
	//ʵ�ֺ�ͬ��Ϣ������ҳ
	List<LeaseContract> leaseContractPaging(Page page, LeaseContract leaseContract);
	//��Ӻ�ͬ��Ϣ
	String addLeaseContractInformationService(LeaseContract leaseContract);
	//����idɾ��������Ϣ,ֱ��ɾ��
	String deleteLeaseContractByIdService(int lc_id);
	//����id��ѯ����rects��������Ϣ����װ
	LeaseContract queryLeaseContractByIdService(int id);
	//�޸ķ�����Ϣ
	String editLeaseContractInformationService(LeaseContract leaseContract);
	//��ѯ������Ϣ
	List<LeaseContract> getUseableInformation();
}
