package addSql;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.zhiyou.util.DatabaseUtil;

public class AddRect {
	public static void main(String[] args) {
		DatabaseUtil dbUtil = new DatabaseUtil();
		Random ran = new Random();
		String sql = "update rect set r_flag=? where r_id=?";
		for(int i=0;i<100;i++){
			Object[] objs = {0,ran.nextInt(2000)};		
			int j = dbUtil.update(sql, objs);
			System.out.println("�ɹ��޸���"+i+"������");
		}
		/*String[] ramark = {"�µ׽�����","���꽻һ�ط���","�Լ������ס","һ�꽻һ�ط���","����������","��Ѻ��","Ѻ��1000Ԫ","����û�мҾ�","��������","Ѻ��500Ԫ"};
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "insert into rect(flat_id,tenant_id,r_money,r_time,r_remark,r_flag) values(?,?,?,?,?,?)";
		for(int i=0,k=2000;i<2000;i++,k--){
			Object[] objs = {i,k,ran.nextDouble()*1000,sdf.format(new Date()),ramark[ran.nextInt(10)],1};
			int j = dbUtil.update(sql, objs);
			System.out.println("�ɹ����"+j+"����¼");
		}*/
	}
}
