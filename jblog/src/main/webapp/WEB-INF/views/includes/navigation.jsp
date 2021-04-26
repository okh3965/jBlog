<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c" %>
	<div id="navigation">
		<ul>
			<li><a href="<c:url value="/${authUser.id }/admin/basic" />">기본설정</a></li>
			<li><a href="<c:url value="/${authUser.id }/admin/category" />">카테고리</a></li>
			<li><a href="<c:url value="/${authUser.id }/admin/write" />">글작성</a></li>
		</ul>
	</div>