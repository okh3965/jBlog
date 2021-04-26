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
					
	<form:form 
		id="join-form"
		modelAttribute="userVo"
		name="registerForm" 
		action="${pageContext.servletContext.contextPath }/usr/join"
		method="POST"		
		>
		<input type="hidden" name="check" value="f">
		<input type="hidden" name="a" value="join">
		
		<label for="userName">이름</label><br/>
		<!-- input name="name" type="text" placeholder="이름을 입력하십시오"-->
		<form:input path="userName" placeholder="이름을 입력하십시오" />
		<br><br>

		<label for="id">아이디</label><br/>
		<!--input type="text" name="email" placeholder="이메일을 입력하십시오."-->
		<form:input path="id" placeholder="아이디를 입력하세요." />
		<!-- 중복 체크 버튼 -->
		<input type="button" 
			value="id 중복체크" 
			onclick="checkid(this.form.id, '<c:url value="/usr/idcheck" />')" />		
		<br><br>
			
		<label for="password">패스워드</label><br/>
		<input name="password" type="password" placeholder="비밀번호를 입력하십시오">
		<!-- modelAttribute의 password 필드에 관련된 오류 메시지 출력 -->
		<br><br>
		<p>약관 동의</p>	
		<input type="checkbox" name="agree"/>
		<label for="agree">서비스 약관에 동의합니다.</label><br/>
		<input type="submit" value="회원가입" onclick="return checkForm(this.form);"/>
		
	</form:form>
		
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>
