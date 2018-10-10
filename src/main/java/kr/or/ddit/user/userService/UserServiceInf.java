package kr.or.ddit.user.userService;

import java.util.List;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceInf {
	
	// jspuser 테이블 테이터 전체 조회 쿼리 
	// select query id : selectUserAll
	public List<UserVo> selectUserAll();
	
	// jspuser 테이블 테이터 전체 조회 쿼리 
	// select query id : selectUserAll
	public UserVo selectUser(String userId);
	
	
	// vo로 매개변수설정한후 vo로 가지고 오는 쿼리 
	public UserVo selectUserByVo(UserVo userVo);
	
	// 페이징 처리하는 방법
	public List<PageVo> selectUserPageList(UserVo userVo);

}
