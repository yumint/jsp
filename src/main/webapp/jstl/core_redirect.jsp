<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>core_redirect.jsp</title>
</head>
<body>
	<c:redirect url="timesTablesJstl.jsp">
		<c:param name="number" value="7"></c:param>
	</c:redirect>
</body>
</html>