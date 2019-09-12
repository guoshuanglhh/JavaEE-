package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.Page;
import com.zhiyou.pojo.Rects;

public interface RectService {
	//获取页面需要传递的condition
	String getCondition(Rects rect);
	//根据pageNum获取分页所需的所有相关参数
	Page getRectPageinformation(String num, Rects rect);
	//实现租户信息条件分页
	List<Rects> RectPaging(Page page, Rects rect);
	//获取所有未出租的房屋id
	List<Rects> getNotRentHouseId();
	//添加房租信息
	String addRectInformationService(Rects rects);
	//根据id删除房租信息,直接删除
	String deleteRectByIdService(int r_id);
	//根据id查询出该rects的所有信息并封装
	Rects queryRectByIdService(int id);
	//修改房租信息
	String editRectInformationService(Rects rects);
}
