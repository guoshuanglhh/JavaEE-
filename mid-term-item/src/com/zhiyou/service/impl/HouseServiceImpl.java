package com.zhiyou.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou.dao.HouseDao;
import com.zhiyou.dao.impl.HouseDaoImpl;
import com.zhiyou.pojo.House;
import com.zhiyou.pojo.Page;
import com.zhiyou.service.HouseService;

public class HouseServiceImpl implements HouseService{
	private HouseDao houseDao = new HouseDaoImpl();
	private ResultSet rst = null;
	private House house = null;
	
	@Override
	public Page getHousePageInformation(String num) {
		rst = houseDao.queryHouseCountById();
		Page page = new Page();
		int count = 0;
		int pageCount = 0;
		int pageSize = 20;
		int pageNum = 1;
		try {
			if(rst.next()){
				//��ȡ�ܼ�¼��
				count = rst.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//����ÿҳ��ʾ�ļ�¼����
		page.setPageSize(pageSize);
		//������ҳ��
		pageCount = count%pageSize==0?count/pageSize:count/pageSize+1;
		pageNum = Integer.parseInt(num);
		if(pageNum<1){
			pageNum = 1;
		}
		if(pageNum>pageCount){
			pageNum = pageCount;
		}
		page.setCount(count);
		page.setPageSize(pageSize);
		page.setPageCount(pageCount);
		page.setPageNum(pageNum);
		return page;
	}

	@Override
	public List<House> housePaging(Page page) {
		List<House> houseList = new ArrayList<>();
		rst = houseDao.housePagingQuery(page.getPageNum(), page.getPageSize());
		try {
			while(rst.next()){
				house = new House();
				house.setH_id(rst.getInt("h_id"));
				house.setH_area(rst.getString("h_area"));
				house.setH_estate(rst.getString("h_estate"));
				house.setH_unitNumber(rst.getString("h_unitNumber"));
				house.setH_floor(rst.getInt("h_floor"));
				house.setH_roomNo(rst.getString("h_roomNo"));
				house.setH_acreage(rst.getString("h_acreage"));
				house.setH_direction(rst.getString("h_direction"));
				house.setH_fitment(rst.getString("h_fitment"));
				if(rst.getBoolean("h_isDoubleAir")==false){
					house.setH_isDoubleAir("��");
				}else{
					if(rst.getInt("h_id")%3==0){
						house.setH_isDoubleAir("��Ȼ��");						
					}else if(rst.getInt("h_id")==1){
						house.setH_isDoubleAir("ů��");	
					}else{
						house.setH_isDoubleAir("��Ȼ�� ů��");	
					}
				}
				house.setH_limit(rst.getInt("h_limit"));
				house.setH_facility(rst.getString("h_facility"));
				house.setH_price(rst.getDouble("h_price"));
				if(rst.getInt("h_status")==1){
					house.setH_status("�ѳ���");
				}else if(rst.getInt("h_status")==2){
					house.setH_status("δ����");
				}else{
					house.setH_status("ֹͣ����");
				}
				house.setH_address(rst.getString("h_address"));
				house.setH_addtime(rst.getString("h_addtime"));
				house.setH_updateTime(rst.getString("h_updateTime"));
				houseList.add(house);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return houseList;
	}

	@Override
	public String addHouseInformationService(House house) {
		int i = houseDao.addHouseInformation(house);
		if(i>0){
			return "������Ϣ��ӳɹ�";
		}
		return "������Ϣ���ʧ��";
	}

	@Override
	public House queryHouseDetailByIdService(int h_id) {
		rst = houseDao.queryHouseDetailById(h_id);
		try {
			if(rst.next()){
				house = new House();
				house.setH_id(rst.getInt("h_id"));
				house.setH_area(rst.getString("h_area"));
				house.setH_estate(rst.getString("h_estate"));
				house.setH_unitNumber(rst.getString("h_unitNumber"));
				house.setH_floor(rst.getInt("h_floor"));
				house.setH_roomNo(rst.getString("h_roomNo"));
				house.setH_acreage(rst.getString("h_acreage"));
				house.setH_direction(rst.getString("h_direction"));
				house.setH_fitment(rst.getString("h_fitment"));
				if(rst.getBoolean("h_isDoubleAir")==false){
					house.setH_isDoubleAir("��");
				}else{
					if(rst.getInt("h_id")%3==0){
						house.setH_isDoubleAir("��Ȼ��");						
					}else if(rst.getInt("h_id")==1){
						house.setH_isDoubleAir("ů��");	
					}else{
						house.setH_isDoubleAir("��Ȼ�� ů��");	
					}
				}
				house.setH_limit(rst.getInt("h_limit"));
				house.setH_facility(rst.getString("h_facility"));
				house.setH_price(rst.getDouble("h_price"));
				if(rst.getInt("h_status")==1){
					house.setH_status("�ѳ���");
				}else if(rst.getInt("h_status")==2){
					house.setH_status("δ����");
				}else{
					house.setH_status("ֹͣ����");
				}
				house.setH_address(rst.getString("h_address"));
				house.setH_addtime(rst.getString("h_addtime"));
				house.setH_updateTime(rst.getString("h_updateTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return house;
	}

	
	@Override
	public String deleteHouseByIdService(int h_id) {
		int i = houseDao.deleteHouseById(h_id);
		if(i>0){
			return "ɾ���ɹ�";
		}
		return "ɾ��ʧ��";
	}

	@Override
	public int editHouseInformationService(House house,int pageNum) {
		int i = houseDao.updateHouseInformation(house);
		if(i>0){
			return pageNum;
		}
		System.out.println("���ݸ���ʧ��");
		return 0;
	}
}
