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
			<form action="<c:url value="/{id}/admin/writeForm"/>"
				method="POST">
			<label>제목</label>
			<input type="text" name ="postTitle" value="">
			<select name="cateList">
				<!-- Loop -->
				<c:forEach items="${list }" var="vo">
					<option value="${vo.cateNo }">${vo.cateName }</option>		
				</c:forEach>
				<!-- Loop -->
			</select>						
			<br>
			<label>내용</label>
			<textarea name="postContent" cols=60 rows=5>
			</textarea>
			<input type="submit" value="포스트 하기">
			</form>
			<br>		
				
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/blogfooter.jsp" />
	</div>
</body>
</html>