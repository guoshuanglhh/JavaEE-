package com.zhiyou.dao;

import java.sql.ResultSet;

import com.zhiyou.pojo.Lessee;

public interface LesseeDao {
	//根据l_id查询所有需要显示的数据总数
	ResultSet queryLesseeCountById(String sql,Object[] objs);
	
	//查询所有符合条件的记录
	ResultSet queryLesseeByCondition(String sql,Object[] objs);

	//根据l_id删除记录
	int deleteLesseeById(int l_id);

	//添加lessee信息
	int addLesseeInformation(Lessee lessee);

	//根据l_id查询该用户所有信息
	ResultSet queryLesseeDetailById(int id);

	//修改lessee数据
	int updateLesseeInformation(Lessee lessee);
	
}
