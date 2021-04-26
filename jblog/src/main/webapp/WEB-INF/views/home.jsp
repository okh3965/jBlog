<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jBlog</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/home.css" />" />
</head>
<body>
	<h1><a href="<c:url value="/" />">JBlog</a></h1>	
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />	
</body>
</html>