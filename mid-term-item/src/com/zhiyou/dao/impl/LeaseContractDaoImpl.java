package com.zhiyou.dao.impl;

import java.sql.ResultSet;

import com.zhiyou.dao.LeaseContractDao;
import com.zhiyou.pojo.LeaseContract;
import com.zhiyou.util.DatabaseUtil;

public class LeaseContractDaoImpl implements LeaseContractDao{
	//定义数据库连接的工具类
	private DatabaseUtil dbUtil = new DatabaseUtil();
	
	@Override
	public ResultSet queryLeaseContractCountById(String sql, Object[] objs) {
		return dbUtil.query(sql, objs);
	}

	@Override
	public ResultSet queryLeaseContractByCondition(String sql, Object[] objs) {
		return dbUtil.query(sql, objs);
	}

	@Override
	public int addLeaseContractInformation(LeaseContract leaseContract) {
		String lc_contract_number = leaseContract.getLc_contract_number();
		int flat_id = leaseContract.getH_id();
		int tenant_id = leaseContract.getL_id();
		String lc_contract_date = leaseContract.getLc_contract_date();
		String lc_contract_start_date = leaseContract.getLc_contract_start_date();
		String lc_contract_end_date = leaseContract.getLc_contract_end_date();
		double lc_total_rent = leaseContract.getLc_total_rent();
		int lc_pay_way = leaseContract.getLc_pay_way();
		double lc_deposit = leaseContract.getLc_deposit();
		int lc_period_payment = leaseContract.getLc_period_payment();
		String lc_contract_signer = leaseContract.getLc_contract_signer();
		int lc_contract_state = Integer.parseInt(leaseContract.getLc_contract_state());
		String sql = "insert into leasecontract(lc_contract_number,flat_id,tenant_id,lc_contract_date,lc_contract_start_date,lc_contract_end_date,lc_total_rent,lc_pay_way,lc_deposit,lc_period_payment,lc_contract_signer,lc_contract_state,lc_flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] objs = {lc_contract_number,flat_id,tenant_id,lc_contract_date,lc_contract_start_date,lc_contract_end_date,lc_total_rent,lc_pay_way,lc_deposit,lc_period_payment,lc_contract_signer,lc_contract_state,1};
		return dbUtil.update(sql, objs);
	}

	@Override
	public int deleteLeaseContractById(int lc_id) {
		String sql1 = "update leaseContract set lc_flag=0 where lc_id=?";
		Object[] objs1 = {lc_id};
		return dbUtil.update(sql1, objs1);
	}

	@Override
	public ResultSet queryLeaseContractDetailById(int id) {
		String sql = "select * from leasecontract where lc_id=?";
		Object[] objs = {id};
		return dbUtil.query(sql, objs);
	}

	@Override
	public int updateLeaseContractInformation(LeaseContract leaseContract) {
		int lc_id = leaseContract.getLc_id();
		String lc_contract_number = leaseContract.getLc_contract_number();
		int flat_id = leaseContract.getH_id();
		int tenant_id = leaseContract.getL_id();
		String lc_contract_date = leaseContract.getLc_contract_date();
		String lc_contract_start_date = leaseContract.getLc_contract_start_date();
		String lc_contract_end_date = leaseContract.getLc_contract_end_date();
		double lc_total_rent = leaseContract.getLc_total_rent();
		int lc_pay_way = leaseContract.getLc_pay_way();
		double lc_deposit = leaseContract.getLc_deposit();
		int lc_period_payment = leaseContract.getLc_period_payment();
		String lc_contract_signer = leaseContract.getLc_contract_signer();
		int lc_contract_state = Integer.parseInt(leaseContract.getLc_contract_state());
		String sql = "update leasecontract set lc_contract_number=?,flat_id=?,tenant_id=?,lc_contract_date=?,lc_contract_start_date=?,lc_contract_end_date=?,lc_total_rent=?,lc_pay_way=?,lc_deposit=?,lc_period_payment=?,lc_contract_signer=?,lc_contract_state=? where lc_id=?";
		Object[] objs = {lc_contract_number,flat_id,tenant_id,lc_contract_date,lc_contract_start_date,lc_contract_end_date,lc_total_rent,lc_pay_way,lc_deposit,lc_period_payment,lc_contract_signer,lc_contract_state,lc_id};
		return dbUtil.update(sql, objs);
	}

	@Override
	public ResultSet queryUserableInformation() {
		String sql = "select h_id,l_id from leasecontract,house,lessee where flat_id=h_id and tenant_id=lessee.l_id and l_flag=1 and h_flag=1 and lc_flag=1 and h_status=2";
		Object[] objs = {};
		return dbUtil.query(sql, objs);
	}

}
