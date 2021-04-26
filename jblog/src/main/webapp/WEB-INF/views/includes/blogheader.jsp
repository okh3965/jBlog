<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c" %>
	<div id="header">
		<!-- 세션을 체크하여 메뉴 분기 -->		
		<ul>
			<c:choose>
			<c:when test="${empty authUser }"> <!-- authUser == null: 로그인 안함 -->
				<li><a href="<c:url value="/usr/login" />">로그인</a></li>
			</c:when>
			<c:when test="${authUser.id != user.id }">			
				<li><a href="<c:url value="/usr/logout" />">로그아웃</a></li>			
			</c:when>
			<c:otherwise>	<!-- 로그인 한 상태 -->
				<li><a href="<c:url value="/${authUser.id }/admin/basic"/>">내블로그 관리</a></li>			
				<li><a href="<c:url value="/usr/logout" />">로그아웃</a></li>
			</c:otherwise>
			</c:choose>
		</ul>
	</div> 