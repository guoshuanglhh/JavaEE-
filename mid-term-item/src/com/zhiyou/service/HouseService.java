package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.House;
import com.zhiyou.pojo.Page;

public interface HouseService {
	//根据pageNum获取分页所需的所有相关参数
	Page getHousePageInformation(String num);
	//实现房屋信息分页
	List<House> housePaging(Page page);
	//实现添加房屋信息
	String addHouseInformationService(House house);
	//根据h_id查询房屋的所有信息
	House queryHouseDetailByIdService(int h_id);
	//根据h_id假删除房屋信息
	public String deleteHouseByIdService(int h_id);
	//修改房屋信息
	public int editHouseInformationService(House house,int pageNum);
}	
