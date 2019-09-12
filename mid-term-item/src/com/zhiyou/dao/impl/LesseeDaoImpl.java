package com.zhiyou.dao.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zhiyou.dao.LesseeDao;
import com.zhiyou.pojo.Lessee;
import com.zhiyou.util.DatabaseUtil;

public class LesseeDaoImpl implements LesseeDao{
	//定义数据库连接的工具类
	private DatabaseUtil dbUtil = new DatabaseUtil();
	
	@Override
	public ResultSet queryLesseeCountById(String sql,Object[] objs) {
		return dbUtil.query(sql, objs);
	}
	
	@Override
	public ResultSet queryLesseeByCondition(String sql, Object[] objs) {
		return dbUtil.query(sql, objs);
	}
	
	@Override
	public int deleteLesseeById(int l_id) {
		String sql = "update lessee set l_flag=0 where l_id=?";
		Object[] objs = {l_id};
		return dbUtil.update(sql, objs);
	}

	@Override
	public int addLesseeInformation(Lessee lessee) {
		String l_name = lessee.getL_name();
		String l_tel = lessee.getL_tel();
		String l_sex = lessee.getL_sex();
		String l_native_place = lessee.getL_native_place();
		String l_id_card = lessee.getL_id_card();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String l_create_time = sdf.format(new Date());
		String sql = "insert into lessee(l_name,l_tel,l_sex,l_native_place,l_id_card,l_create_time,l_flag) value(?,?,?,?,?,?,?)";
		Object[] objs = {l_name,l_tel,l_sex,l_native_place,l_id_card,l_create_time,1};
		return dbUtil.update(sql, objs);
	}

	
	@Override
	public ResultSet queryLesseeDetailById(int id) {
		String sql = "select * from lessee where l_id=?";
		Object[] objs = {id};
		return dbUtil.query(sql, objs);
	}

	@Override
	public int updateLesseeInformation(Lessee lessee) {
		int l_id = lessee.getL_id();
		String l_name = lessee.getL_name();
		String l_tel = lessee.getL_tel();
		String l_sex = lessee.getL_sex();
		String l_native_place = lessee.getL_native_place();
		String l_id_card = lessee.getL_id_card();
		String sql = "update lessee set l_name=?,l_tel=?,l_sex=?,l_native_place=?,l_id_card=? where l_id=?";
		Object[] objs = {l_name,l_tel,l_sex,l_native_place,l_id_card,l_id};
		return dbUtil.update(sql, objs);
	}
	
}
