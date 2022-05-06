<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/views/head/memberhead.jsp" %>
<title>로그인</title>
<script type="text/javascript">
	function pwd(){
		let id = $("#findId").val();
		let pn = $("#findnumber").val();
		 $.ajax({
				url : "/user/"+id+"/"+pn,
				type : "GET",
				contentType:'application/json;charset=utf-8',
				dataType:'json',
				success:function(data) {
					if(data.password != 0){
						alert("비밀번호는 "+data.password+"입니다.");
						location.replace("/user/loginform");
					}else{
						alert("회원정보 불일치");
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
	<div id="main" class="container" style="height: 500px;">
		<div class="container text-center col-6 pt-5" style="height: 500px;">
			<h2 class="p-3 mb-3 text-center">비밀번호 찾기</h2>
			<div class="form-group mt-4">
				 <input type="text" class="form-control" placeholder="아이디" id="findId" name="id">
		   </div>
			<div class="form-group mt-5">
				 <input type="text" class="form-control" placeholder="전화번호" id="findnumber" name="phonenumber">
			</div>
			<button type="button" class="btn btn-outline-primary mt-5" onclick="pwd()">비밀번호 찾기</button>
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
