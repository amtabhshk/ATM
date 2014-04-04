package com.wipro.atm.entity;

import javax.swing.JOptionPane;

import com.wipro.atm.dao.AccountDao;
import com.wipro.atm.dao.CheckDao;
import com.wipro.atm.dao.CustomerDao;
import com.wipro.atm.ui.CustomerFrame;
import com.wipro.atm.ui.JgenerateMiniStatementFrame;
import com.wipro.atm.util.Transaction;

public class Customer {
	
	long CardNo,accountnumber;
	String fullname,fathersname,dob,gender,permanentaddress,presentaddress,pannumber,accounttype,checkbook;
	int mobnumber,landline,customerid,pin,openingbalance,branchid,withdrawalamount;
	public int getWithdrawalamount() {
		return withdrawalamount;
	}
	public void setWithdrawalamount(int withdrawalamount) {
		this.withdrawalamount = withdrawalamount;
	}
	public long getCardNo() {
		return CardNo;
	}
	public void setCardNo(long cardNo) {
		CardNo = cardNo;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getFathersname() {
		return fathersname;
	}
	public void setFathersname(String fathersname) {
		this.fathersname = fathersname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPermanentaddress() {
		return permanentaddress;
	}
	public void setPermanentaddress(String permanentaddress) {
		this.permanentaddress = permanentaddress;
	}
	public String getPresentaddress() {
		return presentaddress;
	}
	public void setPresentaddress(String presentaddress) {
		this.presentaddress = presentaddress;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public String getCheckbook() {
		return checkbook;
	}
	public void setCheckbook(String checkbook) {
		this.checkbook = checkbook;
	}
	public int getMobnumber() {
		return mobnumber;
	}
	public void setMobnumber(int mobnumber) {
		this.mobnumber = mobnumber;
	}
	public int getLandline() {
		return landline;
	}
	public void setLandline(int landline) {
		this.landline = landline;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getOpeningbalance() {
		return openingbalance;
	}
	public void setOpeningbalance(int openingbalance) {
		this.openingbalance = openingbalance;
	}
	public int getBranchid() {
		return branchid;
	}
	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}
	
	public boolean changePin(long cardno,String oldpin,String newpin) throws Exception
	{
		int cardno1=(int)cardno;
		boolean success=new User().changePassword(cardno1, oldpin, newpin);
		return success;
	}
	public void withdrawcash(Transaction tob) throws Exception
	{
		new AccountDao().removeCredit(tob);
	}

	public void depoditCheckByCash(Check chob) throws Exception
	{
		String[] cusdetail=new CustomerDao().findByCustomerId(chob.getCustomerid());
		chob.setCustomername(cusdetail[1]);
		new CheckDao().createCheck(chob);
	}
	public void viewbalance(int cid) throws Exception
	{
		long acbal=new AccountDao().getBalance(cid);
		JOptionPane.showMessageDialog(CustomerFrame.customerframe,"Your Balance is Rs: "+acbal);
	}
	public void generateMiniStatement(int cid) throws Exception
	{
		String jministatement[][]=new AccountDao().getMiniStatement(cid);
		new JgenerateMiniStatementFrame(jministatement);
	}

}
