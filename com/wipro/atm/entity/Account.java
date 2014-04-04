package com.wipro.atm.entity;

public class Account {
int customerid,depositamount,withdrawalamount;
long balance;
String date;
public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
}
public int getDepositamount() {
	return depositamount;
}
public void setDepositamount(int depositamount) {
	this.depositamount = depositamount;
}
public int getWithdrawalamount() {
	return withdrawalamount;
}
public void setWithdrawalamount(int withdrawalamount) {
	this.withdrawalamount = withdrawalamount;
}
public long getBalance() {
	return balance;
}
public void setBalance(long balance) {
	this.balance = balance;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

}
