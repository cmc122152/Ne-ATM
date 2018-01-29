package com.feicuiedu.cn.admin;
import com.feicuiedu.cn.user.User;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OpenAccount implements Serializable {
	    
		private  OpenAccount user = null;
		private String password = null;
		private String cardid = null;
		private String name=null;
		private String education = null;
		private String address = null;
		private String gender = null;
	  Scanner scan = new Scanner(System.in);
	  public void openaccountUser() {
			System.out.println("请输入客户姓名");
			String str1 = scan.nextLine();
			if(str1.length()<=10) {
			 // user.setName();
			  
			}else {
				System.out.println("用户姓名不能超过10位");
				//setName();	
			
				}
			while (true) {
				System.out.println("请输入性别(1.男     2.女)(请保证输入的正确,之后无法修改)");
				String input = scan.next();
				if (input.equals("1")) {
					gender = "01";
					break;
				} else if (input.equals("2")) {
					gender = "02";
					break;
				} else {
					System.out.println("输入有误请重新输入:");

				}
	       }
			while (true) {
				System.out.println("请输入身份证号(18位)(请务必输入正确,之后无法修改):");
				cardid = scan.next();// 输入的身份证号
				if (!cardid.matches("([0-9]{1,18})")) {// 判断是否符合正则表达式,不符合重新输入
					System.out.println("身份证号输入错误,应为18位数字,请重新输入:");
				} else {
					break;
				}
	      }
			double balance = 0.0;// 直接初始化余额为0.0
			while (true) {
				System.out.println("请输入初始密码(至少8位,数字和字母必须同时又,至少一个大写字母):");
				password = scan.next();
				if (!password.matches("(?![0-9A-Z]+$)(?![0-9a-z]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,}$")) {// 不符合正则表达式,
					System.out.println("密码输入错误,请重新输入");// 重新输入
				} else {
					break;// 符合,跳出
				}
	}
			while (true) {
				System.out.println("请输入学历(1.小学,2.中学,3.大学,4.其他):");// 1代表 小数 2代表 中学
																	// 3代表大学 4代表其他
				String input = scan.next();
				if (input.equals("1")) {// 根据所选学历的不同,将对应值赋给education
					education = "小学";
					break;
				} else if (input.equals("2")) {
					education = "中学";
					break;
				} else if (input.equals("3")) {
					education = "大学";
					break;
				} else if (input.equals("4")) {
					education = "其他";
					break;
				} else {
					System.out.println("输入错误,请重新输入");
				}
	      }
			while (true) {
				System.out.println("请输入家庭住址:");
				address = scan.next();
				if (address.length() > 50) {// 判断输入的长度是否大于50
					System.out.println("地址长度不能大于50,请重新输入");
					address = scan.next();
				} else {
					break;
				}
			}
	  
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");//设置日期格式
			String str = df.format(date);
			String account = "37" + gender + str ;	
			User user = new User(account,name, balance, gender, cardid, education, address, password);
			System.out.println("37" + gender + str);
			System.out.println("开户成功");
	  }
	
	
	  	
}
