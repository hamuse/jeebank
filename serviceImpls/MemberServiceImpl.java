package com.bank.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import com.bank.domains.CustomerBean;
import com.bank.domains.EmployeeBean;
import com.bank.domains.MemberBean;
import com.bank.services.MemberService;

public class MemberServiceImpl implements MemberService{
	private List<CustomerBean> customers;
	private List<EmployeeBean> employees;
	public MemberServiceImpl() {
		customers = new ArrayList<>();
		employees = new ArrayList<>();
	}
	
	@Override
	public void join(CustomerBean param) {
		customers.add(param);
	}
	
	@Override
	public void register(EmployeeBean param) {
		employees.add(param);
		
	}
	
	@Override
	public List<CustomerBean> findAllCustomers() {
		return customers;
	}
	
	@Override
	public List<EmployeeBean> findAllAdmins() {
		return employees;
	}



	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> beans = new ArrayList<>();
		int count =0;
		for( CustomerBean cust : customers) {
			if(name.equals(cust.getName())) {
				count++;
				beans.add(cust);
				break;
			}
		}
		for(EmployeeBean emp : employees) {
			if(name.equals(emp.getName())) {
				count++;
				beans.add(emp);
				break;
			}
		}
		int j = 0;
		for( CustomerBean cust : customers) {
			if(name.equals(cust.getName())) {
				beans.add(cust);
				j++;
				if(j == count) {
					return beans;
				}
			
			}
		}
		for(EmployeeBean emp : employees) {
			if(name.equals(emp.getName())) {
				beans.add(emp);
			   j++;
			   if(j == count) {
					break;
			   }
				
			
			}
		}
		return beans;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean m = new MemberBean();
		for(CustomerBean c : customers) {
			if(id.equals(c.getId())) {
				m = c;
				return m;
			}
		}
		for(EmployeeBean e : employees) {
			if(id.equals(e.getId())) {
				m = e;
				break;
			}
		}
		return null;
	}

	@Override
	public boolean login(MemberBean param) {
		MemberBean bean =   findById(param.getId());
		boolean flag = false;
		for( CustomerBean cust : customers) {
			if(bean.equals(cust.getName())) {
				flag = true;
				break;
			}
		}
		for(EmployeeBean emp : employees) {
			if(bean.equals(emp.getName())) {
				flag = true;
				
			}
		}
		return flag;
	}

	@Override
	public int countCustomers() {
		return customers.size();
	}

	@Override
	public int countAdmins() {
		
		return employees.size();
	}

	@Override
	public boolean existId(String id) {
		
		MemberBean bn = findById(id);
		return employees.contains(bn) || customers.contains(bn);
	}
	

	@Override
	public void updatePass(MemberBean param) {
		String id = param.getId();
		String oldPw = param.getPw().split(",")[0];
		String newPw = param.getPw().split(",")[1];
		MemberBean m = findById(id);
		if(m.getPw().equals(oldPw)) {
			int idx = (employees.contains(m))?
					employees.indexOf(m)
					:customers.indexOf(m);
					if(employees.contains(m)) {
						employees.get(idx).setPw(newPw);
					}else {
						customers.get(idx).setPw(newPw);
					}
		}

		
		}


	@Override
	public boolean deleteMember(MemberBean param) {
		MemberBean m = findById(param.getId());
		return (employees.contains(m))
				? employees.remove(m)
						: customers.remove(m);


	}
}






