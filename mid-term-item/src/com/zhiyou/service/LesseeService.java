package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.Lessee;
import com.zhiyou.pojo.Page;

public interface LesseeService {
	//��ȡҳ����Ҫ���ݵ�condition
	StringBuilder getCondition(Lessee lessee);
	//����pageNum��ȡ��ҳ�����������ز���
	Page getLesseePageinformation(String num,Lessee tenant);
	//ʵ���⻧��Ϣ������ҳ
	List<Lessee> lesseePaging(Page page,Lessee tenant);
	//����l_idɾ��lessee��Ϣ
	String deleteLesseeByIdService(int l_id);
	//���lessee��Ϣ
	String addLesseeInformationService(Lessee lessee);
	//����id��ѯ����lessee��������Ϣ����װ
	Lessee queryLesseeByIdService(int id);
	//�ж��Ƿ��޸ĳɹ�
	String editlesseeInformationService(Lessee lessee);

}
