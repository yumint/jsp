package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.userService.UserService;
import kr.or.ddit.user.userService.UserServiceInf;
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize = 1024*1024*5 , maxRequestSize= 1024*1024*5*5)
@WebServlet("/userFormUpdate")
public class UserFormUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 사용자 아이디가 파라미터로 넘어옴 
		String userId = request.getParameter("userId");
		// 사용자 아이디에 해당하는 사용자 정보 조회 
		UserServiceInf userService = new UserService();	// 캡슐화 한것 

		UserVo userInfo = userService.selectUser(userId);
		
		// jsp로 위임하기 위해 사용자 정보를 request에 저장 
				
		request.setAttribute("userInfo" , userInfo);
		
		
					
		// userForm.jsp로 위임 
		request.getRequestDispatcher("/user/userFormUpdate.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 깨질떄 
		// post 한글 파라미터 인코딩 처리 
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 받아오고 
		// userId , name , pass, addr1, addr2 , birth , zipcd , email , tel 
	
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String birth = request.getParameter("birth");	// type
		String zipcd = request.getParameter("zipcd");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		// 파일 경로 지정 
		Part profilePart = request.getPart("profile");
		
		if(profilePart.getSize() > 0){
			
		// 파일 이름 구하는것 
		String contentDisposition = profilePart.getHeader("Content-disposition");

		String fileName = StringUtil.getFileNameFormHeader(contentDisposition);
	

			// url정보를 실제 파일경로로 변경
			String path = getServletContext().getRealPath("/profile");
			
			profilePart.write(path + File.separator + fileName );
			profilePart.delete();	// 파일 업로드 과정에서 사용한 디스크 임시 영역을 정리 
			
			// /profile/minji.png
			String profile = "/profile/" + fileName;
			
			// 값을 잘 받아오나 확인하는 부분 
			System.out.println(userId + "/" + name + "/" + pass + "/" + addr1 + "/" + addr2 + "/" + birth + "/"
					+ zipcd + "/" + email + "/" + tel);
			
			// 사용자 등록 서비스 호출 (구현했음) 
			// 파라미터를 userVo로 만들기 
			
			UserVo userVo = new UserVo();
			
			userVo.setUserId(userId);
			userVo.setName(name);
			userVo.setAddr1(addr1);
			userVo.setAddr2(addr2);
			userVo.setZipcd(zipcd);
			userVo.setPass(pass);
			userVo.setEmail(email);
			userVo.setTel(tel);
			userVo.setProfile(profile);
			
			try {
				// yyyy-MM-dd
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				userVo.setBirth(sdf.parse(birth));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			UserServiceInf userService = new UserService();
			int updateCnt = userService.updateUser(userVo);
		}
		else{
			//profile기존 값 입력
			
		}
		
	

		//	사용자 리스트로 이동해야 한다.(redirect :  서버 상태가 변경되므로 사용자가 새로고침을 통해 재요청시 중복 등록되는 현상을 막는다 
		//  새로고침을 하여도 사용자가 계속 등록되지 않게 하는 방법 
		//db에 상태 변경이 있을때에는 sendRedirect를 사용해야 된다
		response.sendRedirect("/user/userDetail.jsp");
	}

}
