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
		return "회원정보 [id=" + getId()
				+ "비밀번호=" + getPw()
				+ "이름=" + getName()
				+ "주빈번호=" +getSsn()
				+ "신용도=" + credit + "]";
	}
	
}
