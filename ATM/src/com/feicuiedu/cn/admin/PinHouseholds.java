package com.feicuiedu.cn.admin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import com.feicuiedu.cn.user.User;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class PinHouseholds {
	  Scanner scan= new Scanner(System.in);
	  public  void pinhouseholds() {
		  System.out.println("请输入要删除的账户:");
			String account = scan.next();
			System.out.println("请输入身份证号:");
			String cardid = scan.next();
			String str = account + cardid;// 将输入的账号和身份证号组成一个字符串
			try {
				File file = new File("User" + File.separator + "users.txt");// 创建File对象,获取文本
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));// 转为对象流
				HashMap<String, Object> hm = (HashMap<String, Object>) ois.readObject();// 读取文本中的对象
				System.out.println(hm);
				if (hm.containsKey(str)) {// 判断集合hm中的键是否有输入的账号和身份证号组成的键,如果有,继续执行
					 Object obj = hm.get(str);
					while (true) {
						System.out.println("确认删除吗?(1.确认,2.取消)");
						String input = scan.next();
						if (input.equals("1")) {
							hm.remove(str);// 删除
							System.out.println("删除成功!");
							ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
							oos.writeObject(hm);// 将删除之后的集合,重新写入文本
							ois.close();// 关闭流
							break;
						} else if (input.equals("2")) {// 取消删除,退回管理员登录后的界面
							//AdminMenu();
							break;
						} else {
							System.out.println("输入错误请重新输入");
						}
					}

				} else {// hm中不包含输入的账号和身份证号组成的键
					System.out.println("账号不存在,请重新输入");
					pinhouseholds();// 返回方法,重新输入
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

