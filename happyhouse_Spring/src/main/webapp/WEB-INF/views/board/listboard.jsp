<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>

<html lang="en">
<head>
<style>
		*{
			margin:0;
			padding:0;
		}
		.container{
			width: 500px;
			margin: 0 auto;
			padding: 25px
		}
		.container h3{
			text-align: left;
			padding: 5px 5px 5px 15px;
			color: #FFBB00;
			border-left: 3px solid #FFBB00;
			margin-bottom: 20px;
		}
		.chating{
			background-color: #000;
			width: 500px;
			height: 500px;
			overflow: auto;
		}
		.chating p{
			color: #fff;
			text-align: left;
		}
		input{
			width: 330px;
			height: 25px;
		}
		#yourMsg{
			display: none;
		}
</style>



<%@include file="/WEB-INF/views/head/boardhead.jsp" %>

<script type="text/javascript">
	var ws;
	
	function wsOpen(){
		ws = new WebSocket("ws://" + location.host + "/chating");
		wsEvt();
	}
		
	function wsEvt() {
		ws.onopen = function(data){
			//소켓이 열리면 초기화 세팅하기
		}
		
		ws.onmessage = function(data) {
			var msg = data.data;
			if(msg != null && msg.trim() != ''){
				$("#chating").append("<p>" + msg + "</p>");
			}
		}
	
		document.addEventListener("keypress", function(e){
			if(e.keyCode == 13){ //enter press
				send();
			}
		});
	}
	
	function chatName(){
		var userName = $("#userName").val();
		if(userName == null || userName.trim() == ""){
			alert("사용자 이름을 입력해주세요.");
			$("#userName").focus();
		}else{
			wsOpen();
			$("#yourName").hide();
			$("#yourMsg").show();
		}
	}
	
	function send() {
		var uN = $("#userName").val();
		var msg = $("#chatting").val();
		ws.send(uN+" : "+msg);
		$('#chatting').val("");
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
        	<h2 style="text-align: center">게시판</h2>
            <!-- 전체게시판 시작 -->
            <div id="map" class="col-md-7">
                
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
                         <div>
		                    <a class="boarda" href="/board/boardregistform">글 작성</a>
		                </div>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="col-md-2">글번호</th>
                                    <!-- <button id="nosort" type="button" class="btn btn-light" onclick="sort(this.id)"    >▼</button> -->
                                    <th class="col-md-2">작성자</th>
                                    <th class="col-md-6">제목</th>
                                    <th class="col-md-3">조회수</th>
                                    <!-- <button id="searchsort" type="button" class="btn btn-light" onclick="sort(this.id)">▼</button> -->
                                </tr>
                            </thead>
                            <tbody id="boardlistbody">
                            </tbody>
                        </table>
                        
                        <div id="paging">
                        </div>
                    </div> 
					<div class="container col-md-5">
						<h3>채팅</h3>
						<div id="chating" class="chating"></div>
						
						<div id="yourName">
							<table class="inputTable">
								<tr>
									<th>사용자명</th>
									<th><input type="text" name="userName" id="userName" placeholder="사용할 이름 입력"></th>
									<th><button onclick="chatName()" id="startBtn">이름 등록</button></th>
								</tr>
							</table>
						</div>
						<div id="yourMsg">
							<table class="inputTable">
								<tr>
									<th>메시지</th>
									<th><input id="chatting" placeholder="메시지 입력."></th>
									<th><button onclick="send()" id="sendBtn">보내기</button></th>
								</tr>
							</table>
						</div>
					</div>
            <!-- 전체게시판 끝 -->
        </div>
        <!-- 게시판 끝 -->
        
        </div>
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

