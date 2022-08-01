package controller.board;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import domain.Attach;
import domain.Board;
import domain.Criteria;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import service.BoardService;
import service.MemberService;
import utils.Const;

@WebServlet("/board/register")
public class Register extends HttpServlet {
	private BoardService boardService = BoardService.getInstance();
	private MemberService memberService = MemberService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria criteria = new Criteria();
		
		String pageNum = req.getParameter("pageNum");
		String amount = req.getParameter("amount");
		String category = req.getParameter("category");
		                
//		System.out.println(pageNum);
//		System.out.println(amount);
//		System.out.println(category);
		
		if(amount != null) {
			criteria.setAmount(Integer.parseInt(amount));
		}
		
		if(category != null) {
			criteria.setCategory(Integer.parseInt(category));
		}

		if(pageNum != null) {
			criteria.setPageNum(Integer.parseInt(pageNum));
		}
		
		req.setAttribute("cri", criteria);
		req.getRequestDispatcher(Const.board("register")).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria criteria = new Criteria();
//		String title = req.getParameter("title");
//		String content = req.getParameter("content");
		
//		String pageNum = req.getParameter("pageNum");
//		String amount = req.getParameter("amount");
//		String category = req.getParameter("category");
//		
//		Criteria criteria = new Criteria(Integer.parseInt(pageNum),Integer.parseInt(amount),Integer.parseInt(category));
		
//		System.out.println(title);
//		System.out.println(content);

//		Board board = new Board(title, content, null);
//		System.out.println(board);
		boardService.register(upload(req, criteria));
		System.out.println(criteria);
		resp.sendRedirect("../board/list"+ criteria.getParams2());
		
	}
	
	private Board upload(HttpServletRequest req, Criteria cri) {
		Board board = new Board();
		String saveDir = "c:\\upload";
		int size = 10 * 1024 * 1024;
		
//		System.out.println(saveDir);
//		System.out.println(saveDir.toString());
		
		File currentDir = new File(saveDir);
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDir);
		factory.setSizeThreshold(size);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(req);
			
			for(FileItem fi : items) {
				if(fi.isFormField()) { // 일반 input 
					if(fi.getFieldName().equals("title")) {
						board.setTitle(fi.getString("utf-8"));
					}
					if(fi.getFieldName().equals("content")) {
						board.setContent(fi.getString("utf-8"));
					}
					if(fi.getFieldName().equals("writer")) {
						board.setWriter(fi.getString("utf-8"));
					}
					if(fi.getFieldName().equals("amount")) {
						cri.setAmount(Integer.parseInt(fi.getString("utf-8")));
					}
					if(fi.getFieldName().equals("category")) {
						cri.setCategory(Integer.parseInt(fi.getString("utf-8")));
						board.setCategory(cri.getCategory());
					}
				}
				else { // input file 
					if(fi.getSize() == 0) { // 파일 크기가 0일 경우
						continue; // 반복문 건너뜀
					}System.out.println(fi);
					
					String origin = fi.getName(); // 업로드 파일 원본명 
					int idxDot = origin.lastIndexOf("."); // 마지막 점 위치
					String ext = "";  // 확장자 담을 변수
					if(idxDot != -1) { // (-1이 아닌경우)   
						ext = origin.substring(idxDot); // substring 은 시작위치를 포함
					}
					UUID uuid = UUID.randomUUID(); // 난수를 통한 uuid 생성 
					String name = uuid + ext; // 고유 파일명
					
					
					File upPath = new File(currentDir + "\\" + getTodayStr());
					if(!upPath.exists()) {
						upPath.mkdirs();
					}
					fi.write(new File(upPath, name));
					
					Attach attach = new Attach(name, origin, getTodayStr());
					procImageType(attach, upPath, name);
					
					board.getAttachs().add(attach);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}
	
	private String getTodayStr() {
		return new SimpleDateFormat("yyyy/MM/dd").format(System.currentTimeMillis());
	}
	
	private void procImageType(Attach attach, File upPath, String name) {
		File file = new File(upPath, name);
		try {
			Thumbnails
				.of(file)
				.sourceRegion(Positions.CENTER, 300, 300)
				.size(200, 200)
				.toFile(new File(upPath, "s_" + name));
			attach.setImage(true);
		} catch (IOException ignore) { };
	}
}
