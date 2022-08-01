package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Criteria;
import domain.PageDto;
import service.BoardService;
import utils.Const;

@WebServlet("/board/remove")
public class Remove extends HttpServlet{
	private BoardService boardService = BoardService.getInstance();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long bno = Long.parseLong(req.getParameter("bno"));
		System.out.println(bno);
		boardService.remove(bno);
		
		Criteria criteria = new Criteria();
		if(req.getParameter("pageNum") != null) {
			criteria.setPageNum(Integer.parseInt(req.getParameter("pageNum")));
		}
		if(req.getParameter("amount") != null) {
			criteria.setAmount(Integer.parseInt(req.getParameter("amount")));
		}
		if(req.getParameter("category") != null) {
			criteria.setCategory(Integer.parseInt(req.getParameter("category")));
		}
		
		req.setAttribute("page", new PageDto(boardService.count(criteria), criteria));
		req.setAttribute("boards", boardService.list(criteria));
		
//		if(criteria.getCategory() == 3) {
//			req.getRequestDispatcher(Const.board("gallery")).forward(req, resp);
//			return;
//		}
		
		resp.sendRedirect("../board/list"+ criteria.getParams2());
	}
}
