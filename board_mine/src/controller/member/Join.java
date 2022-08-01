package controller.member;  // 요청 = 주소   // req.setCharacterEncoding(charset) 는 클라이언트로부터 요청온 데이터의 인코딩타입을 charset으로 한다
                            // 포워드 리다이렉트 차이  // 요청 응답에 대한 정리  // get post 에 대한 정리
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Member;
import service.MemberService;
import utils.Const;

@WebServlet("/member/join")  // 회원가입을 위한 요청  (jsp뿐만 아니라 모든 웹 요청의 기본값이 get)   // 서블릿안에 url을 호출하면 서블릿 안에 구현부를 실행(서블릿 기능수행)
public class Join extends HttpServlet {
	private MemberService memberService = MemberService.getInstance();
	@Override  // get방식으로 요청이 오면 화면만 응답  (doget호출의 목적은 화면을 응답하기 위함)
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(Const.member("join")).forward(req, resp);  // join jsp로 보내는게 아니라 자기폴더의 join 이라는 주소로 보내는것 (a태그의 member/list로 링크타는거랑 같은원리
 	}

	@Override  // post방식으로 요청이 오면 회원가입 로직 처리 후 '/member/login' 으로 포워드  >> post로는 로직적인 부분만 처리  (dopost는 로직 처리하기 위함)
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");

		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		
		Member member = new Member(id, pw, name);
		memberService.register(member);
		System.out.println(member);
		
		resp.sendRedirect("../member/login"); 
		
	}
}
