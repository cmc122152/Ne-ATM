package com.feicuiedu.cn.user;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.feicuiedu.cn.admin.Users;
public class MoneyBusiness {
	   Scanner scan=new Scanner(System.in);
	 //转账
	@SuppressWarnings({ "unchecked", "resource" })
	public void transBusiness(User user) {
		while (true) {
			System.out.println("请输入对方账号:");
			String otheraccount = scan.next();// 接受输入的对方账户
			File file = new File("User" + File.separator +"G:\\AWord\\2017-12-29\\workspace\\ATM\\users.txt");// 获取文本
			try {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				HashMap<String, Object> hm = (HashMap<String, Object>) ois.readObject();// 将文本信息读成集合
				Set<String> keyset = hm.keySet();// 获取集合中的键

				for (String key : keyset) {// 遍历键
					Object obj = hm.get(key);// 如果有,以此键取出对应的值
					User tuser = (User) obj;// 获取被转账用户
					String taccount = tuser.getAccount();
					if (taccount.equals(otheraccount)) {// 判断键有没有以输入的账号开头的
						while (true) {
							System.out.println("请输入转账金额:");
							double tamount = scan.nextDouble();// 获取输入的转账金额
							if (tamount < 0 | tamount % 100 != 0) {// 判断是否小于0或者不是100的倍数
								System.out.println("金额必须大于0且是100的整数倍,请重新输入");
							} else if (tamount > user.getBalance()) {// 判断输入的金额是否大于当前账户余额
								System.out.println("余额不足,请重新输入:");// 如果大于,重新输入
							} else {// 输入的金额符合
								System.out.println("转账成功!");
								user.setBalance(user.getBalance() - tamount);// 当前用户余额减去转账金额
								tuser.setBalance(tuser.getBalance() + tamount);// 对方账户余额加上转账金额
								String flow = "给" + otheraccount + "转了" + tamount + "元";
								record(user, flow);				
								break;
							}

						}
						System.out.println("1.继续转账    2.返回上一级");
						String str = scan.next();
						if (str.equals("1")) {
							transBusiness(user);
						} else {
							UserMenu um = new UserMenu();
							um.execute(user);
						}
					} else {
						System.out.println("无用户");
					}
				}

			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
}
		
	}
    
	
	//取款
	@SuppressWarnings("unused")
	public void withdrawal(User user) {
		boolean bln = false;
		while (true) {
			System.out.println("请输入取款金额:");
			double amount = scan.nextDouble();// 获取取出的金额
			if (amount < 0 | amount % 100 != 0) {// 判断输入的是否符合规则
				System.out.println("金额必须大于0且是100的整数倍,请重新输入");
				bln = true;
			} else if (amount > user.getBalance()) {// 符合规则,再看是否小于当前用户的当前余额
				System.out.println("余额不足,请重新输入:");// 比余额大
				bln = true;
			} else {// 都符合
				double balance = user.getBalance();// 获取当前用户的当前金额
				user.setBalance(balance - amount);// 当前用户的余额减去取出的金额
				System.out.println("取款成功,当前余额为:" + user.getBalance());// 获取当前用户当前余额
				String flow = "您取出了" + balance + "元";
				record(user, flow);
				while (true) {
					System.out.println("1.继续取款           2.退出");
					String input = scan.next();
					if (input.equals("1")) {// 判断取款之后的操作
						break;

					} else if (input.equals("2")) {
						Users users=new Users();
						users.modify(user);
						UserMenu um = new UserMenu();
						um.execute(user);// 返回菜单界面
					} else {
						System.out.println("输入错误,请重新输入!");
					}
				}
			}
}
	}
    //存款
	@SuppressWarnings("unused")
	public void deposit(User user) {
		boolean bln = false;
		while (true) {
			System.out.println("请输入存款金额");
			double balance = scan.nextDouble();// 获取输入的存款金额
			System.out.println("1.确认      2.重新输入");
			String input = scan.next();
			if (input.equals("1")) {// 输入的为1,确认存款
				if (balance > 0 & balance % 100 == 0) {// 判断输入的金额是否符合规则
					double initialbalance = user.getBalance();// 符合,获取当前用户的余额
					user.setBalance(initialbalance + balance);// 当前用户余额加上存入的金额
					System.out.println("存入成功,当前余额为:" + user.getBalance());// 显示当前余额
					String flow = "您存入了" + balance + "元";
					record(user, flow);
					System.out.println("1.继续存款           2.退出");
					while (true) {
						String input2 = scan.next();// 判断接下来的操作
						if (input2.equals("1")) {// 继续存款
							deposit(user);// 调用自己
						} else if (input2.equals("2")) {
							Users users=new Users();
							users.modify(user);
							UserMenu um = new UserMenu();
							um.execute(user);// 返回菜单界面
						} else {
							System.out.println("输入错误,请重新输入:");
						}
					}
				} else {
					System.out.println("存入的金额必须大于0,并且只能是100的整数倍");
				}
			} else if (input.equals("2")) {// 如果是重新输入,调用方法,从头开始
				bln = true;
			} else {
				bln = true;
			}
}
	}
  public String  queryuser(User user) {
	 return "User [账号=" + user.getAccount() + ", 密码=" + user.getPassword() + ", 用户名=" + user.getName()
	+ ", 性别=" + user.getSex() + ", 身份证号=" + user.getCardid() + ", 学历=" + user.getEducation() + ", 余额=" + user.getBalance() + ", 地址="
	+ user.getAddress() + "]";
		
	}
	//记录
	private void record(User user, String flow) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");// 操作执行的时间
		List list = user.getRecode();// 得到list记录属性
		Date date=new Date();
		String time = sdf.format(date);

		list.add(flow + time);
		user.setRecode(list);

	}

	


}
