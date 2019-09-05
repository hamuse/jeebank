package www.bank.web.daoimpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.bank.domains.CustomerBean;
import com.bank.domains.EmployeeBean;
import com.bank.services.MemberService;
import com.bank.web.daos.MemberDAO;
import com.bank.web.pool.Constants;

@SuppressWarnings("unused")
public class MemberDAOImpl implements MemberDAO {
	public static final String FILE_PATH= String.format("C:%sUsers%suser%seclipse-jee%sjee.bank%sWebContent%sresources%stxt%s",
			//C:%sUsers%suser%seclipse-jee%sjee-grade%sWebContent%sresources%stxt
File.separator,
File.separator,
File.separator,
File.separator,
File.separator,
File.separator,
File.separator,
File.separator); 
	@Override
	public void insertCustomer(CustomerBean param) {
		System.out.println("insertCustomer");
		try {
			File file = new File(Constants.FILE_PATH+"customers0905.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(String.format("%s , %s , %s ,%s, %s" ,param.getId(),param.getPw(),param.getSsn(),param.getName(),param.getCredit()
			));
			writer.newLine();
			writer.flush();
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void insertEmplotee(EmployeeBean param) {
		try {
			
		}catch(Exception e){
			
		}		
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		CustomerBean cb = new CustomerBean();
		System.out.println("디아이오 시작지점"+cb.toString());
		try{
			String id = param.getId();
			String pw = param.getPw();
//			String ssn = param.getSsn();
//			String name = param.getName();
//			String credit = param.getCredit();
			
	   File file = new File(Constants.FILE_PATH+"customers0905.txt");
			if(file.exists()) {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String st = "";
			String[] arr = new String[5];
			while((st = br.readLine()) != null) {
				System.out.println(st);
				arr =st.split(",");
				System.out.printf("디아이오 %s,%s",id,pw);
				System.out.println(arr[0]+arr[1]);
				if(id.equals(arr[0].trim()) & pw.equals(arr[1].trim())) {
					System.out.println("디아이오 이프 안");
					param.setId(arr[0]);
					param.setPw(arr[1]);
					param.setSsn(arr[2]);
					param.setName(arr[3]);
					param.setCredit(arr[4]);
					break;
				}else {
					param.setId("");
					param.setPw("");
				
				}
				
				
				
			}
			br.close();
			}
			
		}catch(Exception e) {
			
		}
		System.out.println("디에이오"+cb.toString());
		return param;
	}

}
