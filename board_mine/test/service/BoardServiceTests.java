package service;

import org.junit.Assert;
import org.junit.Test;

import domain.Board;
import domain.Criteria;
import domain.PageDto;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardServiceTests {
	private BoardService boardService = BoardService.getInstance();
	Board board = new Board();
	Criteria criteria = new Criteria();
	
	@Test
	public void testExist() {
		log.info("객체 존재 여부 확인 :: " + boardService.toString());
		Assert.assertNotNull(boardService);
	}
	
	@Test
	public void testList() {
		int pageNum=1;
		int amount =3;
		int category = 1;
		
		Criteria criteria = new Criteria(pageNum, amount, category);
		log.info(criteria);
		boardService.list(criteria).forEach(log::info);
//		log.info("게시글 목록 확인 :: " + boardService.list());
	}
	
	@Test
	public void testRegister() {
		boardService.register(new Board("제목1", "내용1", "id33", 1));
	}
	
	@Test
	public void testModify() {
		boardService.modify(new Board(141l, "테스트 제목 수정", "테스트 내용 수정"));
	}

	@Test
	public void testRemove() {
		boardService.remove(203l);
	}

	@Test
	public void testGet() {
		log.info("게시글 상세조회 기능 :: " + boardService.get(141l));
	}
	
	@Test
	public void testCount() {
		int pageNum=1;
		int amount =3;
		int category = 1;
		
		Criteria criteria = new Criteria(pageNum, amount, category);
		log.info(criteria);
		log.info(boardService.count(criteria));
	}
	
	@Test
	public void testPageDto() {
		int pageNum = 1;
		int amount = 20;
		int category = 1;
		
		Criteria criteria = new Criteria(pageNum, amount, category);
		log.info(criteria);
		
		PageDto dto = new PageDto(boardService.count(criteria), criteria);
		log.info(dto);
	}
}

