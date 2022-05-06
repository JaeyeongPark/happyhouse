<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function search() {
		let id = $("#find-password-Id").val();
		$.ajax({
				url : "/user/"+id,
				type : "GET",
				contentType:'application/json;charset=utf-8',
				dataType:'json',
				success:function(data) {
					if(data.flag == 1){
						alert("비밀번호는 "+data.pw+"입니다");
					}else{
						alert("정보가 일치하지 않습니다.");
					}
				},
				error:function(xhr, status, error){
					console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
				}
			});
	}

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
					}else{
						alert("회원가입실패");
					}
				},
				error:function(xhr, status, error){
					console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
				}
			});
	}

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
					}else{
						alert("회원삭제실패");
					}
				},
				error:function(xhr, status, error){
					console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
				}
			});
	}

	function searchpw() {
		$("#exampleModallogin").modal("hide"); //닫기
		$("#searchpw").modal("show"); //닫기
	}
</script>
</head>
<body>
	<!-- 로그인 -->
	<div class="modal fade" id="exampleModallogin" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabellogin">로그인</h5>
				</div>
				<div class="modal-body">
					<form action="${root }/user/login" class="row g-3" method="post">
						<div class="col-12">
							<label for="loginId" class="form-label">Id</label> <input
								type="text" class="form-control" id="loginId" placeholder="id"
								name="id" />
						</div>
						<div class="col-12">
							<label for="loginPassword" class="form-label">Password</label> <input
								type="password" class="form-control" id="loginPassword"
								placeholder="password" name="password" />

						</div>
						<div class="col-12"
							style="width: fit-content; margin: auto; display: block; margin-top: 20px;">
							<button type="submit" class="btn btn-primary"
								style="background-color: burlywood; text-decoration: black; border: none;"
								data-bs-dismiss="modal">로그인</button>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">닫기</button>
						</div>
					</form>
					<p onclick="searchpw()">비밀번호 찾기</p>
				</div>
			</div>
		</div>
	</div>

	<!-- 회원가입 -->
	<div class="modal fade" id="exampleModalregist" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabelregist">회원가입</h5>
				</div>
				<div class="modal-body">
					<form class="row g-3">
						<div class="col-md-6">
							<label for="inputId" class="form-label">Id</label> <input
								type="text" class="form-control" id="inputId" placeholder="id"
								name="id" />
						</div>
						<div class="col-md-6">
							<label for="inputPassword" class="form-label">Password</label> <input
								type="password" class="form-control" id="inputPassword"
								placeholder="영문, 숫자포함 6자리 이상" name="password" />
						</div>
						<div class="col-12">
							<label for="inputName" class="form-label">Name</label> <input
								type="text" class="form-control" id="inputName"
								placeholder="name" name="name" />
						</div>
						<div class="col-12">
							<label for="inputemail" class="form-label">Email</label> <input
								type="text" class="form-control" id="email" placeholder="email"
								name="email" />
						</div>
						<div class="col-12">
							<label for="inputNumber" class="form-label">Phone Number</label>
							<input type="text" class="form-control" id="inputNumber"
								placeholder="010-xxxx-xxxx" name="inputNumber" />
						</div>
						<div class="col-12"
							style="width: fit-content; margin: auto; display: block; margin-top: 20px;">
							<button type="button" onclick="reg()" class="btn btn-primary"
								style="background-color: burlywood; text-decoration: black; border: none;"
								data-bs-dismiss="modal">등록</button>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">닫기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 회원정보확인 -->
	<div class="modal fade" id="exampleModalconfirm" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabelregist">회원정보확인</h5>
				</div>
				<div class="modal-body" id="modal-body-regist">
					<form class="row g-3" id="updateform">
						<div class="col-md-6">
							<label for="updateId" class="form-label">Id</label> <input
								type="text" class="form-control" id="updateId" placeholder="id"
								name="id" value="${userInfo.id }" readonly />
						</div>
						<div class="col-md-6">
							<label for="updatePassword" class="form-label">Password</label> <input
								type="password" class="form-control" id="updatePassword"
								placeholder="영문, 숫자포함 6자리 이상" name="password"
								value="${userInfo.password }" />
						</div>
						<div class="col-12">
							<label for="updateName" class="form-label">Name</label> <input
								type="text" class="form-control" id="updateName"
								placeholder="name" name="name" value="${userInfo.name }" />
						</div>
						<div class="col-12">
							<label for="updatemail" class="form-label">Email</label> <input
								type="text" class="form-control" id="updatemail"
								placeholder="email" name="email" value="${userInfo.email }" />
						</div>
						<div class="col-12">
							<label for="updateNumber" class="form-label">Phone Number</label>
							<input type="text" class="form-control" id="updateNumber"
								placeholder="010-xxxx-xxxx" name="updateNumber"
								value="${userInfo.phonenumber }" />
						</div>
						<div class="col-12"
							style="width: fit-content; margin: auto; display: block; margin-top: 20px;">
							<button type="button" onclick="upd()" class="btn btn-primary"
								style="background-color: burlywood; text-decoration: black; border: none;"
								data-bs-dismiss="modal">수정</button>

							<button type="button" onclick="del()" class="btn btn-primary"
								style="background-color: burlywood; text-decoration: black; border: none;"
								data-bs-dismiss="modal">삭제</button>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">닫기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 비번 -->
	<div class="modal fade" id="searchpw" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">비밀번호 찾기</h5>
				</div>
				<div class="modal-body">
					<form class="row g-3">
						<div class="col-12">
							<label for="loginId" class="form-label">Name</label> <input
								type="text" class="form-control" id="find-password-Name"
								placeholder="name" name="searchname" />
						</div>
						<div class="col-12">
							<label for="loginPassword" class="form-label">Id</label> <input
								type="password" class="form-control" id="find-password-Id"
								placeholder="id" name="searchid" />
						</div>
						<div class="col-12">
							<label for="loginPassword" class="form-label">Phone
								Number</label> <input type="text" class="form-control"
								id="find-password-PhoneNumber" placeholder="010-xxxx-xxxx"
								name="searchNumber" />
						</div>
						<div class="col-12"
							style="width: fit-content; margin: auto; display: block; margin-top: 20px;">
							<button type="button" onclick="search()" class="btn btn-primary" id="find-btn"
								style="background-color: burlywood; text-decoration: black; border: none;"
								data-bs-dismiss="modal">찾기</button>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">닫기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>