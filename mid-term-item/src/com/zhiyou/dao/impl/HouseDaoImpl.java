package com.zhiyou.dao.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zhiyou.dao.HouseDao;
import com.zhiyou.pojo.House;
import com.zhiyou.util.DatabaseUtil;

public class HouseDaoImpl implements HouseDao{
	//定义数据库连接的工具类
	private DatabaseUtil dbUtil = new DatabaseUtil();
	@Override
	public ResultSet queryHouseCountById() {
		String sql = "select count(h_id) from house where h_flag=?";
		Object[] objs = {1};
		return dbUtil.query(sql, objs);
	}

	@Override
	public ResultSet housePagingQuery(int pageNum,int pageSize) {
		String sql = "select * from house where h_flag=? limit ?,?";
		Object[] objs = {1,pageSize*(pageNum-1),pageSize};
		return dbUtil.query(sql, objs);
	}

	@Override
	public int addHouseInformation(House house) {
		String h_area = house.getH_area();
		String h_estate = house.getH_estate();
		String h_unitNumber = house.getH_unitNumber();
		int h_floor = house.getH_floor();
		String h_roomNo = house.getH_roomNo();
		String h_acreage = house.getH_acreage();
		String h_direction = house.getH_direction();
		String h_fitment = house.getH_fitment();
		
		String isDoubleAir = house.getH_isDoubleAir();
		int h_isDoubleAir = isDoubleAir=="是"?0:1;
		
		int h_limit = house.getH_limit();
		String h_facility = house.getH_facility();
		double h_price = house.getH_price();
		
		String status = house.getH_status();
		int h_status = status=="已出租"?1:2;
		
		String h_address = house.getH_address();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String h_addtime = sdf.format(new Date());
		String h_updateTime = sdf.format(new Date());
		
		String sql = "insert into house(h_area,h_estate,h_unitNumber,h_floor,h_roomNo,h_acreage,h_direction,h_fitment,h_isDoubleAir,h_limit,h_facility,h_price,h_status,h_address,h_addtime,h_updateTime,h_flag) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] objs = {h_area,h_estate,h_unitNumber,h_floor,h_roomNo,h_acreage,h_direction,h_fitment,h_isDoubleAir,h_limit,h_facility,h_price,h_status,h_address,h_addtime,h_updateTime,1};
		return dbUtil.update(sql, objs);
	}

	@Override
	public ResultSet queryHouseDetailById(int h_id) {
		String sql = "select * from house where h_id=?";
		Object[] objs = {h_id};
		return dbUtil.query(sql, objs);
	}

	@Override
	public int deleteHouseById(int h_id) {
		String sql = "update house set h_flag=0 where h_id=?";
		Object[] objs = {h_id};
		return dbUtil.update(sql, objs);
	}

	@Override
	public int updateHouseInformation(House house) {
		int h_id = house.getH_id();
		String h_area = house.getH_area();
		String h_estate = house.getH_estate();
		String h_unitNumber = house.getH_unitNumber();
		int h_floor = house.getH_floor();
		String h_roomNo = house.getH_roomNo();
		String h_acreage = house.getH_acreage();
		String h_direction = house.getH_direction();
		String h_fitment = house.getH_fitment();
		
		String isDoubleAir = house.getH_isDoubleAir();
		int h_isDoubleAir = isDoubleAir=="是"?0:1;
		
		int h_limit = house.getH_limit();
		String h_facility = house.getH_facility();
		double h_price = house.getH_price();
		
		String status = house.getH_status();
		int h_status = status=="已出租"?1:2;
		
		String h_address = house.getH_address();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String h_updateTime = sdf.format(new Date());
		
		String sql = "update house set h_area=?,h_estate=?,h_unitNumber=?,h_floor=?,h_roomNo=?,h_acreage=?,h_direction=?,h_fitment=?,h_isDoubleAir=?,h_limit=?,h_facility=?,h_price=?,h_status=?,h_address=?,h_updateTime=? where h_id=?";
		Object[] objs = {h_area,h_estate,h_unitNumber,h_floor,h_roomNo,h_acreage,h_direction,h_fitment,h_isDoubleAir,h_limit,h_facility,h_price,h_status,h_address,h_updateTime,h_id};
		return dbUtil.update(sql, objs);
	}
	
}
