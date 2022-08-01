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

@WebServlet("/board/get")
public class Get extends HttpServlet {
	private BoardService boardService = BoardService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria criteria = new Criteria();
		String pageNum = req.getParameter("pageNum");
		String amount = req.getParameter("amount");
		String category = req.getParameter("category");
		                
		Long bno = Long.parseLong(req.getParameter("bno"));
		
		if(amount != null) {
			criteria.setAmount(Integer.parseInt(amount));
		}
		
		if(category != null) {
			criteria.setCategory(Integer.parseInt(category));
		}

		if(pageNum != null) {
			criteria.setPageNum(Integer.parseInt(pageNum));
		}
		
		req.setAttribute("page", new PageDto(boardService.count(criteria), criteria));
		req.setAttribute("board", boardService.get(bno));
		
		req.getRequestDispatcher(Const.board("get")).forward(req, resp);
	}
}
