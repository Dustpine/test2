package kr.co.mindoll.board.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.mindoll.board.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardDaoTest {
	@Autowired
	ApplicationContext context;

	@Autowired
	private BoardDAO boardDao;
	
	@Test
	public void contextCreateTest() {
		System.out.println(context + "==========");
		log.info(context + "==========");
		assertNotNull(context);

	}

	@Test
	public void ObjectListTest() { // 스프링이 빈으로 생성해서 가지고 있는 설정 목록 출력해보기
		assertNotNull(context);
		if (context != null) {
			for (String objectName : context.getBeanDefinitionNames()) {
				System.out.println("생성되어 스프링이 가지고 있는 객체 =====> " + objectName);
			}
		}
	}

	@Test
	public void addBoard_Test() {
		BoardVO sampleData = new BoardVO();
		sampleData.setBoardContent("이 내용은 컨텐츠에 들어갈 내용입니다.");
		sampleData.setBoardPwd("123456");
		sampleData.setBoardTitle("테스트 제목1");
		sampleData.setIrum("민돌이");
		
		assertEquals(boardDao.addBoard(sampleData), 1);
	}
	
	@Test
	public void delBoard_Test() {
		assertEquals(boardDao.delBoard(4), 1);
	
	}
	@Test
	public void getBoard_Test() {
		BoardVO sampleData = new BoardVO();
		sampleData.setBoardContent("이 내용은 컨텐츠에 들어갈 내용입니다.");
		sampleData.setBoardPwd("123456");
		sampleData.setBoardTitle("테스트 제목1");
		sampleData.setIrum("민돌이");
		boardDao.addBoard(sampleData); 
		//대문자 Long 
		Long currNum = boardDao.getCurrentNum();
		
		BoardVO resultVO = boardDao.getBoard(currNum);
		assertEquals(resultVO.getIrum(),sampleData.getIrum());
		assertEquals(resultVO.getBoardTitle(),sampleData.getBoardTitle());
		assertEquals(resultVO.getBoardPwd(),sampleData.getBoardPwd());
		
	}
	
}