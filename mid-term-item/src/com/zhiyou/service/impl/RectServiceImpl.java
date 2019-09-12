package com.zhiyou.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou.dao.RectDao;
import com.zhiyou.dao.impl.RectDaoImpl;
import com.zhiyou.pojo.Page;
import com.zhiyou.pojo.Rects;
import com.zhiyou.service.RectService;

public class RectServiceImpl implements RectService{
	private RectDao rectDao = new RectDaoImpl();
	private ResultSet rst = null;
	private List<Rects> rectList = new ArrayList<>();
	private Page page = null;
	private Rects rects;
	
	@Override
	public String getCondition(Rects rect) {
		StringBuilder condition = new StringBuilder();
		String l_name = rect.getL_name();
		String l_tel = rect.getL_tel();
		String r_time = rect.getR_time();
		if("".equals(l_name)&&"".equals(l_tel)&&"".equals(r_time)||"null".equals(l_name)&&"null".equals(l_tel)&&"null".equals(r_time)||l_name==null&&l_tel==null&&r_time==null){
			//未输入条件时,全局查询
		}else if(!"".equals(l_tel)&!"null".equals(l_tel)&l_tel!=null){
			//手机号不为空
			condition.append("l_tel="+l_tel);
		}else if(!"".equals(l_name)&!"null".equals(l_name)&l_name!=null){
			//姓名、缴费时间都不为空
			if(!"".equals(r_time)&!"null".equals(r_time)&r_time!=null){
				condition.append("l_name="+l_name+"&r_time="+r_time);
			}else{//姓名不为为空，性别为空
				condition.append("l_name="+l_name);
			}
		}else{
			//性别不为空
			condition.append("r_time="+r_time);
		}
		return condition.toString();
	}

	@Override
	public Page getRectPageinformation(String num, Rects rect) {
		page = new Page();
		page.setPageNum(Integer.parseInt(num));
		if(page.getPageNum()<1){
			page.setPageNum(1);
		}
		//使用可变字符串定义sql语句
		StringBuilder sql = new StringBuilder("select count(*) from rect,lessee,house where flat_id=h_id and tenant_id=l_id and l_flag=? and h_flag=? and r_flag=1 ");
		Object[] objs = null;
		//条件参数
		String l_name = rect.getL_name();
		String l_tel = rect.getL_tel();
		String r_time = rect.getR_time();
		
		if(l_name==null&&l_tel==null&&r_time==null||"null".equals(r_time)&&"null".equals(l_name)&&"null".equals(l_tel)||"".equals(l_name)&&"".equals(l_tel)&&"".equals(r_time)){
			//未输入条件时,全局查询
			objs = new Object[2];
			objs[0] = 1;
			objs[1] = 1;
		}else if(!"".equals(l_tel)&!"null".equals(l_tel)&l_tel!=null){
			//手机号不为空
			sql.append("and l_tel like concat('%',?,'%')");
			objs = new Object[3];
			objs[0] = 1;
			objs[1] = 1;
			objs[2] = l_tel;
		}else if(!"".equals(l_name)&!"null".equals(l_name)&l_name!=null){
			//姓名、缴费时间都不为空
			if(!"".equals(r_time)&!"null".equals(r_time)&r_time!=null){
				sql.append("and l_name like concat('%',?,'%') and r_time=?");
				objs = new Object[4];
				objs[0] = 1;
				objs[1] = 1;
				objs[2] = l_name;
				objs[3] = r_time;
			}else{//姓名不为为空，缴纳时间为空
				sql.append("and l_name like concat('%',?,'%')");
				objs = new Object[3];
				objs[0] = 1;
				objs[1] = 1;
				objs[2] = l_name;
			}
		}else{
			//缴纳时间不为空
			sql.append("and r_time=?");
			objs = new Object[3];
			objs[0] = 1;
			objs[1] = 1;
			objs[2] = r_time;
		}
		//设置每页显示的记录条数
		page.setPageSize(20);
		rst = rectDao.queryRectCountById(sql.toString(),objs);
		try {
			if(rst.next()){
				//获取总记录数
				page.setCount(rst.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//计算总页数
		page.setPageCount(page.getCount()%page.getPageSize()==0?page.getCount()/page.getPageSize():page.getCount()/page.getPageSize()+1);
		if(page.getPageNum()>page.getPageCount()){
			page.setPageNum(page.getPageCount());
		}
		return page;
	}

	@Override
	public List<Rects> RectPaging(Page page, Rects rect) {
		//使用可变字符串定义sql语句
		StringBuilder sql = new StringBuilder("select * from rect,lessee,house where flat_id=h_id and tenant_id=l_id and l_flag=1 and h_flag=1 and r_flag=1 "); 
		Object[] objs = null;
		//条件参数
		StringBuilder condition = new StringBuilder();
		String l_name = rect.getL_name();
		String l_tel = rect.getL_tel();
		String r_time = rect.getR_time();
		if("".equals(l_name)&&"".equals(l_tel)&&"".equals(r_time)||"null".equals(l_name)&&"null".equals(l_tel)&&"null".equals(r_time)||l_name==null&&l_tel==null&&r_time==null){
			//未输入条件时,全局查询
			sql.append("limit ?,?");
			objs = new Object[2];
		}else if(!"".equals(l_tel)&!"null".equals(l_tel)&l_tel!=null){
			//手机号不为空
			sql.append("and l_tel like concat('%',?,'%') limit ?,?");
			objs = new Object[3];
			objs[0] = l_tel;
			condition.append("l_tel="+l_tel);
		}else if(!"".equals(l_name)&!"null".equals(l_name)&l_name!=null){
			//姓名、缴费时间都不为空
			if(!"".equals(r_time)&!"null".equals(r_time)&r_time!=null){
				sql.append("and l_name like concat('%',?,'%') and r_time=? limit ?,?");
				objs = new Object[4];
				objs[0] = l_name;
				objs[1] = r_time;
				condition.append("l_name="+l_name+"&r_time="+r_time);
			}else{//姓名不为为空，缴费时间为空
				sql.append("and l_name like concat('%',?,'%') limit ?,?");
				objs = new Object[3];
				objs[0] = l_name;
				condition.append("l_name="+l_name);
			}
		}else{
			//缴费时间不为空
			sql.append("and r_time=? limit ?,?");
			objs = new Object[3];
			objs[0] = r_time;
			condition.append("r_time="+r_time);
		}
		objs[objs.length-1] = page.getPageSize();
		objs[objs.length-2] = (page.getPageNum()-1)*page.getPageSize();
		rst = rectDao.queryRectByCondition(sql.toString(), objs);
		try {
			while(rst.next()){
				Rects rects = new Rects();
				rects.setR_id(rst.getInt("r_id"));
				rects.setH_estate(rst.getString("h_estate"));
				rects.setL_name(rst.getString("l_name"));
				rects.setL_tel(rst.getString("l_tel"));
				rects.setR_money(rst.getDouble("r_money"));
				rects.setR_time(rst.getDate("r_time").toString());
				rects.setR_remark(rst.getString("r_remark"));
				rectList.add(rects);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rectList;
	}

	@Override
	public List<Rects> getNotRentHouseId() {
		rst = rectDao.queryAllNotRentHouseId();
		try {
			while(rst.next()){
				Rects rects = new Rects();
				rects.setH_id(rst.getInt("h_id"));
				rects.setL_id(rst.getInt("l_id"));
				rectList.add(rects);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rectList;
	}

	@Override
	public String addRectInformationService(Rects rects) {
		int i = rectDao.addRectInformation(rects);
		if(i>0){
			return "房租信息添加成功";
		}
		return "房租信息添加失败";
	}

	@Override
	public String deleteRectByIdService(int r_id) {
		int i = rectDao.deleteRectById(r_id);
		if(i>0){
			return "删除成功";
		}
		return "删除失败";
	}

	@Override
	public Rects queryRectByIdService(int id) {
		rst = rectDao.queryRectDetailById(id);
		try {
			if(rst.next()){
				rects = new Rects();
				rects.setR_id(rst.getInt("r_id"));
				rects.setH_id(rst.getInt("flat_id"));
				rects.setL_id(rst.getInt("tenant_id"));
				rects.setR_money(rst.getDouble("r_money"));
				rects.setR_time(rst.getDate("r_time").toString());
				rects.setR_remark(rst.getString("r_remark"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rects;
	}

	@Override
	public String editRectInformationService(Rects rects) {
		int i = rectDao.updateRectInformation(rects);
		if(i>0){
			return "数据更新成功";
		}
		return "数据更新失败";
	}
}
