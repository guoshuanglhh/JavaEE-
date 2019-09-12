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
			//δ��������ʱ,ȫ�ֲ�ѯ
		}else if(!"".equals(l_tel)&!"null".equals(l_tel)&l_tel!=null){
			//�ֻ��Ų�Ϊ��
			condition.append("l_tel="+l_tel);
		}else if(!"".equals(l_name)&!"null".equals(l_name)&l_name!=null){
			//�������ɷ�ʱ�䶼��Ϊ��
			if(!"".equals(r_time)&!"null".equals(r_time)&r_time!=null){
				condition.append("l_name="+l_name+"&r_time="+r_time);
			}else{//������ΪΪ�գ��Ա�Ϊ��
				condition.append("l_name="+l_name);
			}
		}else{
			//�Ա�Ϊ��
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
		//ʹ�ÿɱ��ַ�������sql���
		StringBuilder sql = new StringBuilder("select count(*) from rect,lessee,house where flat_id=h_id and tenant_id=l_id and l_flag=? and h_flag=? and r_flag=1 ");
		Object[] objs = null;
		//��������
		String l_name = rect.getL_name();
		String l_tel = rect.getL_tel();
		String r_time = rect.getR_time();
		
		if(l_name==null&&l_tel==null&&r_time==null||"null".equals(r_time)&&"null".equals(l_name)&&"null".equals(l_tel)||"".equals(l_name)&&"".equals(l_tel)&&"".equals(r_time)){
			//δ��������ʱ,ȫ�ֲ�ѯ
			objs = new Object[2];
			objs[0] = 1;
			objs[1] = 1;
		}else if(!"".equals(l_tel)&!"null".equals(l_tel)&l_tel!=null){
			//�ֻ��Ų�Ϊ��
			sql.append("and l_tel like concat('%',?,'%')");
			objs = new Object[3];
			objs[0] = 1;
			objs[1] = 1;
			objs[2] = l_tel;
		}else if(!"".equals(l_name)&!"null".equals(l_name)&l_name!=null){
			//�������ɷ�ʱ�䶼��Ϊ��
			if(!"".equals(r_time)&!"null".equals(r_time)&r_time!=null){
				sql.append("and l_name like concat('%',?,'%') and r_time=?");
				objs = new Object[4];
				objs[0] = 1;
				objs[1] = 1;
				objs[2] = l_name;
				objs[3] = r_time;
			}else{//������ΪΪ�գ�����ʱ��Ϊ��
				sql.append("and l_name like concat('%',?,'%')");
				objs = new Object[3];
				objs[0] = 1;
				objs[1] = 1;
				objs[2] = l_name;
			}
		}else{
			//����ʱ�䲻Ϊ��
			sql.append("and r_time=?");
			objs = new Object[3];
			objs[0] = 1;
			objs[1] = 1;
			objs[2] = r_time;
		}
		//����ÿҳ��ʾ�ļ�¼����
		page.setPageSize(20);
		rst = rectDao.queryRectCountById(sql.toString(),objs);
		try {
			if(rst.next()){
				//��ȡ�ܼ�¼��
				page.setCount(rst.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//������ҳ��
		page.setPageCount(page.getCount()%page.getPageSize()==0?page.getCount()/page.getPageSize():page.getCount()/page.getPageSize()+1);
		if(page.getPageNum()>page.getPageCount()){
			page.setPageNum(page.getPageCount());
		}
		return page;
	}

	@Override
	public List<Rects> RectPaging(Page page, Rects rect) {
		//ʹ�ÿɱ��ַ�������sql���
		StringBuilder sql = new StringBuilder("select * from rect,lessee,house where flat_id=h_id and tenant_id=l_id and l_flag=1 and h_flag=1 and r_flag=1 "); 
		Object[] objs = null;
		//��������
		StringBuilder condition = new StringBuilder();
		String l_name = rect.getL_name();
		String l_tel = rect.getL_tel();
		String r_time = rect.getR_time();
		if("".equals(l_name)&&"".equals(l_tel)&&"".equals(r_time)||"null".equals(l_name)&&"null".equals(l_tel)&&"null".equals(r_time)||l_name==null&&l_tel==null&&r_time==null){
			//δ��������ʱ,ȫ�ֲ�ѯ
			sql.append("limit ?,?");
			objs = new Object[2];
		}else if(!"".equals(l_tel)&!"null".equals(l_tel)&l_tel!=null){
			//�ֻ��Ų�Ϊ��
			sql.append("and l_tel like concat('%',?,'%') limit ?,?");
			objs = new Object[3];
			objs[0] = l_tel;
			condition.append("l_tel="+l_tel);
		}else if(!"".equals(l_name)&!"null".equals(l_name)&l_name!=null){
			//�������ɷ�ʱ�䶼��Ϊ��
			if(!"".equals(r_time)&!"null".equals(r_time)&r_time!=null){
				sql.append("and l_name like concat('%',?,'%') and r_time=? limit ?,?");
				objs = new Object[4];
				objs[0] = l_name;
				objs[1] = r_time;
				condition.append("l_name="+l_name+"&r_time="+r_time);
			}else{//������ΪΪ�գ��ɷ�ʱ��Ϊ��
				sql.append("and l_name like concat('%',?,'%') limit ?,?");
				objs = new Object[3];
				objs[0] = l_name;
				condition.append("l_name="+l_name);
			}
		}else{
			//�ɷ�ʱ�䲻Ϊ��
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
			return "������Ϣ��ӳɹ�";
		}
		return "������Ϣ���ʧ��";
	}

	@Override
	public String deleteRectByIdService(int r_id) {
		int i = rectDao.deleteRectById(r_id);
		if(i>0){
			return "ɾ���ɹ�";
		}
		return "ɾ��ʧ��";
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
			return "���ݸ��³ɹ�";
		}
		return "���ݸ���ʧ��";
	}
}
