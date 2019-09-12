package com.zhiyou.dao;

import java.sql.ResultSet;

import com.zhiyou.pojo.House;

public interface HouseDao {
	ResultSet queryHouseCountById();
	ResultSet housePagingQuery(int pageNum,int pageSize);
	int addHouseInformation(House house);
	ResultSet queryHouseDetailById(int h_id);
	int deleteHouseById(int h_id);
	int updateHouseInformation(House house);
}
