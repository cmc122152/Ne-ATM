package com.feicuiedu.cn.user;
import java.util.Scanner;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Set;
import com.feicuiedu.cn.admin.*;
public class UserLogin {
	Scanner scan = new Scanner(System.in);
	public void userland() {// 用户登录
		while (true) {
			try {
				File file = new File("User" + File.separator + "users.txt");// 创建File对象,获取文本

				if (file.length() == 0) {// 文本为空
					System.out.println("当前无普通用户,请登录管理员用户注册:");// 提示注册
					Interface();
				} else {

					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
					HashMap<String, Object> hashmap = (HashMap<String, Object>) ois.readObject();
					if (hashmap == null || hashmap.isEmpty()) {
						System.out.println("当前无普通用户,请登录管理员用户注册:");// 提示注册
						Interface();
					} else {
						System.out.println("请输入账号或身份证号:");// 账号和身份证号都可以登录
					}
					Set<String> keyset = hashmap.keySet();// 定义set集合,获取HashMap集合的键
					String str = scan.next();

					for (String key : keyset) {// 遍历键
						if (key.startsWith(str) || key.endsWith(str)) {// 判断HashMap中的键是否有以输入的账号开头,或以输入的身份证号结尾的
							Object ob = hashmap.get(key);// 如果有,获取这个键对应的值,赋给ob
							User user = (User) ob;
							String userpassword = user.getPassword();
							while (true) {
								System.out.println("请输入密码(至少8位,数字和字母必须同时有,至少一个大写字母):");
								String password = scan.next();// 输入密码
								if ((userpassword.equals(password))) {// 判断取出的对象是否包含输入的密码
									System.out.println("登录成功");// 如果有,登陆成功
									List list = new List();
									//list.excude(user);// 调用List中的方法时,传入user
								} else {// 没有,重新输入
									System.out.println("密码输入错误,请重新输入:");
								}
							}
						} else {// HashMap中没有键是以输入的账号开头,或以输入的身份证号结尾
							System.out.println("用户不存在");
						}
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	private void Interface() {
		Scanner sc = new Scanner(System.in);
	    System.out.println("欢迎使用中国银行系统");
		System.out.println("1:管理员登录"+"\n"+"2:普通用户登录"+"\n");
		String str1 = sc.nextLine();
		if(str1.equals("1")) {
			AdminLogin login = new AdminLogin();
			login.Login();
		}
		if(str1.equals("2")) {
			AdminLogin login = new AdminLogin();
			while(true){
				login = login.show();

			}
		}
	
		
	}
	public UserLogin show() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
