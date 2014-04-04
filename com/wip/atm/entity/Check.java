package com.wipro.atm.entity;

public class Check {
private int	customerid,checkno,branchidofcheck;
private long checkamount;
private String status,customername,checkissuedate;
public String getCheckissuedate() {
	return checkissuedate;
}
public void setCheckissuedate(String checkissuedate) {
	this.checkissuedate = checkissuedate;
}
public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
}
public int getCheckno() {
	return checkno;
}
public void setCheckno(int checkno) {
	this.checkno = checkno;
}
public int getBranchidofcheck() {
	return branchidofcheck;
}
public void setBranchidofcheck(int branchidofcheck) {
	this.branchidofcheck = branchidofcheck;
}
public long getCheckamount() {
	return checkamount;
}
public void setCheckamount(long checkamount) {
	this.checkamount = checkamount;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}

}
