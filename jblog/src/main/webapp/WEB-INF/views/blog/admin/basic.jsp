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
		<h1>${vo.blogTitle }</h1>	
		<jsp:include page="/WEB-INF/views/includes/blogheader.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />		
		<div id="wapper">
			<div id="content">
				<div id="site-introduction">
					
				<form method="POST" 
					action="${pageContext.request.contextPath}/${authUser.id }/upload" 
					enctype="multipart/form-data">
					<label>블로그 제목</label>
					<input type="hidden" name="userNo" value="${vo.userNo }">
					<input type="text" name="blogTitle" value="${vo.blogTitle }">
					<br>
					<label>로고 이미지</label><br>
					<img src="${pageContext.request.contextPath}/${urlImage}">					
					<input type="file" name="newImage">
					<br>
					<br>
					<input type="submit" value="기본설정변경">										
					
				</form>	
				
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/blogfooter.jsp" />
	</div>
</body>
</html>