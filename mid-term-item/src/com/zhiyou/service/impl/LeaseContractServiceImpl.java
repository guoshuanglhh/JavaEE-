package com.zhiyou.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou.dao.LeaseContractDao;
import com.zhiyou.dao.impl.LeaseContractDaoImpl;
import com.zhiyou.pojo.LeaseContract;
import com.zhiyou.pojo.Page;
import com.zhiyou.service.LeaseContractService;

public class LeaseContractServiceImpl implements LeaseContractService{
	private LeaseContractDao contractDao = new LeaseContractDaoImpl();
	private ResultSet rst = null;
	private List<LeaseContract> contractList = new ArrayList<>();
	private Page page = null;
	private LeaseContract contract;

	@Override
	public String getCondition(LeaseContract leaseContract) {
		StringBuilder condition = new StringBuilder();
		String lc_contract_number = leaseContract.getLc_contract_number();
		String lc_contract_date = leaseContract.getLc_contract_date();
		String lc_contract_state = leaseContract.getLc_contract_state();
		if("".equals(lc_contract_number)&&"".equals(lc_contract_date)&&"".equals(lc_contract_state)||"null".equals(lc_contract_number)&&"null".equals(lc_contract_date)&&"null".equals(lc_contract_state)||lc_contract_number==null&&lc_contract_date==null&&lc_contract_state==null){
			//未输入条件时,全局查询
		}else if(!"".equals(lc_contract_date)&!"null".equals(lc_contract_date)&lc_contract_date!=null){
			//合同号不为空
			condition.append("lc_contract_date="+lc_contract_date);
		}else if(!"".equals(lc_contract_number)&!"null".equals(lc_contract_number)&lc_contract_number!=null){
			//合同日期和合同状态都不为空
			if(!"".equals(lc_contract_state)&!"null".equals(lc_contract_state)&lc_contract_state!=null){
				condition.append("lc_contract_number="+lc_contract_number+"&lc_contract_state="+lc_contract_state);
			}else{//合同日期不为空、合同状态为空
				condition.append("lc_contract_number="+lc_contract_number);
			}
		}else{
			//合同状态不为为空
			condition.append("lc_contract_state="+lc_contract_state);
		}
		return condition.toString();
	}

	@Override
	public Page getLeaseContractPageinformation(String num, LeaseContract leaseContract) {
		page = new Page();
		page.setPageNum(Integer.parseInt(num));
		if(page.getPageNum()<1){
			page.setPageNum(1);
		}
		//使用可变字符串定义sql语句
		StringBuilder sql = new StringBuilder("select count(lc_id) from leasecontract,lessee,house where flat_id=h_id and tenant_id=lessee.l_id and lc_flag=1 and l_flag=? and h_flag=? ");
		Object[] objs = null;
		//条件参数
		String lc_contract_number = leaseContract.getLc_contract_number();
		String lc_contract_date = leaseContract.getLc_contract_date();
		String lc_contract_state = leaseContract.getLc_contract_state();

		if("".equals(lc_contract_number)&&"".equals(lc_contract_date)&&"".equals(lc_contract_state)||"null".equals(lc_contract_number)&&"null".equals(lc_contract_date)&&"null".equals(lc_contract_state)||lc_contract_number==null&&lc_contract_date==null&&lc_contract_state==null){
			//未输入条件时,全局查询
			objs = new Object[2];
			objs[0] = 1;
			objs[1] = 1;
		}else if(!"".equals(lc_contract_number)&!"null".equals(lc_contract_number)&lc_contract_number!=null){
			//合同号不为空
			sql.append("and lc_contract_number=?");
			objs = new Object[3];
			objs[0] = 1;
			objs[1] = 1;
			objs[2] = lc_contract_number;
		}else if(!"".equals(lc_contract_date)&!"null".equals(lc_contract_date)&lc_contract_date!=null){
			//合同日期、合同状态都不为空
			if(!"".equals(lc_contract_state)&!"null".equals(lc_contract_state)&lc_contract_state!=null){
				sql.append("and lc_contract_date=? and lc_contract_state=?");
				objs = new Object[4];
				objs[0] = 1;
				objs[1] = 1;
				objs[2] = lc_contract_date;
				objs[3] = lc_contract_state;
			}else{//合同日期不为空、合同状态为空
				sql.append("and lc_contract_date=?");
				objs = new Object[3];
				objs[0] = 1;
				objs[1] = 1;
				objs[2] = lc_contract_date;
			}
		}else{
			//合同状态不为为空
			sql.append("and lc_contract_state=?");
			objs = new Object[3];
			objs[0] = 1;
			objs[1] = 1;
			objs[2] = lc_contract_state;
		}
		//设置每页显示的记录条数
		page.setPageSize(20);
		rst = contractDao.queryLeaseContractCountById(sql.toString(),objs);
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
	public List<LeaseContract> leaseContractPaging(Page page, LeaseContract leaseContract) {
		//使用可变字符串定义sql语句
		StringBuilder sql = new StringBuilder("select * from leasecontract,lessee,house where flat_id=h_id and tenant_id=lessee.l_id and lc_flag=1 and l_flag=1 and h_flag=1 "); 
		Object[] objs = null;
		//条件参数
		StringBuilder condition = new StringBuilder();
		String lc_contract_number = leaseContract.getLc_contract_number();
		String lc_contract_date = leaseContract.getLc_contract_date();
		String lc_contract_state = leaseContract.getLc_contract_state();
		if("".equals(lc_contract_date)&&"".equals(lc_contract_number)&&"".equals(lc_contract_state)||"null".equals(lc_contract_date)&&"null".equals(lc_contract_number)&&"null".equals(lc_contract_state)||lc_contract_date==null&&lc_contract_number==null&&lc_contract_state==null){
			//未输入条件时,全局查询
			sql.append("limit ?,?");
			objs = new Object[2];
		}else if(!"".equals(lc_contract_number)&!"null".equals(lc_contract_number)&lc_contract_number!=null){
			//手机号不为空
			sql.append("and lc_contract_number=? limit ?,?");
			objs = new Object[3];
			objs[0] = lc_contract_number;
			condition.append("lc_contract_number="+lc_contract_number);
		}else if(!"".equals(lc_contract_date)&!"null".equals(lc_contract_date)&lc_contract_date!=null){
			//合同日期、合同状态都不为空
			if(!"".equals(lc_contract_state)&!"null".equals(lc_contract_state)&lc_contract_state!=null){
				sql.append("and lc_contract_date=? and lc_contract_state=? limit ?,?");
				objs = new Object[4];
				objs[0] = lc_contract_date;
				objs[1] = lc_contract_state;
				condition.append("lc_contract_date="+lc_contract_date+"&lc_contract_state="+lc_contract_state);
			}else{//合同日期不为为空，合同状态为空
				sql.append("and lc_contract_date=? limit ?,?");
				objs = new Object[3];
				objs[0] = lc_contract_date;
				condition.append("lc_contract_date="+lc_contract_date);
			}
		}else{
			//合同状态不为空
			sql.append("and lc_contract_state=? limit ?,?");
			objs = new Object[3];
			objs[0] = lc_contract_state;
			condition.append("lc_contract_state="+lc_contract_state);
		}
		objs[objs.length-1] = page.getPageSize();
		objs[objs.length-2] = (page.getPageNum()-1)*page.getPageSize();
		rst = contractDao.queryLeaseContractByCondition(sql.toString(), objs);
		try {
			while(rst.next()){
				LeaseContract lease_Contract = new LeaseContract();
				lease_Contract.setLc_id(rst.getInt("lc_id"));
				lease_Contract.setLc_contract_number(rst.getString("lc_contract_number"));
				lease_Contract.setH_estate(rst.getString("h_estate"));
				lease_Contract.setL_name(rst.getString("l_name"));
				lease_Contract.setLc_contract_date(rst.getDate("lc_contract_date").toString());
				lease_Contract.setLc_contract_start_date(rst.getDate("lc_contract_start_date").toString());
				lease_Contract.setLc_contract_end_date(rst.getDate("lc_contract_end_date").toString());
				lease_Contract.setLc_total_rent(rst.getDouble("lc_total_rent"));
				lease_Contract.setLc_pay_way(rst.getInt("lc_pay_way"));
				lease_Contract.setLc_deposit(rst.getDouble("lc_deposit"));
				lease_Contract.setLc_period_payment(rst.getInt("lc_period_payment"));
				lease_Contract.setLc_contract_signer(rst.getString("lc_contract_signer"));
				lease_Contract.setLc_contract_state(String.valueOf(rst.getInt("lc_contract_state")));
				contractList.add(lease_Contract);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contractList;
	}

	@Override
	public String addLeaseContractInformationService(LeaseContract leaseContract) {
		int i = contractDao.addLeaseContractInformation(leaseContract);
		if(i>0){
			return "租赁合同添加成功";
		}
		return "租赁合同添加成功";
	}

	@Override
	public String deleteLeaseContractByIdService(int lc_id) {
		int i = contractDao.deleteLeaseContractById(lc_id);
		if(i>0){
			return "删除成功";
		}
		return "删除失败";
	}

	@Override
	public LeaseContract queryLeaseContractByIdService(int id) {
		rst = contractDao.queryLeaseContractDetailById(id);
		try {
			if(rst.next()){
				contract = new LeaseContract();
				contract.setLc_id(rst.getInt("lc_id"));
				contract.setLc_contract_number(rst.getString("lc_contract_number"));
				contract.setH_id(rst.getInt("flat_id"));
				contract.setL_id(rst.getInt("tenant_id"));
				contract.setLc_contract_date(rst.getDate("lc_contract_date").toString());
				contract.setLc_contract_start_date(rst.getDate("lc_contract_start_date").toString());
				contract.setLc_contract_end_date(rst.getDate("lc_contract_end_date").toString());
				contract.setLc_total_rent(rst.getDouble("lc_total_rent"));
				contract.setLc_pay_way(rst.getInt("lc_pay_way"));
				contract.setLc_deposit(rst.getDouble("lc_deposit"));
				contract.setLc_period_payment(rst.getInt("lc_period_payment"));
				contract.setLc_contract_signer(rst.getString("lc_contract_signer"));
				contract.setLc_contract_state(String.valueOf(rst.getInt("lc_contract_state")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contract;
	}

	@Override
	public String editLeaseContractInformationService(LeaseContract leaseContract) {
		int i = contractDao.updateLeaseContractInformation(leaseContract);
		if(i>0){
			return "数据更新成功";
		}
		return "数据更新失败";
	}

	@Override
	public List<LeaseContract> getUseableInformation() {
		rst = contractDao.queryUserableInformation();
		try {
			while(rst.next()){
				LeaseContract contract = new LeaseContract();
				contract.setH_id(rst.getInt("h_id"));
				contract.setL_id(rst.getInt("l_id"));
				contractList.add(contract);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contractList;
	}

}
