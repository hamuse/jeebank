package com.bank.domains;

public class CustomerBean extends MemberBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String credit;

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "ȸ������ [id=" + getId()
				+ "��й�ȣ=" + getPw()
				+ "�̸�=" + getName()
				+ "�ֺ��ȣ=" +getSsn()
				+ "�ſ뵵=" + credit + "]";
	}
	
}
