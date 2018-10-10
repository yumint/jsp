package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.userService.UserService;
import kr.or.ddit.user.userService.UserServiceInf;


@WebServlet("/userAllList")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	// 상태가 변경되는 부분이 아닐경우에는 doGet에 하기 (링크 클릭하는 것도 Get방식) 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체 사용자 정보조회
		UserServiceInf userService = new UserService();	// 캡슐화 한것 
		List<UserVo> userList = userService.selectUserAll();
		
		// 조회된 사용자 정보를 userAllList.jsp를 통해 화면처리 
		// userAllList.jsp에서 userList를 참조하려면 > 
		// attribute사용 -> 이부분을 사용하려면 session , application , request
		
		// session에 특징 : 해당 사용자만 접근이 가능(사용자 전용 공간 )  
		// 자주 참조하는 데이터 (어떤 페이지에 가도 사용자의 이름을 이용한다면)
		// 너무 많은 데이터를 저장할 경우 과부하가 걸린다 
		
		// application : 모든 사용자가 접근가능 (서버당 하나만 생성) -> 요청에 대한 부분을 입력하는 건 아니다
		
		// request : 해당 요청의 응답이 끝날떄까지
		
		//서블릿에서 application 사용하는 방법  -> 요청 말고 일반적으로 설정과 관련된 값을 저장한다
		//getServletContext().setAttribute("userList", userList);
		
		// request
		request.setAttribute("userList", userList);
		
		// 화면으로 위임 : 2가지 
		// 1. dispatch : 조회만 했을떄 사용   , 보통/ 일반적으로 사용한다 
		// 2. sendRedirect : 서버에 데이터가 변경되었을떄 사용 (요청이 2번간다) 
		RequestDispatcher rd = request.getRequestDispatcher("/user/userAllList.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
