<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>

<%@include file="/WEB-INF/views/head/boardhead.jsp" %>

<script type="text/javascript">
$(document).ready(function(){
	let no = ${no};
	console.log(no);
	$.ajax({
		
		url : "/board/"+no,
		type : "GET",
		contentType:'application/json;charset=utf-8',
		dataType:'json',
		success:function(data) {
			makeList(data);
		},
		error:function(xhr, status, error){
			console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
		}
	});
});
	
	function makeList(data){
		$("#selectboardlist").empty();
			let str = `
				<h2 class="p-3 mb-3 text-center">
					게시글 보기
				</h2>
				<div class="col-md-12">
				
				</div>
				<div>
					<label for="no">글 번호</label> 
					<input type="text" class="form-control" name="no" id="no" value="${'${data.info.no}'}" readonly/>
				</div>
				<div>
					<label for="id">아이디</label> 
					<input type="text" class="form-control" name="id" id="id" value="${'${data.info.id}'}" readonly/>
				</div>
				<div>
					<label for="subject">제목</label> 
					<input type="text" class="form-control" name="subject" id="subject" value="${'${data.info.subject}'}" readonly/>
				</div>
				<div>
					<label for="contents">내용</label>
					<textarea rows="10" cols="50" name="contents" id="contents" readonly>${'${data.info.contents}'}</textarea>
				</div>
				<a class="boardupdatelink" href="/board/boardupdateform?no=${'${data.info.no}'}&id=${'${data.info.id}'}">글 수정</a>
			</form>
			`;
			$("#selectboardlist").append(str);
	};
	
</script>
<title>게시판 수정</title>
</head>
<body>

	<!-- HEADER 시작 -->
	<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<!-- HEADER 끝 -->

	<!-- MAIN 시작 -->
	<div id="main" class="container">
		<!-- 게시판 시작 -->
		<div class="container text-center mt-3" style="height: 600px">

			<div class="col-lg-4 mx-auto" id="selectboardlist">
				
			</div>
		</div>
		<!-- 게시판 끝 -->

	</div>
	<!-- MAIN 끝 -->

	<jsp:include page="/WEB-INF/views/template/modal.jsp"></jsp:include>

	<!-- FOOTER 시작 -->
	<footer class="p-3 bg-dark text-white container">
		<img src="/img/SSAFY.jpg" />
		<p>Find Us</p>
		<hr />
		<p>(SSAFY)서울시 강남구 테헤란로 멀티스퀘어</p>
		<p>1544-9001</p>
	</footer>
	<!-- FOOTER 끝 -->
</body>
</body>
</html>