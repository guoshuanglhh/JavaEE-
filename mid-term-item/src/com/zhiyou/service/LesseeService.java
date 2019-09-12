package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.Lessee;
import com.zhiyou.pojo.Page;

public interface LesseeService {
	//获取页面需要传递的condition
	StringBuilder getCondition(Lessee lessee);
	//根据pageNum获取分页所需的所有相关参数
	Page getLesseePageinformation(String num,Lessee tenant);
	//实现租户信息条件分页
	List<Lessee> lesseePaging(Page page,Lessee tenant);
	//根据l_id删除lessee信息
	String deleteLesseeByIdService(int l_id);
	//添加lessee信息
	String addLesseeInformationService(Lessee lessee);
	//根据id查询出该lessee的所有信息并封装
	Lessee queryLesseeByIdService(int id);
	//判断是否修改成功
	String editlesseeInformationService(Lessee lessee);

}
