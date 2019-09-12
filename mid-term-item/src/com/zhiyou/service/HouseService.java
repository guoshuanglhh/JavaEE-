package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.House;
import com.zhiyou.pojo.Page;

public interface HouseService {
	//����pageNum��ȡ��ҳ�����������ز���
	Page getHousePageInformation(String num);
	//ʵ�ַ�����Ϣ��ҳ
	List<House> housePaging(Page page);
	//ʵ����ӷ�����Ϣ
	String addHouseInformationService(House house);
	//����h_id��ѯ���ݵ�������Ϣ
	House queryHouseDetailByIdService(int h_id);
	//����h_id��ɾ��������Ϣ
	public String deleteHouseByIdService(int h_id);
	//�޸ķ�����Ϣ
	public int editHouseInformationService(House house,int pageNum);
}	
