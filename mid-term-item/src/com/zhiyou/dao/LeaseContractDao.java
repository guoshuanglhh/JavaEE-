package com.zhiyou.dao;

import java.sql.ResultSet;

import com.zhiyou.pojo.LeaseContract;

public interface LeaseContractDao {
	//根据l_id查询所有需要显示的数据总数
	ResultSet queryLeaseContractCountById(String sql, Object[] objs);
	//查询所有符合条件的记录
	ResultSet queryLeaseContractByCondition(String sql,Object[] objs);
	//查询所有未出租的房屋id
	ResultSet queryUserableInformation();
	//添加合同信息
	int addLeaseContractInformation(LeaseContract leaseContract);
	//根据id删除合同信息
	int deleteLeaseContractById(int lc_id);
	//根据id查询合同详细信息
	ResultSet queryLeaseContractDetailById(int id);
	//修改合同信息
	int updateLeaseContractInformation(LeaseContract leaseContract);
}
