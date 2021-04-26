<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jBlog</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/home.css" />" />
<!-- jQuery -->
<script src="<c:url value="/assets/javascript/jquery/jquery-3.6.0.js"/>"></script>
<!-- 스크립트 삽입 -->
<script src="<c:url value="/assets/javascript/users.js"/>"></script>
</head>
<body>
	<div id="container">
		<h1><a href="<c:url value="/" />">JBlog</a></h1>	
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<div id="wapper">
			<div id="content">
				<div id="site-introduction">
		<form id="login-form" 
			name="loginform" 
			method="POST" 
			action="<c:url value="/usr/login" />" >
			
			<label class="block-label" for="id">아이디</label> 
			<input id="id" name="id" type="text" value=""> 
	
			<label class="block-label">패스워드</label> 
			<input name="password" type="password" value="">
	
			<input type="submit" value="로그인">
		</form>
		    
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>