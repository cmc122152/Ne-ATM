package com.feicuiedu.cn.admin;
import java.util.Scanner;
import com.feicuiedu.cn.user.User;
public class Amend {
	Scanner scanner = new Scanner(System.in);
	Users users = new Users();
	public void amend() {
		System.out.println("请输入要修改的账户");
		String str = scanner.nextLine();		
		User user = users.getUserByAccount(str);
		if(user==null) {
			System.out.println("没有此帐号,请重新输入");
			amend();
		}
		importAccount(user);
		
		users.amenduser(user);
		submenu(user);
	}

	public void submenu(User user) {
		System.out.println("1:确认并返回上一级");
		System.out.println("2:确认并返回主菜单");
		String num = scanner.nextLine();
		if(num.equals("1")) {
			importAccount(user);
		}
		if(num.equals("2")) {
			AdminMenu adminMenu = new AdminMenu();
			adminMenu.AdminMenu();
		}
	}

	public void importAccount(User user) {
		System.out.println("请输入要修改的项目:" + "\n" + 
						"1:姓名" + "\n" + 
						"2:密码" + "\n" + 
						"3:学历" + "\n" + 
						"4:联系地址" + "\n" + 
						"5:返回主菜单");
		String str1 = scanner.nextLine();
		if (str1.equals("1")) {
			System.out.println("请输入要修改的姓名");
			String str2 = scanner.nextLine();
			user.setName(str2);

		}
		if (str1.equals("2")) {
			System.out.println("请输入要修改的密码");
			String str3 = scanner.nextLine();
			user.setPassword(str3);
		}
		if (str1.equals("3")) {
			System.out.println("请输入要修改的学历");
			String str4 = scanner.nextLine();
			user.setEducation(str4);
		}
		if (str1.equals("4")) {
			System.out.println("请输入要修改的联系地址");
			String str5 = scanner.nextLine();
			user.setAddress(str5);
		}
		if (str1.equals("5")) {
			AdminMenu adminMenu = new AdminMenu();
			adminMenu.AdminMenu();
		}
	}

	public void amend1() {
	
	}
}
