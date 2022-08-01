package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Board;
import domain.Criteria;
import domain.Member;
import service.BoardService;
import utils.Const;

@WebServlet("/board/modify")
public class Modify extends HttpServlet{
	private BoardService boardService = BoardService.getInstance();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long bno = Long.parseLong(req.getParameter("bno"));
		System.out.println(bno);
//		Member member = (Member) req.getSession().getAttribute("member");
//		if(member == null || !member.getId().equals(boardService.get(bno).getWriter())) {
//			resp.sendRedirect(req.getContextPath() + "/board/list");
//			return;
//		}
		req.setAttribute("board", boardService.get(bno));
		req.getRequestDispatcher(Const.board("modify")).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria criteria = new Criteria();
		
		String pageNum = req.getParameter("pageNum");
		String amount = req.getParameter("amount");
		String category = req.getParameter("category");
		
		if(amount != null) {
			criteria.setAmount(Integer.parseInt(amount));
		}
		
		if(category != null) {
			criteria.setCategory(Integer.parseInt(category));
		}

		if(pageNum != null) {
			criteria.setPageNum(Integer.parseInt(pageNum));
		}
		
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		Board board = new Board(Long.parseLong(bno), title, content);
		boardService.modify(board);
		resp.sendRedirect("list"+ criteria.getParams2());
	}
	
	
	
}
