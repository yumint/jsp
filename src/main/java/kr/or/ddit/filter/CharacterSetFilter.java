package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterSetFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		
		//다른 적용할 필터가 있으면 다른 필터로 요청을 넘기고 
		// 더이상 적용할 필터가 없으면 원 요청에 대한 servlet/ jsp로 요청을 이관
		chain.doFilter(request, response);
		

	}

	@Override
	public void destroy() {
		
	}
	
	

}
