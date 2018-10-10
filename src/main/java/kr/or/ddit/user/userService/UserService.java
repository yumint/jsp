package kr.or.ddit.user.userService;

import java.util.List;

import kr.or.ddit.user.Dao.UserDao;
import kr.or.ddit.user.Dao.UserDaoInf;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserService implements UserServiceInf {
	
	public UserService() {}
	private static UserServiceInf us = null;
	
	public static UserServiceInf getInstance() {
		if(us == null) {
			us = new UserService();
		}
		return us;
	}

	private UserDaoInf ud = UserDao.getInstance();

	
	@Override
	public List<UserVo> selectUserAll() {
		return ud.selectUserAll();
	}

	@Override
	public UserVo selectUser(String userId) {
		return ud.selectUser(userId);
	}

	@Override
	public UserVo selectUserByVo(UserVo userVo) {
		return ud.selectUserByVo(userVo);
	}

	@Override
	public List<PageVo> selectUserPageList(UserVo userVo) {
		return ud.selectUserPageList(userVo);
	}

}
