<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dbcpConnection.jsp</title>
</head>
<body>

 <%
 	// db connection pooling
 	// 기본적이 DB 접속하기 위한부분 설정 
 	BasicDataSource bd = new BasicDataSource();
 	bd.setUsername("YMJ");
 	bd.setPassword("java");
 	bd.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
 	bd.setDriverClassName("oracle.jdbc.driver.OracleDriver");
 	bd.setInitialSize(10); 	// db 컨넥션 초기 사이즈 
 	
 	Connection conn = null;
 	
	long startTime = System.currentTimeMillis();
 	for(int i = 0; i < 30; i++){
	 	conn = bd.getConnection();
		 out.println("scheme :" + conn.getSchema()+ "<br/>");
		 conn.close();
 	}
 
	long endTime = System.currentTimeMillis();
	out.println("endTime-startTime : " + (endTime - startTime)+"ms");
	
	bd.close();
	
 %>

</body>
</html>