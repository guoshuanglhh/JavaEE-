package addSql;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.zhiyou.util.DatabaseUtil;

public class AddLeaseContract {
	public static void main(String[] args) {
		DatabaseUtil dbUtil = new DatabaseUtil();
		Random ran = new Random();
		String sql = "update leasecontract set tenant_id=? where lc_id=?";
		for(int i=0;i<150;i++){
			Object[] objs = {i};
			dbUtil.update(sql, objs);
			System.out.println("�ɹ��޸�"+i+"����Ϣ");
		}
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] lc_contract_signer = {"�ż�Ω","�ֹ���","������","������","������","���غ�","���","���ӷ�","��־��","���㶨",
									 "����¡","л����","������","����ϼ","������","���˿�","����ӯ","��һǿ","��ܿ��","֣����",
									 "��֦ӯ","�߳���","�����","���ѩ","����Τ","����ع","������","������","���˺�","����",
									 "�²�ޱ","������","��ΰ��","���Ż�","���Ӻ�","������","�κ�","������","����","����Ԫ"
									};
		int[] lc_contract_state = {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1};
		String sql = "insert into leasecontract(lc_contract_number,flat_id,tenant_id,lc_contract_date,lc_contract_start_date,lc_contract_end_date,lc_total_rent,lc_pay_way,lc_deposit,lc_period_payment,lc_contract_signer,lc_contract_state,lc_flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(int i=1,j=2000;i<=2000;i++){
			Object[] objs = {ran.nextInt(99999999),i,j,sdf.format(new Date()),sdf.format(new Date()),sdf.format(new Date()),ran.nextDouble()*10000,ran.nextInt(4),ran.nextDouble()*1000+200,ran.nextInt(5),lc_contract_signer[ran.nextInt(40)],lc_contract_state[ran.nextInt(15)],1};
			dbUtil.update(sql, objs);
			System.out.println("�ɹ����"+i+"����Ϣ");
		}*/
	}
}
