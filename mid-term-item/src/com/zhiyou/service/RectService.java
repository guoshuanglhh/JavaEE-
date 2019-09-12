package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.Page;
import com.zhiyou.pojo.Rects;

public interface RectService {
	//��ȡҳ����Ҫ���ݵ�condition
	String getCondition(Rects rect);
	//����pageNum��ȡ��ҳ�����������ز���
	Page getRectPageinformation(String num, Rects rect);
	//ʵ���⻧��Ϣ������ҳ
	List<Rects> RectPaging(Page page, Rects rect);
	//��ȡ����δ����ķ���id
	List<Rects> getNotRentHouseId();
	//��ӷ�����Ϣ
	String addRectInformationService(Rects rects);
	//����idɾ��������Ϣ,ֱ��ɾ��
	String deleteRectByIdService(int r_id);
	//����id��ѯ����rects��������Ϣ����װ
	Rects queryRectByIdService(int id);
	//�޸ķ�����Ϣ
	String editRectInformationService(Rects rects);
}
