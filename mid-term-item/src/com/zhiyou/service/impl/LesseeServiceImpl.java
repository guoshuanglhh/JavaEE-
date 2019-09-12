package com.zhiyou.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou.dao.LesseeDao;
import com.zhiyou.dao.impl.LesseeDaoImpl;
import com.zhiyou.pojo.Lessee;
import com.zhiyou.pojo.Page;
import com.zhiyou.service.LesseeService;

public class LesseeServiceImpl implements LesseeService{
	private LesseeDao lesseeDao = new LesseeDaoImpl();
	private ResultSet rst = null;
	private Lessee lessee = null;
	private List<Lessee> lesseeList = new ArrayList<>();;
	private Page page = null;
	
	@Override
	public Page getLesseePageinformation(String num,Lessee tenant) {
		page = new Page();
		page.setPageNum(Integer.parseInt(num));
		if(page.getPageNum()<1){
			page.setPageNum(1);
		}
		//ʹ�ÿɱ��ַ�������sql���
		StringBuilder sql = new StringBuilder("select count(l_id) from lessee "); 
		Object[] objs = null;
		//��������
		String t_name = tenant.getL_name();
		String t_tel = tenant.getL_tel();
		String t_sex = tenant.getL_sex();
		String t_id_card = tenant.getL_id_card();
		if("".equals(t_name)&&"".equals(t_tel)&&"".equals(t_sex)&&"".equals(t_id_card)||"null".equals(t_name)&&"null".equals(t_tel)&&"null".equals(t_sex)&&"null".equals(t_id_card)||t_name==null&&t_tel==null&&t_sex==null&&t_id_card==null){
			//δ��������ʱ,ȫ�ֲ�ѯ
			sql.append("where l_flag=?");
			objs = new Object[1];
			objs[0] = 1;
		}else if(!"".equals(t_tel)&!"null".equals(t_tel)&t_tel!=null){
			//�ֻ��Ų�Ϊ��
			sql.append("where l_flag=? and l_tel like concat('%',?,'%')");
			objs = new Object[2];
			objs[0] = 1;
			objs[1] = t_tel;
		}else if(!"".equals(t_id_card)&!"null".equals(t_id_card)&t_id_card!=null){
			//���֤�Ų�Ϊ��
			sql.append("where l_flag=? and l_id_card like concat('%',?,'%')");
			objs = new Object[2];
			objs[0] = 1;
			objs[1] = t_id_card;
		}else if(!"".equals(t_name)&!"null".equals(t_name)&t_name!=null){
			//�������Ա𶼲�Ϊ��
			if(!"".equals(t_sex)&!"null".equals(t_sex)&t_sex!=null){
				sql.append("where l_flag=? and l_name like concat('%',?,'%') and l_sex=?");
				objs = new Object[3];
				objs[0] = 1;
				objs[1] = t_name;
				objs[2] = t_sex;
			}else{//������ΪΪ�գ��Ա�Ϊ��
				sql.append("where l_flag=? and l_name like concat('%',?,'%')");
				objs = new Object[2];
				objs[0] = 1;
				objs[1] = t_name;
			}
		}else{
			//�Ա�Ϊ��
			sql.append("where l_flag=? and l_sex=?");
			objs = new Object[2];
			objs[0] = 1;
			objs[1] = t_sex;
		}

		//����ÿҳ��ʾ�ļ�¼����
		page.setPageSize(20);
		rst = lesseeDao.queryLesseeCountById(sql.toString(),objs);
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
	public List<Lessee> lesseePaging(Page page,Lessee tenant) {
		//ʹ�ÿɱ��ַ�������sql���
		StringBuilder sql = new StringBuilder("select * from lessee "); 
		Object[] objs = null;
		//��������
		StringBuilder condition = new StringBuilder();
		String t_name = tenant.getL_name();
		String t_tel = tenant.getL_tel();
		String t_sex = tenant.getL_sex();
		String t_id_card = tenant.getL_id_card();
		if("".equals(t_name)&&"".equals(t_tel)&&"".equals(t_sex)&&"".equals(t_id_card)||"null".equals(t_name)&&"null".equals(t_tel)&&"null".equals(t_sex)&&"null".equals(t_id_card)||t_name==null&&t_tel==null&&t_sex==null&&t_id_card==null){
			//δ��������ʱ,ȫ�ֲ�ѯ
			sql.append("where l_flag=? limit ?,?");
			objs = new Object[3];
			objs[0] = 1;
		}else if(!"".equals(t_tel)&!"null".equals(t_tel)&t_tel!=null){
			//�ֻ��Ų�Ϊ��
			sql.append("where l_flag=? and l_tel like concat('%',?,'%') limit ?,?");
			objs = new Object[4];
			objs[0] = 1;
			objs[1] = t_tel;
			condition.append("l_tel="+t_tel);
		}else if(!"".equals(t_id_card)&!"null".equals(t_id_card)&t_id_card!=null){
			//���֤�Ų�Ϊ��
			sql.append("where l_flag=? and l_id_card like concat('%',?,'%') limit ?,?");
			objs = new Object[4];
			objs[0] = 1;
			objs[1] = t_id_card;
			condition.append("l_id_card="+t_id_card);
		}else if(!"".equals(t_name)&!"null".equals(t_name)&t_name!=null){
			//�������Ա𶼲�Ϊ��
			if(!"".equals(t_sex)&!"null".equals(t_sex)&t_sex!=null){
				sql.append("where l_flag=? and l_name like concat('%',?,'%') and l_sex=? limit ?,?");
				objs = new Object[5];
				objs[0] = 1;
				objs[1] = t_name;
				objs[2] = t_sex;
				condition.append("l_name="+t_name+"&l_sex="+t_sex);
			}else{//������ΪΪ�գ��Ա�Ϊ��
				sql.append("where l_flag=? and l_name like concat('%',?,'%') limit ?,?");
				objs = new Object[4];
				objs[0] = 1;
				objs[1] = t_name;
				condition.append("l_name="+t_name);
			}
		}else{
			//�Ա�Ϊ��
			sql.append("where l_flag=? and l_sex=? limit ?,?");
			objs = new Object[4];
			objs[0] = 1;
			objs[1] = t_sex;
			condition.append("l_sex="+t_sex);
		}

		objs[objs.length-1] = page.getPageSize();
		objs[objs.length-2] = (page.getPageNum()-1)*page.getPageSize();
		rst = lesseeDao.queryLesseeByCondition(sql.toString(), objs);
		try {
			while(rst.next()){
				lessee = new Lessee();
				lessee.setL_id(rst.getInt("l_id"));
				lessee.setL_name(rst.getString("l_name"));
				lessee.setL_tel(rst.getString("l_tel"));
				lessee.setL_sex(rst.getString("l_sex"));
				lessee.setL_native_place(rst.getString("l_native_place"));
				lessee.setL_id_card(rst.getString("l_id_card"));
				lessee.setL_create_time(rst.getString("l_create_time"));
				lesseeList.add(lessee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesseeList;
	}

	@Override
	public StringBuilder getCondition(Lessee lessee) {
		StringBuilder condition = new StringBuilder();
		String t_name = lessee.getL_name();
		String t_tel = lessee.getL_tel();
		String t_sex = lessee.getL_sex();
		String t_id_card = lessee.getL_id_card();
		if("".equals(t_name)&&"".equals(t_tel)&&"".equals(t_sex)&&"".equals(t_id_card)||"null".equals(t_name)&&"null".equals(t_tel)&&"null".equals(t_sex)&&"null".equals(t_id_card)||t_name==null&&t_tel==null&&t_sex==null&&t_id_card==null){
			//δ��������ʱ,ȫ�ֲ�ѯ
		}else if(!"".equals(t_tel)&!"null".equals(t_tel)&t_tel!=null){
			//�ֻ��Ų�Ϊ��
			condition.append("l_tel="+t_tel);
		}else if(!"".equals(t_id_card)&!"null".equals(t_id_card)&t_id_card!=null){
			//���֤�Ų�Ϊ��
			condition.append("l_id_card="+t_id_card);
		}else if(!"".equals(t_name)&!"null".equals(t_name)&t_name!=null){
			//�������Ա𶼲�Ϊ��
			if(!"".equals(t_sex)&!"null".equals(t_sex)&t_sex!=null){
				condition.append("l_name="+t_name+"&l_sex="+t_sex);
			}else{//������ΪΪ�գ��Ա�Ϊ��
				condition.append("l_name="+t_name);
			}
		}else{
			//�Ա�Ϊ��
			condition.append("l_sex="+t_sex);
		}
		return condition;
	}

	@Override
	public String deleteLesseeByIdService(int l_id) {
		int i = lesseeDao.deleteLesseeById(l_id);
		if(i>0){
			return "ɾ���ɹ�";
		}
		return "ɾ��ʧ��";
	}

	@Override
	public String addLesseeInformationService(Lessee lessee) {
		int i = lesseeDao.addLesseeInformation(lessee);
		if(i>0){
			return "�⻧��Ϣ��ӳɹ�";
		}
		return "�⻧��Ϣ���ʧ��";
	}

	
	@Override
	public Lessee queryLesseeByIdService(int id) {
		rst = lesseeDao.queryLesseeDetailById(id);
		try {
			if(rst.next()){
				lessee = new Lessee();
				lessee.setL_id(rst.getInt("l_id"));
				lessee.setL_name(rst.getString("l_name"));
				lessee.setL_tel(rst.getString("l_tel"));
				lessee.setL_sex(rst.getString("l_sex"));
				lessee.setL_native_place(rst.getString("l_native_place"));
				lessee.setL_id_card(rst.getString("l_id_card"));
				lessee.setL_create_time(rst.getString("l_create_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lessee;
	}

	@Override
	public String editlesseeInformationService(Lessee lessee) {
		int i = lesseeDao.updateLesseeInformation(lessee);
		if(i>0){
			return "���ݸ��³ɹ�";
		}
		return "���ݸ���ʧ��";
	}

}
