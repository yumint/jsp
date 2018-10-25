<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%--jstl 사용하기 위한 절차
1. dependency 추가(이미했음) : 한번만 설정하면 된다 
2. jsp파일에서 지시자 추가(taglib : prefix, uri)
3. prefix를 이용하여 jstl태그 사용 

 --%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>core_import.jsp</title>
</head>
<body>

<c:import url="timesTablesJstl.jsp">
	<c:param name="number" value="5"></c:param>
</c:import>


<h2>naver search</h2>
	<c:import url="https://search.naver.com/search.naver">
		<c:param name="query" value="html5"></c:param>
	</c:import>
</body>
</html>