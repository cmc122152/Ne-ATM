package com.feicuiedu.cn.admin;//生成文件并存储
import com.feicuiedu.cn.user.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Users {
	private ArrayList<User> list = new ArrayList<>();//创建文件
	File file = new File("user" + File.separator + "G:\\AWord\\2017-12-29\\workspace\\ATM\\users.txt");
	public Users() {		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}

	public boolean addUser(User user) {//添加数据
		list = UserI();
		list.add(user);
		FileOutputStream fis = null;
		ObjectOutputStream ois = null;
		try {
			fis = new FileOutputStream(file);
			ois = new ObjectOutputStream(fis);
			ois.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}
	public boolean deleteuser(User user) {//删除客户信息
		list = UserI();
		list.remove(user);
		FileOutputStream fis = null;
		ObjectOutputStream ois = null;
		try {
			fis = new FileOutputStream(file);
			ois = new ObjectOutputStream(fis);
			ois.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}
	
	public boolean amenduser(User user) {
		list = UserI();
		if(!list.contains(user)) {
			return false;
		}
		int i = list.indexOf(user);
		list.set(i, user);
		FileOutputStream fis = null;
		ObjectOutputStream ois = null;
		try {
			fis = new FileOutputStream(file);
			ois = new ObjectOutputStream(fis);
			ois.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}
	public User getUserByAccount(String account) {
		User temp = new User(account, null, null);
		list = UserI();
		if(!list.contains(temp)) {
			return null;
		}
		int i = list.indexOf(temp);
		return list.get(i);
		
	}
	
	
	public ArrayList<User> UserI() {//读取文件
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			return (ArrayList<User>) ois.readObject();
			
		} catch (IOException e) {
			ExceptionUtil.printException(e);
		}catch(ClassNotFoundException e) {
			ExceptionUtil.printException(e);
		}
		return new ArrayList<>();
	}

	public void modify(User user) {
		
		
	}
}