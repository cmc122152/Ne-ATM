package com.feicuiedu.cn.admin;//管理员登录
import java.util.Scanner;
public class AdminLogin {
	private String adminuser = "370120180104";
	private String adminpassword = "123456";
	private String username = "翡翠";
	public void AdminRegister() {		
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("请输入账号:");

			String Account = sc.nextLine();
			if(adminuser.equals(Account)){
				break;
			}else {
				System.out.println("账号错误");
			}
		}
		while(true){
			System.out.println("请输入密码");
			String Password = sc.nextLine();
			if(adminpassword.equals(Password)){
				break;
			}else {
				System.out.println("密码错误");
			}
		}
		AdminMenu adm = new AdminMenu();
		adm.AdminMenu();
		
	}
	public void Login() {
		
	}
	public AdminLogin show() {
		return null;
		
	}
}

