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
					
					<p class="jr-success">
						"감사합니다. 회원가입 및 블로그가 성공적으로 만들어 졌습니다."
					</p>
					<p>
						<a href="<c:url value="/usr/login"/> ">로그인하기</a>
					</p>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />	
	</div>
</body>
</html>