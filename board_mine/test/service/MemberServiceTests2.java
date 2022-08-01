package service;

import org.junit.Assert;
import org.junit.Test;

import domain.Member;
import lombok.extern.log4j.Log4j;

@Log4j
public class MemberServiceTests2 {
	private MemberService memberService = MemberService.getInstance();
	Member member = new Member();
	
	@Test
	public void testExist() {
		log.info("객체 존재 여부 :: " + memberService);
		Assert.assertNotNull(memberService);
	}
	
	@Test
	public void testLogin() {
		member.setId("id1");
		member.setPw("1234");
		log.info("로그인 기능 :: " + memberService.login(member));
	}
	
	@Test
	public void testRegister() {
		memberService.register(new Member("id_test2", "1234", "이름_test2"));
	}
}
