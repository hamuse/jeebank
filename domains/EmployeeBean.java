package com.bank.domains;

public class EmployeeBean extends MemberBean {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String sabun;

public String getSabun() {
	return sabun;
}

public void setSabun(String sabun) {
	this.sabun = sabun;
}

@Override
public String toString() {
	return "사원정보 [아이디="+ getId()
			+ "비밀번호" + getPw()
			+ "이름" + getName()
			+ "주민등록번호" + getSsn() 
			+ "사번" + sabun + "]";
}
  
}
