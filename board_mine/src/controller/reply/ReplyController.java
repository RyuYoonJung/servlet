package controller.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import domain.Criteria;
import domain.PageDto;
import domain.Reply;
import service.ReplyService;
import utils.Const;

@WebServlet("/reply")
public class ReplyController extends HttpServlet{
	private ReplyService replyService = ReplyService.getInstance();
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long rno = Long.parseLong(req.getParameter("rno"));
		String content = req.getParameter("content");
		String regDate = req.getParameter("regDate");;
		Long bno = Long.parseLong(req.getParameter("bno"));
		String writer = req.getParameter("writer");
		
		Reply reply = new Reply(rno, content, regDate, bno, writer);
		
		req.setAttribute("reply", replyService.getInstance().get(bno));
		
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().print(gson.toJson(reply));
		
		req.getRequestDispatcher(Const.board("get")).forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reply reply = gson.fromJson(req.getReader().readLine(), Reply.class);
//		
//		String bnoStr = req.getParameter("bno");
//		System.out.println(bnoStr);
//		String content = req.getParameter("content");
//		System.out.println(content);
//		Long bno = Long.parseLong(bnoStr);
//		String writer = req.getParameter("writer");
//		System.out.println(writer);
//		
//		Reply reply = new Reply(null, content, null, bno, writer);
		System.out.println(reply);
//		req.setAttribute("reply", replyService.register(reply));
		
		replyService.register(reply);
		resp.setContentType("text/plain; charset=utf-8");
		resp.getWriter();
	}
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reply reply = gson.fromJson(req.getReader().readLine(), Reply.class);
		System.out.println(reply);
		replyService.modify(reply);
		resp.setContentType("text/plain; charset=utf-8");
		resp.getWriter();
	}
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reply reply = gson.fromJson(req.getReader().readLine(), Reply.class);
		replyService.remove(reply.getRno());
		resp.setContentType("text/plain; charset=utf-8");
		resp.getWriter();
	}
	
}
