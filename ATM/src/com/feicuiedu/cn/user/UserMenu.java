package com.feicuiedu.cn.user;

import java.util.Scanner;

public class UserMenu {
	public void execute(User user) {
    	
		System.out.println("欢迎使用中国银行系统");
		System.out.println("1.查询 2.转账 3.取款 4.存款 5.退卡");
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("请输入您要进行的操作");
			String input = scan.next();// 输入得要操作的值,选择对应方法
			MoneyBusiness monbu = new MoneyBusiness();// 先定义对象,下面要用
			/*if (input.equals("1")) {// 查询
				QueryUser query = new QueryUser();
				query.queryuser(user);*/
				
				/*while (true) {
					String input2 = scan.next();
					System.out.println("(1.返回上一级)");*/
					// 如果输入的为1
					if (input.equals("1")) {
					monbu.queryuser(user);
					break;
			} else if (input.equals("2")) {
				monbu.transBusiness(user);// 转账
			} else if (input.equals("3")) {
				monbu.withdrawal(user);// 取款
			} else if (input.equals("4")) {
				monbu.deposit(user);// 存款
			} else if (input.equals("5")) {				
				break;// 退出
			} else {
				System.out.println("您的输入不正确,请重新输入");
			}
}
	}


}
