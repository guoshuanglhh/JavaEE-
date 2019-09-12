package com.zhiyou.dao;

import java.sql.ResultSet;

import com.zhiyou.pojo.Rects;

public interface RectDao {
	//根据l_id查询所有需要显示的数据总数
	ResultSet queryRectCountById(String sql, Object[] objs);
	//查询所有符合条件的记录
	ResultSet queryRectByCondition(String sql,Object[] objs);
	//查询所有未出租的房屋id
	ResultSet queryAllNotRentHouseId();
	//添加房租信息
	int addRectInformation(Rects rects);
	//根据id删除房租信息,同时将租户flag=0不显示,房屋状态设为未出租
	int deleteRectById(int r_id);
	//根据id查询房租详细信息
	ResultSet queryRectDetailById(int id);
	//修改房租信息
	int updateRectInformation(Rects rects);
}
