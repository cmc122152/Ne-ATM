package com.feicuiedu.cn.admin;
import java.util.Scanner;

import com.feicuiedu.cn.user.UserLogin;

public class Interface {
	public void Interface() {
		Scanner sc = new Scanner(System.in);
	    System.out.println("欢迎使用中国银行系统");
		System.out.println("1:管理员登录"+"\n"+"2:普通用户登录"+"\n");
		String str1 = sc.nextLine();
		if(str1.equals("1")) {
			AdminLogin login = new AdminLogin();
			login.Login();
		}
		if(str1.equals("2")) {
			UserLogin login = new UserLogin();
			while(true){
				login = login.show();

			}
		}
	
	}
}
