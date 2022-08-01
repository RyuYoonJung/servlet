package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Member;
import utils.Const;

@WebServlet("/member/contract")
public class Contract extends HttpServlet {
	Member member = new Member();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(Const.member("contract")).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String checkbox = req.getParameter("checkbox");
		
		if(checkbox == null) {
			req.setAttribute("msg", "약관 동의에 체크해주세요");
			req.getRequestDispatcher(Const.common("msg")).forward(req, resp);
		}
		else {
			req.setAttribute("msg", "약관에 동의하셨습니다");
			req.setAttribute("href", req.getContextPath() + "/member/join");
			req.getRequestDispatcher(Const.common("msg")).forward(req, resp);
		}
	}
}
