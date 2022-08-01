package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Member;
import service.MemberService;
import utils.Const;

@WebServlet("/member/login")
public class Login extends HttpServlet {
	private MemberService memberService = MemberService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(Const.member("login")).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		Member member = memberService.login(new Member(id, pw, null));
		if(member == null) {
			req.setAttribute("msg", "입력 정보를 확인해주세요");
			req.getRequestDispatcher(Const.common("msg")).forward(req, resp);
		}
		else {
			req.getSession().setAttribute("member", member); 
			req.setAttribute("msg", "로그인 되었습니다");
			req.setAttribute("href", req.getContextPath() + "/index");
			req.getRequestDispatcher(Const.common("msg")).forward(req, resp);
		}
	}
}
