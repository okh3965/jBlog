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
			<table border="1" width="640">
				<tr>
					<th>번호</th>
					<th>카테고리명</th>
					<th>포스트 수</th>
					<th>설명</th>
					<th>삭제</th>
				</tr>
				<!-- Loop -->
				<c:forEach items="${list }" var="vo">
				<tr>
					<td>${vo.cateNo }</td>
					<td>${vo.cateName }</td>
					<td>${vo.postCount }</td>
					<td>${vo.description }</td>
					<td><a href="<c:url value="/{id}/admin/category/delete/${vo.cateNo }"/>">X</a></td>
				</tr>
				</c:forEach>
				<!-- /Loop -->
			</table>
				<form action="<c:url value="/{id}/admin/category/write"/>"
					method="POST">
				<br><br>
				<label>카테고리명</label>
				<input type="text" name="cateName" value="">
				<br>
				<label>설명</label>
				<input type="text" name="description" value="">
				<br>
				<input type="submit" value="카테고리 추가">
				</form>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/blogfooter.jsp" />
	</div>
</body>
</html>