package com.feicuiedu.cn.admin;
import java.util.Scanner;
public class AdminMenu {
	Scanner sc = new Scanner(System.in);
	public void AdminMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1:开户"+"2:销户"+"3:查询客户信息"+"4:修改客户信息"+"5:退出");
		String str = scanner.nextLine();
		if(str.equals("1")) {
			OpenAccount atm = new OpenAccount();
			atm.openaccountUser();			
		}
		if(str.equals("2")) {
			PinHouseholds ps = new PinHouseholds();
			ps.pinhouseholds();
		}
		if(str.equals("3")) {
			Users users = new Users();
			Object object = users.UserI();
			System.out.println(object);	
			System.out.println("1:确认并返回主菜单");
			String num = sc.nextLine();
			if(num.equals("1")) {					
				AdminMenu();
			}
		}
		if(str.equals("4")) {
			Amend amend = new Amend();
			amend.amend();
		}
		if(str.equals("5")) {
			
		}
}
}
