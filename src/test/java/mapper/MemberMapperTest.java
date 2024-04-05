package mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.dto.MemberVO;
import kr.com.ezen.mapper.MemberMapper;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTest {

	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void testGetTime() {
		log.info(mapper.getClass().getName());
		log.info(mapper.getTime());
	}
	
	@Test
	public void testInsert() {
		for (int i = 11; i < 20; i++) {
			MemberVO vo = MemberVO.builder()
					.id(10+i)
					.name("user" + i)
					.phone("010-0000-111"+i)
					.address("서울시 장안구" + i)
					.build();	
			mapper.insertMember(vo);
		}
	}
	
	@Test
	public void testUpdate() {
		MemberVO vo = MemberVO.builder()
				.id(19)
				.name("조운")
				.phone("000-1111-2222")
				.address("경기도 수원시")
				.build();	
		mapper.updateMember(vo);
	}
	
	@Test
	public void testDelete() {
		mapper.delectMember(18);
	}
	
	@Test
	public void testSelectOne() {
		MemberVO vo = mapper.selectOneMember(10);
		log.info(vo);
	}
	
	@Test
	public void testAllList() {
//		List<MemberVO> list = memberMapper.selectAllList();
//		for (MemberVO vo : list)
//			log.info(vo);
		mapper.selectAllList()
		.forEach(vo -> log.info(vo));
	}
	
}
