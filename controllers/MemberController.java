package com.bank.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.domains.CustomerBean;
import com.bank.serviceImpls.MemberServiceImpl;
import com.bank.services.MemberService;
import com.bank.web.pool.Constants;


@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String action = request.getParameter("action");
		//String dest = requeset.getParameter("dest");
		CustomerBean param =new CustomerBean();
		MemberService service = new MemberServiceImpl();
		System.out.println(request.getParameter("action")+"asdfasdfasfsdf");

		switch(request.getParameter("action")) {
		case"move":
			request.getParameter("dest");
			request.getRequestDispatcher
			(String.format(Constants.VIEW_PATH,"customer", request.getParameter("dest"))).forward(request, response);

			break;
		case "join":
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String credit = request.getParameter("credit");

			param.setCredit(credit);
			param.setId(id);
			param.setName(name);
			param.setPw(pw);
			param.setSsn(ssn);
			System.out.println("컨트롤러 조인"+param.toString());
			service.join(param);
			System.out.println("컨트롤러 조인gn"+param.toString());
			//				request.getParameter("action");
			request.getRequestDispatcher
			(String.format(Constants.VIEW_PATH,"customer", request.getParameter("dest"))).forward(request, response);

			break;

		case "login":
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			System.out.printf("로그인서비스 진입 후 %s, %s",id,pw);
			param = new CustomerBean();
			param.setId(id);
			param.setPw(pw);
			service = new MemberServiceImpl();
			CustomerBean cust = new CustomerBean();
			cust = service.login(param);
			System.out.println("로그 cust"+cust.toString());
			String st1= cust.getId();
			if(!(st1 == null)) {
				System.out.printf("%s",st1);
				request.setAttribute("customer", cust);
				request.getRequestDispatcher
				(String.format(Constants.VIEW_PATH,"customer", request.getParameter("dest"))).forward(request, response);
			}else {
				request.getRequestDispatcher(String.format(Constants.VIEW_PATH,"customer", request.getParameter("action"))).forward(request, response);
			}
			break;
		case "existId" : 
			break;
		}

	}
	//String action = request.getParameter("action");
	//RequestDispatcher rd =null;
	//		String jspName = "";
	//		switch( request.getParameter("action")) {
	//		case "join": 
	//			jspName = "join";
	////				rd = request.getRequestDispatcher("WEB-INF/views/customer/join.jsp");
	//			break;
	//		case  "login" :  
	//			jspName="login";
	////			rd = request.getRequestDispatcher("WEB-INF/views/customer/login.jsp");
	//			break;
	//		}
	//		RequestDispatcher	rd = request.getRequestDispatcher
	//		 request.getRequestDispatcher
	//				(String.format("WEB-INF/views/customer/%s.jsp", request.getParameter("dest"))).forward(request, response);
	//		rd.forward(request, response);


	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
