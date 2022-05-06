<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- EmailJS-->
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/@emailjs/browser@3/dist/email.min.js"></script>

<link rel="shortcut icon" href="/img/home.png" />

<!-- bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- index.js -->
<script type="text/javascript" src="/js/index.js"></script>

<!-- map -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=32d4bf5a63d1251f73331370dbb8f363&libraries=services"></script>
	
<script>
    $(document).ready(function () {
		$.ajax({
		    url: "${root}/address/sido?sidoName=&gugunName=&dongName=",
		    type: "GET",
		    contentType:'application/json;charset=utf-8',
		    dataType: "json",
		   
		    success: function (data) {
		    	console.log(data);
		    	makesidoList(data)
		    },
		    error: function (xhr, status, msg) {
		    	
		      console.log("상태값 : " + status + " Http에러메시지 : " + msg);
		    },
		  });
		
		function makesidoList(data) {
			$("#sido").empty().append("<option>도/광역시</option>");
			$.each(data.sidolist, function(index, vo) {
				$("#sido").append("<option value='"+vo.sidoName+"'>"+vo.sidoName+"</option>");
			});
		}
		
		var sido = "";
		 $(document).on("change", "#sido", function (){
			 sido = $(this).val();
				 $.ajax({
					    url: "${root}/address/gugun?sidoName="+sido+"&gugunName=&dongName=",
					    type: "GET",
					    contentType:'application/json;charset=utf-8',
					    dataType: "json",
					   
					    success: function (data) {
					    	 makegugunList(data)
					    },
					    error: function (xhr, status, msg) {
					      console.log("상태값 : " + status + " Http에러메시지 : " + msg);
					    },
			});
		 });
		 
		 function makegugunList(data) {
			 $("#gugun").empty().append("<option>시/군/구</option>");
			 $.each(data.gugunlist, function(index, vo) {
					$("#gugun").append("<option value='"+vo.gugunName+"'>"+vo.gugunName+"</option>");
				});
			}
		 
		 $(document).on("change", "#gugun", function (){
			 gugun = $(this).val();
				 $.ajax({
					    url: "${root}/address/dong?sidoName="+sido+"&gugunName="+gugun+"&dongName=",
					    type: "GET",
					    contentType:'application/json;charset=utf-8',
					    dataType: "json",
					   
					    success: function (data) {
					    	 makedongList(data)
					    },
					    error: function (xhr, status, msg) {
					      console.log("상태값 : " + status + " Http에러메시지 : " + msg);
					    },
			});
		 });
		 
		 function makedongList(data) {
			 $("#dong").empty().append("<option>동</option>");
			 $.each(data.donglist, function(index, vo) {
					$("#dong").append("<option value='"+vo.dongName+"'>"+vo.dongName+"</option>");
				});
		}
	});
</script>

<link href="/css/index.css" rel="stylesheet" type="text/css">

<!-- icon -->
<script src="https://kit.fontawesome.com/437ed9bce7.js" crossorigin="anonymous"></script>