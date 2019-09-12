package com.zhiyou.dao.impl;

import java.sql.ResultSet;

import com.zhiyou.dao.RectDao;
import com.zhiyou.pojo.Rects;
import com.zhiyou.util.DatabaseUtil;

public class RectDaoImpl implements RectDao{
	//定义数据库连接的工具类
	private DatabaseUtil dbUtil = new DatabaseUtil();
	
	@Override
	public ResultSet queryRectCountById(String sql, Object[] objs) {
		return dbUtil.query(sql, objs);
	}

	@Override
	public ResultSet queryRectByCondition(String sql, Object[] objs) {
		return dbUtil.query(sql, objs);
	}

	@Override
	public ResultSet queryAllNotRentHouseId() {
		String sql = "select h_id,l_id from rect,house,lessee where flat_id=h_id and tenant_id=lessee.l_id and l_flag=1 and h_flag=1 and r_flag=1 and h_status=2";
		Object[] objs = {};
		return dbUtil.query(sql, objs);
	}

	@Override
	public int addRectInformation(Rects rects) {
		int flat_id = rects.getH_id();
		int tenant_id = rects.getL_id();
		double r_money = rects.getR_money();
		String r_time = rects.getR_time();
		String r_remark = rects.getR_remark();
		String sql1 = "insert into rect(flat_id,tenant_id,r_money,r_time,r_remark,r_flag) values(?,?,?,?,?,?)";
		Object[] objs1 = {flat_id,tenant_id,r_money,r_time,r_remark,1};
		int i = dbUtil.update(sql1, objs1);
		int j = 0;
		if(i>0){
			String sql2 = "update house set h_status=1 where h_id=?";
			Object[] objs2 = {flat_id};
			j = dbUtil.update(sql2, objs2);
		}else{
			return i;
		}
		return j;
	}
	
	//根据id删除房租信息,同时将租户flag=0不显示,房屋状态设为未出租
	@Override
	public int deleteRectById(int r_id) {
		String sql1 = "update rect set r_flag=0 where r_id=?";
		Object[] objs1 = {r_id};
		int i = dbUtil.update(sql1, objs1);
		if(i>0){
			String sql2 = "update lessee set l_flag=0 where l_id=(select tenant_id from rect where r_id=?)";
			Object[] objs2 = {r_id};
			int j = dbUtil.update(sql2, objs2);
			if(j>0){
				String sql3 = "update house set h_status=2 where h_id=(select flat_id from rect where r_id=?)";
				Object[] objs3 = {r_id};
				return dbUtil.update(sql3, objs3);
			}else{
				return j;
			}
		}else{
			return i;
		}
	}

	@Override
	public ResultSet queryRectDetailById(int id) {
		String sql = "select * from rect where r_id=?";
		Object[] objs = {id};
		return dbUtil.query(sql, objs);
	}

	@Override
	public int updateRectInformation(Rects rects) {
		int r_id = rects.getR_id();
		int flat_id = rects.getH_id();
		int tenant_id = rects.getL_id();
		double r_money = rects.getR_money();
		String r_time = rects.getR_time();
		String r_remark = rects.getR_remark();
		String sql = "update rect set flat_id=?,tenant_id=?,r_money=?,r_time=?,r_remark=? where r_id=?";
		Object[] objs = {flat_id,tenant_id,r_money,r_time,r_remark,r_id};
		return dbUtil.update(sql, objs);
	}

}
