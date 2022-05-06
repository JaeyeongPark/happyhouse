<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>

<html lang="en">
<head>

<%@include file="/WEB-INF/views/boardhead.jsp" %>

<script type="text/javascript">
$(document).ready(function(){
    $.ajax({
        url : "/board/",
        type : "GET",
        contentType:'application/json;charset=utf-8',
        dataType:'json',
        success:function(lists) {
            console.log(lists);
           makeList(lists);
        },
        error:function(xhr, status, error){
            console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
        }
    });

});

function makeList(lists){
    $("#boardlistbody").empty();
    $(lists.boardlist).each(function(index, list) {
        let str = `<tr id="" class="">
                <td>${'${list.no}'}</td>
                <td>${'${list.id}'}</td>
                <td>${'${list.subject}'}</td>
                <td>${'${list.contents}'}</td>
                <td><button id = "${'${list.no}'}" onClick="viewboard(this.id)">글보기</button></td>
            </tr>`;
        $("#boardlistbody").append(str);
       
    });
}

function viewboard(no){
	$.ajax({
        url : "/board/"+no,
        type : "GET",
        contentType:'application/json;charset=utf-8',
        dataType:'json',
        success:function(list) {
           makeoneList(list);
        },
        error:function(xhr, status, error){
            console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
        }
    });
}

function makeoneList(list){
        let str = `
        	<div class="col-md-3">
	            <div class="boardex">글 번호</div>
	            <hr>
	            <div class="boardex">작성자</div>
	            <hr>
	            <div class="boardex">제목</div>
	            <hr>
	            <div class="boardex">내용</div>
            </div>
            <div class="col-md-9">
	            <div id="boardno">${'${list.info.no}'}</div>
	            <hr>
	        	<div id="boardid">${'${list.info.id}'}</div>
	            <hr>
	            <div id="boardsubject">${'${list.info.subject}'}</div>
	            <hr>
	            <div id="boardcontents">${'${list.info.contents}'}</div>
            </div>
            <div>
            <a href="/board/updateboardform?no=${'${list.info.no}'}&id=${'${list.info.id}'}">게시글 수정하기</a>
            </div>
        `;
        $("#boardinfolist").empty().append(str);
}


</script>

<title>게시판</title>
</head>
<body>

	<!-- HEADER 시작 -->
	<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<!-- HEADER 끝 -->

	<!-- MAIN 시작 -->
	<div id="main" class="container">
		<!-- 게시판 시작 -->
		<div class="map-contents row">

			<!-- 전체게시판 시작 -->
			<div id="map" class="col-md-8">
				<h2 style="text-align: center">게시판</h2>
				
				<div>
					<a class="boarda" href="/board/registboardform">글 작성</a>
				</div>

				<table class="table table-hover">
					<thead>
						<tr>
							<th>글 번호</th>
							<th>작성자</th>
							<th>제목</th>
							<th style="width: 400px">내용</th>
							<th>상세보기</th>
						</tr>
					</thead>
					<tbody id="boardlistbody">

					</tbody>
				</table>
			</div>


			<!-- 전체게시판 끝 -->

			<!-- 세부게시판 시작-->
			<div id="boardinfolist" class="col-md-4 row">

			</div>
			<!-- 세부게시판 끝-->
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