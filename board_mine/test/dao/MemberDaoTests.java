package dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import domain.Member;
import lombok.extern.log4j.Log4j;

@Log4j
public class MemberDaoTests {
//	private Logger logger = Logger.getLogger(MemberDaoTests.class.getName());
	private MemberDao memberDao = MemberDao.getInstance();
	Member member = new Member();
	
	@Test
	public void testExist() {
		log.info("객체 존재 여부 확인 :: " + member.toString());
		Assert.assertNotNull(member);
		
		log.info(memberDao.toString());
		Assert.assertNotNull("객체 존재 여부 확인 :: " + memberDao);
	}
	
	@Test
	public void testLogin() {
		member = memberDao.login("id1", "1234");
		log.info("로그인 기능 :: " + member);
	}
	
	@Test
	public void testRegister() {
		member.setId("tId1_10:48");
		member.setPw("1234");
		member.setName("이름1_10:48");
		
		memberDao.register(member);
		log.info("회원가입 기능 :: " + member);
	}
}
