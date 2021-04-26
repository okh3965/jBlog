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
		<div id="wapper">
			<div id="content">
				<div id="site-introduction">
					<h1>${user.userName }의 블로그 메인입니다.</h1>
					<img src="${pageContext.request.contextPath }/${urlImage}"><br>
					
					<!-- 카테고리 목록 -->
					<label>카테고리</label><br>
					<c:forEach items="${list }" var="cateVo">
						<a href="<c:url value="/${user.id }/post/${cateVo.cateNo }" />">${cateVo.cateName }</a><br>					
					</c:forEach>
					
					<!-- 포스트 목록 -->
					<c:forEach items="${postList }" var="postVo">
						<a href="<c:url value="/${user.id }/post/${postVo.cateNo }/${postVo.postNo }" />">${postVo.postTitle }</a>
						${postVo.regDate }<br>					
					</c:forEach>					
									
					<!-- 본문 -->
					<c:choose>
					<c:when test="${empty getPostVo}"> 
						<a>${latePostVo.postContent }</a>						
					</c:when>
					<c:otherwise>	
						<a>${getPostVo.postContent }</a>						
					</c:otherwise>
					</c:choose>
									
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/blogfooter.jsp" />
	</div>
</body>
</html>