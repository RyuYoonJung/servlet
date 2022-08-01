package dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import domain.Board;
import domain.Criteria;
import lombok.extern.log4j.Log4j;


@Log4j
public class BoardDaoTests {
//	private Logger logger = Logger.getLogger(BoardDaoTests.class.getName());
	private BoardDao boardDao = BoardDao.getInstance(); 
	Board board = new Board();
	Criteria criteria = new Criteria();
	
	@Test
	public void testExist() {
		log.info("객체 존재 여부 확인 :: " + boardDao.toString());
		Assert.assertNotNull(boardDao);
	}
	
	@Test
	public void testList() {
		criteria.setPageNum(2);
		criteria.setAmount(10);
		criteria.setCategory(1);
		
		log.info("게시글 목록 확인 :: " +criteria);
		boardDao.list(criteria).forEach(log::info);
	}
	
	@Test
	public void testRegister() {
		board.setTitle("다오 제목1");
		board.setContent("다오 내용1");
		board.setWriter("다오 작성자1");
		board.setCategory(2);
		
		boardDao.register(board);
		log.info("게시글 등록 기능 :: " + board);
		
	}
	
	@Test
	public void testModify() {
		board.setBno(312l);
		board.setTitle("제목 수정10:43");
		board.setContent("내용 수정10:43");
		
		boardDao.modify(board);
		log.info("게시글 수정 기능 :: " +board);
	}

	@Test
	public void testRemove() {
		Long bno = 315l;
		
		boardDao.remove(bno);
		log.info("게시글 삭제 기능 :: " +bno);
	}

	@Test
	public void testGet() {
		Long bno = 312l;
		
		board = boardDao.get(bno);
		log.info("게시글 상세조회 기능 :: " + board);
	}
	
	@Test
	public void testInsertDummy() {
		for(int i = 0; i < 30 ; i++ ) {
			testRegister();
		}
	}
}

