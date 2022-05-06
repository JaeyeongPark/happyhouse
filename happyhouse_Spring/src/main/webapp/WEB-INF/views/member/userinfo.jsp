<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/views/head/memberhead.jsp" %>
<title>회원정보</title>
<script type="text/javascript">
$(document).ready(function(){
	let id = new URLSearchParams(location.search).get("id");
	$.ajax({
			url : "/user/"+id,
			type : "GET",
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			success:function(data) {
				console.log(data);
				makeList(data);
			},
			error:function(xhr, status, error){
				console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
			}
	});
});

function upd() {
	let id = $("#updateId").val();
	 $.ajax({
			url : "/user/"+id,
			type : "PUT",
			contentType:'application/json;charset=utf-8',
			data : JSON.stringify ({
				id:$("#updateId").val(),
				password:$("#updatePassword").val(),
				name:$("#updateName").val(),
				email:$("#updateemail").val(),
				phonenumber:$("#updateNumber").val()
			}),
			dataType:'json',
			success:function(data) {
				if(data.flag == 1){
					alert("회원수정성공");
					location.replace("/");
				}else{
					alert("회원수정실패");
				}
			},
			error:function(xhr, status, error){
				console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
			}
		});
}

function del() {
	let id = $("#updateId").val();
	 $.ajax({
		 url : "/user/"+id,
			type : "DELETE",
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			success:function(data) {
				if(data.flag == 1){
					alert("회원삭제성공");
					location.replace("/");
				}else{
					alert("회원삭제실패");
				}
			},
			error:function(xhr, status, error){
				console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
			}
		});
}


function makeList(data){
	$("#userinfoform").empty();
		let str = `
			<h2 class="p-3 mb-3 text-center">회원정보</h2>
			<div class="form-group mt-2">
			<label for="updateId">아이디</label>
		   <input type="text" class="form-control" id="updateId" value="${'${data.udto.id}'}" name="id" readonly/>
		  	</div>
		  	<div class="form-group mt-4">
		  	<label for="updatePassword">비밀번호</label>
		   <input type="password" class="form-control" id="updatePassword" value="${'${data.udto.password}'}" name="password" />
		 	 </div>
		  	 <div class="form-group mt-4">
		  	<label for="updateName">이름</label>
		   <input type="text" class="form-control" id="updateName" value="${'${data.udto.name}'}" name="name" />
		 	</div>
		 	 <div class="form-group mt-4">
		 	<label for="updateemail">이메일</label>
		  	 <input type="email" class="form-control" id="updateemail" value="${'${data.udto.email}'}" name="email" />
		  	</div>
		  	 <div class="form-group mt-4">
		  	<label for="updateNumber">전화번호</label>
		  	  <input type="text" class="form-control" id="updateNumber" value="${'${data.udto.phonenumber}'}" name="inputNumber" />
		  	</div>
		  	<div>
		  		<button type="button" class="btn btn-outline-primary mt-3" onclick="upd()">회원수정</button>
				<button type="button" class="btn btn-outline-primary mt-3" onclick="del()">회원삭제</button>
			</div>
			`;
		$("#userinfoform").append(str);
};


</script>

</head>
<body>

	<!-- HEADER 시작 -->
	<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<!-- HEADER 끝 -->

	<!-- MAIN 시작 -->
	<div id="main" class="container" style="height: 600px;">
		<div class="container text-center col-6 pt-2" style="height: 600px;">
			<form id="userinfoform" class="text-left mb-3">
				 
				  
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
