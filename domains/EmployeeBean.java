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
	return "������� [���̵�="+ getId()
			+ "��й�ȣ" + getPw()
			+ "�̸�" + getName()
			+ "�ֹε�Ϲ�ȣ" + getSsn() 
			+ "���" + sabun + "]";
}
  
}
