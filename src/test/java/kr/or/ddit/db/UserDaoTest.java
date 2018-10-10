package kr.or.ddit.db;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.Dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.junit.Test;

public class UserDaoTest {

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
		UserDao userDao = new UserDao();
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		List<UserVo> list = userDao.selectUserAll();
		System.out.println(list);
		

		//select 'X' as result from dual
		//result : X
		
		/***Then : 결과가 어떠해야하는지 정의 ***/
		assertEquals(5,list.size());
				
	}
	
	//회원 정보 조회 
	@Test
	public void selectUser(){
		/***Given : 주어진 상황 ***/
		UserDao userDao = new UserDao();
		
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
		UserDao userDao = new UserDao();
		
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

}
