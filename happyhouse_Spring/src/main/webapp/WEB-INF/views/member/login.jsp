<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/views/head/memberhead.jsp" %>
<title>로그인</title>


</head>
<body>

	<!-- HEADER 시작 -->
	<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<!-- HEADER 끝 -->

	<!-- MAIN 시작 -->
	<div id="main" class="container" style="height: 500px;">
		<div class="container text-center col-6 pt-5" style="height: 500px;">
				<form action="${root }/user/login" method="post" class="text-left mb-3">
					  <h2 class="p-3 mb-3 text-center">로그인</h2>
					  <div class="form-group mt-4">
					    <!-- <label for="loginId">아이디</label> -->
					    <input type="text" class="form-control mt-2" placeholder="아이디" id="loginId" name="id">
					  </div>
					  <div class="form-group mt-5">
					    <!-- <label for="loginPassword">비밀번호</label> -->
					    <input type="password" class="form-control mt-2" placeholder="비밀번호" id="loginPassword" name="password">
					  </div>
					  <div class = "mt-5">
					  <button type="submit" class="btn btn-outline-primary">로그인</button>
					  <button type="button" class="btn btn-outline-primary" onclick="location.href='/user/findpwdform'">비밀번호 찾기</button>
					  </div>
				</form>
		</div>
	</div>
	<!-- MAIN 끝 -->

	<!-- FOOTER 시작 -->
	<footer class="p-3 bg-white text-black text-center container" >
		<p>Find Us</p>
		<hr />
		<div class = "text-center"><img src="/img/SSAFY.jpg" style="width: 70px"/></div>
		<p>(SSAFY)서울시 강남구 테헤란로 멀티스퀘어</p>
		<p>1544-9001</p>
	</footer>
	<!-- FOOTER 끝 -->
</body>
</body>
</html>
