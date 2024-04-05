package kr.com.ezen.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.dto.MemberVO;
import kr.com.ezen.persistence.DataSourceTests;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberServiceTest {

	@Autowired
	private MemberService memberService;
	
	@Test
	public void testInsert() {
		MemberVO vo = MemberVO.builder()
				.id(200)
				.name("���")
				.phone("100-1111-2222")
				.address("����� ���")
				.build();
		memberService.insertMember(vo);
	}
	
	@Test
	public void testList() {
		memberService.list().forEach(vo -> log.info(vo));
	}
}
