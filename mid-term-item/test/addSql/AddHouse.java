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
			System.out.println("成功修改"+j+"条记录");
		}
		/*Date date = new Date();
		String[] area = {"中原区","经开区","二七区","惠济区","金水区","郑东新区","高新区","航空港区","管城回族区"};//9
		String[] estate = {"锦艺国际华都美域","盛润锦绣城","锦艺国际华都欧尚","锦艺国际华都博郡","香榭丽舍","金源第一城","六厂东街社区","华裕小区","梦园新村西院","金笛小区"};
		String[] unitNumber = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
		int[] floor = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
		String[] roomNo = {"101","102","103","104","105","201","202","203","204","205","301","302","303","304","305","401","402","403","404","405"}; 
		String[] acreage = {"105㎡","81㎡","64㎡","59㎡","168㎡","39㎡","68㎡","30㎡","55㎡","72㎡"};
		String[] direction = {"朝东","朝南","朝西","朝北","朝东南","朝东北","朝西南","朝西北"};
		String[] fitment = {"精装","简装"};
		int[] isDoubleAir = {0,1};
		int[] limit = {2,3,1};
		String[] facility = {"空调","wifi","热水器","空调,wifi,热水器","wifi,热水器","空调,热水器","空调,wifi"};//7
		int[] status = {1,2,3};
		String[] address = {"国棉一厂西六街","国棉一厂西五街","中原新城新天地","帝湖花园莱茵东郡","九龙城龙栖湖畔","金海怡翠苑","长城阳光名郡","正商百合里","开元银榕花园","电信街社区"};//10
		String sql = "insert into house(h_area,h_estate,h_unitNumber,h_floor,h_roomNo,h_acreage,h_direction,h_fitment,h_isDoubleAir,h_limit,h_facility,h_price,h_status,h_address,h_addtime,h_updateTime) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(int i=0;i<1000;i++){
			Object[] objs = {area[ran.nextInt(9)],estate[ran.nextInt(10)],unitNumber[ran.nextInt(15)],floor[ran.nextInt(40)],roomNo[ran.nextInt(20)],acreage[ran.nextInt(10)],direction[ran.nextInt(8)],fitment[ran.nextInt(2)],isDoubleAir[ran.nextInt(2)],limit[ran.nextInt(3)],facility[ran.nextInt(7)],ran.nextDouble()*10000,status[ran.nextInt(3)],address[ran.nextInt(10)],date,date};
			int j = dbUtil.update(sql, objs);
			System.out.println("成功添加"+j+"条记录");
		}*/
	}
}
