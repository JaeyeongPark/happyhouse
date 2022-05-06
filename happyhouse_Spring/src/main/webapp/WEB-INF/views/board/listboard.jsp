<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>

<html lang="en">
<head>

<%@include file="/WEB-INF/views/head/boardhead.jsp" %>

<script type="text/javascript">




function sort(sort){
    console.log(sort);
    $.ajax({
        url : "/board/search/"+sort,
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
            <div class="col-md-1"></div>
            <!-- 전체게시판 시작 -->
            <div id="map" class="col-md-10">
                <h2 style="text-align: center">게시판</h2>
                
                <div>
                    <a class="boarda" href="/board/boardregistform">글 작성</a>
                </div>

                        <div id="board-search">
                                <input type="hidden" name="pg" value="1">
                                <select class="col border m-2" style="height: 40px;" name="key">
                                    <option value="id">아이디
                                    <option value="subject">제목
                                    <option value="contents">내용
                                </select> 

                                <input type="text" class="col ml-1 form-control" name="word">
                                <button type="button" class="col btn btn-outline-primary"
                                    id="word-btn">검색</button>
                        </div>
                        
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>제목</th>
                                    <!-- <button id="nosort" type="button" class="btn btn-light" onclick="sort(this.id)"    >▼</button> -->
                                    <th>작성자</th>
                                    <th>글번호</th>
                                    <th>조회수</th>
                                    <!-- <button id="searchsort" type="button" class="btn btn-light" onclick="sort(this.id)">▼</button> -->
                                    
                                </tr>
                            </thead>
                            <tbody id="boardlistbody">
                            </tbody>
                        </table>
                        
                    </div>
                    <div class="col-md-1"></div>

            <!-- 전체게시판 끝 -->


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

