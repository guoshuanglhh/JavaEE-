package addSql;

import java.util.Date;
import java.util.Random;

import com.zhiyou.util.DatabaseUtil;

public class AddHouse {
	public static void main(String[] args) {
		DatabaseUtil dbUtil = new DatabaseUtil();
		Random ran = new Random();
		String sql = "update house set h_price=? where h_id=?";
		for(int i=0;i<2000;i++){
			Object[] objs = {ran.nextDouble()*1000,i};
			int j = dbUtil.update(sql, objs);
			System.out.println("�ɹ��޸�"+j+"����¼");
		}
		/*Date date = new Date();
		String[] area = {"��ԭ��","������","������","�ݼ���","��ˮ��","֣������","������","���ո���","�ܳǻ�����"};//9
		String[] estate = {"���չ��ʻ�������","ʢ������","���չ��ʻ���ŷ��","���չ��ʻ�������","�������","��Դ��һ��","������������","��ԣС��","��԰�´���Ժ","���С��"};
		String[] unitNumber = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
		int[] floor = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
		String[] roomNo = {"101","102","103","104","105","201","202","203","204","205","301","302","303","304","305","401","402","403","404","405"}; 
		String[] acreage = {"105�O","81�O","64�O","59�O","168�O","39�O","68�O","30�O","55�O","72�O"};
		String[] direction = {"����","����","����","����","������","������","������","������"};
		String[] fitment = {"��װ","��װ"};
		int[] isDoubleAir = {0,1};
		int[] limit = {2,3,1};
		String[] facility = {"�յ�","wifi","��ˮ��","�յ�,wifi,��ˮ��","wifi,��ˮ��","�յ�,��ˮ��","�յ�,wifi"};//7
		int[] status = {1,2,3};
		String[] address = {"����һ��������","����һ�������","��ԭ�³������","�ۺ���԰���𶫿�","���������ܺ���","������Է","������������","���̰ٺ���","��Ԫ���Ż�԰","���Ž�����"};//10
		String sql = "insert into house(h_area,h_estate,h_unitNumber,h_floor,h_roomNo,h_acreage,h_direction,h_fitment,h_isDoubleAir,h_limit,h_facility,h_price,h_status,h_address,h_addtime,h_updateTime) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(int i=0;i<1000;i++){
			Object[] objs = {area[ran.nextInt(9)],estate[ran.nextInt(10)],unitNumber[ran.nextInt(15)],floor[ran.nextInt(40)],roomNo[ran.nextInt(20)],acreage[ran.nextInt(10)],direction[ran.nextInt(8)],fitment[ran.nextInt(2)],isDoubleAir[ran.nextInt(2)],limit[ran.nextInt(3)],facility[ran.nextInt(7)],ran.nextDouble()*10000,status[ran.nextInt(3)],address[ran.nextInt(10)],date,date};
			int j = dbUtil.update(sql, objs);
			System.out.println("�ɹ����"+j+"����¼");
		}*/
	}
}
