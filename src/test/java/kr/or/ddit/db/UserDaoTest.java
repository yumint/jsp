package kr.or.ddit.db;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.userDao.UserDao;
import kr.or.ddit.user.userDao.UserDaoInf;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
	
	private UserDaoInf userDao;
	
	@Before
	public void setup(){
		userDao = new UserDao();
	}

	// 테스트 메소드 명명규칙(회사마다 다름) 
	// 운영코드 메소드 이름 + Test
	// getTemp + Test : getTempTest
	@Test
	public void test() {
		/***Given : 주어진 상황 ***/
		TempDao tempDao = new TempDao();
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		Map<String, Object> map = tempDao.getTemp();
		System.out.println("map : "+ map);
		
		//select 'X' as result from dual
		//result : X
		
		/***Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals("X",map.get("result"));
	}
	
	// DB에 jspuser 부분의 회원이 몇명있는지 확인하는 부분 
	// 운영메소드 이름 + Test
	@Test
	public void selectUserAllTest() {
		/***Given : 주어진 상황 ***/
		
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		List<UserVo> list = userDao.selectUserAll();
		System.out.println(list);
		

		//select 'X' as result from dual
		//result : X
		
		/***Then : 결과가 어떠해야하는지 정의 ***/
		//assertEquals(5,list.size());
				
	}
	
	//회원 정보 조회 
	@Test
	public void selectUser(){
		/***Given : 주어진 상황 ***/

		
		/***When : 어떤 동작 수행(메소드 호출)***/
		// ()괄호 안에 값을 넣어주기  -> 비교할값
		UserVo user = userDao.selectUser("brown");
		
		/***Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals("brown" ,user.getUserId());
		assertNotNull(user);

	}
	
	@Test
	public void selectUserByVo(){
		/***Given : 주어진 상황 ***/
	
		
		// selectUserByVo할떄 DB에 N.N로 설정된 부분은 꼭 필요한것들 값을 넣어 보내줘야 한다
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		userVo.setName("브라운");
		userVo.setPass("brownpass");
	
		/***When : 어떤 동작 수행(메소드 호출)***/
		// ()괄호 안에 값을 넣어주기  -> 비교할값
		UserVo user = userDao.selectUserByVo(userVo);

		/***Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals("brown" ,user.getUserId());
		assertNotNull(user);
	}

	@Test
	public void selectUserPageList(){
		/***Given : 주어진 상황 ***/
		UserDaoInf userDao = new UserDao();
		
		PageVo userPage = new PageVo();
		userPage.setPage(2);
		userPage.setPageSize(10);
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		List<UserVo> list = userDao.selectUserPageList(userPage);

		/***Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals(10 ,list.size());
	}
	
	
	/**  * Method   : getUserCntTest
	  * 작성자 : PC 
	  * 변경이력 :  
	  * Method 설명 :  사용자 전체 건수 조회 테스트
	*/
	@Test
	public void getUserCntTest(){
		/***Given : 주어진 상황 ***/
		
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		
		int totalUserCnt = userDao.getUserCnt();
		
		/***Then : 결과가 어떠해야하는지 정의 ***/
		
		assertEquals(105, totalUserCnt);
		

		
	}
	
	
}
