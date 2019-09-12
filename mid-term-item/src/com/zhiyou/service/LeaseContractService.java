package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.LeaseContract;
import com.zhiyou.pojo.Page;

public interface LeaseContractService {
	//获取页面需要传递的condition
	String getCondition(LeaseContract leaseContract);
	//根据pageNum获取分页所需的所有相关参数
	Page getLeaseContractPageinformation(String num, LeaseContract leaseContract);
	//实现合同信息条件分页
	List<LeaseContract> leaseContractPaging(Page page, LeaseContract leaseContract);
	//添加合同信息
	String addLeaseContractInformationService(LeaseContract leaseContract);
	//根据id删除房租信息,直接删除
	String deleteLeaseContractByIdService(int lc_id);
	//根据id查询出该rects的所有信息并封装
	LeaseContract queryLeaseContractByIdService(int id);
	//修改房租信息
	String editLeaseContractInformationService(LeaseContract leaseContract);
	//查询可用信息
	List<LeaseContract> getUseableInformation();
}
