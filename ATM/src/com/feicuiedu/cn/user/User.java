package com.feicuiedu.cn.user;
import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

public class User  implements Serializable{

	private static final long serialVersionUID = -7381348820433071382L;
	private String account;//卡号
	private String name;//姓名
	private double balance;//余额
	private String password;//密码
	private String sex;//性别
	private String cardid;//身份证号
	private String education;//学历
	private String address;//联系地址
	private String drawdate;//取款时间
	private String operationdate;//存款时间
	private String transferdate;//转账时间
	private double draw;//取款金额
	private double opera;//存款金额
	private double othermoney;//转账金额
	private StringBuffer stb = new StringBuffer();//交易信息
	
	
	public User(String account,String name,double balance,String password,String sex,//用户信息
			String cardid,String education,String address) {
		this.account = account;
		this.name = name;
		this.balance = balance;
		this.password = password;
		this.sex = sex;
		this.cardid = cardid;
		this.education = education;
		this.address = address;
	}
	
	public User(String account,String password,String cardid) {//判断登录时使用
		this.account = account;
		this.password = password;
		this.cardid = cardid;		
	}
	
	public User() {
		
	}

	public String getStb(){
		return stb.toString();
	}
	public void setDraw(double draw){//取款金额
		this.draw = draw;
	}
	public double getDraw(){
		return draw;
	}
	
	public void setOpera(double opera){//存款金额
		this.opera = opera;
	}
	public double getOpera(){
		return opera;
	}
	
	public void setOthermoney(double othermoney){//转账金额
		this.othermoney = othermoney;
	}
	public double getOthermoney(){
		return othermoney;
	}
	
	public void setDrawdate(String drawdate){//取款日期
		this.drawdate=drawdate;
	}
	public String getDrawdate(){
		return drawdate;
	}
	
	public void setOperationdate(String operationdate){//存款日期
		this.operationdate=operationdate;
	}
	public String getOperationdate(){
		return operationdate;
	}

	public void setTransferdate(String transferdate){//转账时间
		this.transferdate = transferdate;
	}
	
	public String getTransferdate(){
		return transferdate;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	public String  getAccount() {//卡号

		return account;
	}
	public void setBalance(double balance){//余额
		this.balance = balance;
	}
	public double getBalance() {

		return balance;
	}
	public void setName(String name) {//用户姓名
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setPassword(String password){//密码
		this.password = password;
	}

	public String getPassword() {

		return password;
	}
	public void setSex(String sex) {//性别
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	public void setCardid(String cardid) {//身份证
		this.cardid = cardid;
	}
	public String getCardid() {
		return cardid;
	}
	public void setEducation(String education) {//学历
		this.education = education;
	}
	public String getEducation() {
		return education;
	}
	public void setAddress(String address) {//联系地址
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void record(String date,String record,double amount){
		stb.append(date);
		stb.append(" ");
		stb.append(record);
		stb.append(" ");
		stb.append(amount);
		
	}
	public List getRecode() {
		
		return null;
	}
	public void setRecode(List list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean equals(Object arg0) {//输入的账户是否存在
		return account.equals(((User)arg0).account);
	}
	@Override
	public String toString() {
		return String.join(",", "卡号"+account,"\n"+"姓名"+name,"\n"+"余额"+""+balance,"\n"+"密码"+password,"\n"+"性别(1代表男，2代表女)"+sex,//用户信息
			"\n"+"身份证"+cardid,"\n"+"学历(1代表  小学  2代表 中学  3代表大学 4代表其他):"+education,"\n"+"地址:"+address+"\n"+"交易记录"+getStb()+"\n");
	}

	public ArrayList<User> UserI() {
		
		return null;
	}

	public void deleteuser(User user) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}