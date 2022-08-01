package dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import domain.Reply;
import lombok.extern.log4j.Log4j;

@Log4j
class ReplyDaoTests {
	private ReplyDao replyDao = ReplyDao.getInstance();
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test2() {
		assertNotNull(replyDao);
	}
	
	@Test
	public void testList() {
		replyDao.list(169L).forEach(log::info);
	}
	
	@Test 
	public void testGet() {
		log.info(replyDao.get(41L));
	}
	
	@Test
	public void testRegister() {
		Reply reply = new Reply(null, "test case2", null, 344L, "id2");
		replyDao.register(reply);
	}
 
}
