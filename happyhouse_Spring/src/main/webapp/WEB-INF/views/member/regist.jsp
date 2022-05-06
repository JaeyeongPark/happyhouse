<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/views/head/memberhead.jsp" %>
<title>회원가입</title>
<script type="text/javascript">
function reg() {
	$.ajax({
			url : "/user/",
			type : "POST",
			contentType:'application/json;charset=utf-8',
			data : JSON.stringify ({
				id:$("#inputId").val(),
				password:$("#inputPassword").val(),
				name:$("#inputName").val(),
				email:$("#email").val(),
				phonenumber:$("#inputNumber").val()
			}),
			dataType:'json',
			success:function(data) {
				if(data.flag == 1){
					alert("회원가입성공");
					location.replace("/user/loginform");
				}else{
					alert("회원가입실패");
				}
			},
			error:function(xhr, status, error){
				console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
			}
		});
	
	
}

</script>

</head>
<body>

	<!-- HEADER 시작 -->
	<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<!-- HEADER 끝 -->

	<!-- MAIN 시작 -->
	<div id="main" class="container" style="height: 600px;">
		<div class="container text-center col-6 pt-5" style="height: 600px;">
			<form class="text-left mb-3">
			 	<h2 class="p-3 mb-3 text-center">회원가입</h2>
				  <div class="form-group mt-2">
				   <input type="text" class="form-control" id="inputId" placeholder="아이디" name="id" />
				  </div>
				  <div class="form-group mt-4">
				   <input type="password" class="form-control" id="inputPassword" placeholder="비밀번호" name="password" />
				  </div>
				   <div class="form-group mt-4">
				   <input type="text" class="form-control" id="inputName" placeholder="이름" name="name" />
				  </div>
				   <div class="form-group mt-4">
				   <input type="email" class="form-control" id="email" placeholder="이메일" name="email" />
				  </div>
				   <div class="form-group mt-4">
				    <input type="text" class="form-control" id="inputNumber" placeholder="전화번호" name="inputNumber" />
				  </div>
				  <div>
				  <button type="button" class="btn btn-outline-primary mt-3" onclick="reg()">회원가입</button>
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
