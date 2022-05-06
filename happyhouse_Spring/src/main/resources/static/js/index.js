 var map, marker;
 var markers = [];
 
$(() => {
	
	// 이메일 api시작하기
  (function(){ 
    emailjs.init("uPrm0nkV2Rv9Li7gd"); 
  })();
  
  // 맵 가져오기
  var container = document.getElementById('map'); // 지도를 담을 영역의 DOM 레퍼런스
  var options = { // 지도를 생성할 때 필요한 기본 옵션
    center: new kakao.maps.LatLng(37.5012743, 127.039585), // 지도의 중심좌표.
    level: 5 // 지도의 레벨(확대, 축소 정도)
  };
  map = new kakao.maps.Map(container, options); // 지도 생성 및 객체 리턴

  // 주소를 통한 아파트검색
  $("#search-btn").on("click", () => {
	 	 let sido = $("#sido").val();
		 let gugun = $("#gugun").val();
		 let dong = $("#dong").val();
		 let pg = 1;
		 let key = "";
		 let word = "";
	    
		 $.ajax({
			url : "/apt?sidoName="+sido+"&gugunName="+gugun+"&dongName="+dong+"&pg=1&key=&word=",
			type : "GET",
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			success:function(datas) {
				makeList(datas);
			},
			error:function(xhr, status, error){
				console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
			}
		});

	//location.href = "/locationSearch.html";
	});
  
  //아파트 리스트 가져오기
  function makeList(datas){
		 $("#apt-list").empty();
		 
		 if(datas.AptDTO == 0){
			 
			  let str = `<h4 class="text-center mt-5">검색 결과가 없습니다</h4>`;
			  $("#apt-list").append(str);
		 }
		 
		 else{
			 
			 //맵 마거 가져오기
			  $.each(datas.AptDTO, function(index, data) {
				  var moveLatLon = new kakao.maps.LatLng(data.lat, data.lng);
			        var imageSrc = "img/marker_map_icon.png", // 마커이미지의 주소입니다
			          imageSize = new kakao.maps.Size(50, 50), // 마커이미지의 크기입니다
			          imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

			        // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
			        var markerImage = new kakao.maps.MarkerImage(
			          imageSrc,
			          imageSize,
			          imageOption
			        );
			        // 마커를 생성합니다
			       marker = new kakao.maps.Marker({
			          map: map,
			          position: moveLatLon,
			          image: markerImage,
			        }); 
			        
			      var infowindow = new kakao.maps.InfoWindow({
			           content: `<div class="info-title"><span>아파트 이름: ${data.aptName}</span></div>` // 인포윈도우 내부에 들어갈 컨텐츠 입니다.
			         });

			         kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
			         kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
			     
			        // 지도 중심좌표를 접속위치로 변경합니다
			        markers.push(marker);
			        map.setCenter(moveLatLon);
				 
			        
			        //아파트 리스트 가져오기
					let str = `
						<div class="aptinfolist">
							<div class="aptNamelist">${data.aptName }</div>
							<div>거래 날짜 : ${data.dealYear }년 ${data.dealMonth }월 ${data.dealDay }일</div>
							<div>거래 금액 : ${data.dealAmount } <span class="won">(만)</span></div>

							<div>면적 : ${data.area }</div>
						</div>
						<hr>
					`;
					$("#apt-list").append(str);
					
				});
			  $("#apt-page").empty().append(datas.PageNavigation.navigator);
			  
			  //페이지 넘겼을때
			  $(".page-item").click(function () {
				  //맵 마커 가져오기
				  var moveLatLon = new kakao.maps.LatLng('${datas.AptDTO.lat}', '${datas.AptDTO.lng}');
			        var imageSrc = "img/marker_map_icon.png", // 마커이미지의 주소입니다
			          imageSize = new kakao.maps.Size(50, 50), // 마커이미지의 크기입니다
			          imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

			        // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
			        var markerImage = new kakao.maps.MarkerImage(
			          imageSrc,
			          imageSize,
			          imageOption
			        );
			        // 마커를 생성합니다
			       marker = new kakao.maps.Marker({
			          map: map,
			          position: moveLatLon,
			          image: markerImage,
			        }); 
			        
			      var infowindow = new kakao.maps.InfoWindow({
			           content: `<div class="info-title"><span>아파트 이름: ${datas.AptDTO.aptName}</span></div>` // 인포윈도우 내부에 들어갈 컨텐츠 입니다.
			         });

			         kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
			         kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
			     
			        // 지도 중심좌표를 접속위치로 변경합니다
			        markers.push(marker);
			        map.setCenter(moveLatLon);
				  
				  //아파트 리스트 가져오기
					 	let sido = datas.AddressDTO.sidoName;
						let gugun = datas.AddressDTO.gugunName;
						let dong = datas.AddressDTO.dongName;
						let pg = $(this).attr("data-pg");
						let key = datas.listParameterDTO.key;
						let word = datas.listParameterDTO.word;
						
						 $.ajax({
								url : "/apt?sidoName="+sido+"&gugunName="+gugun+"&dongName="+dong+"&pg="+pg+"&key="+key+"&word="+word,
								type : "GET",
								contentType:'application/json;charset=utf-8',
								dataType:'json',
								success:function(datas) {
									makeList(datas);
								},
								error:function(xhr, status, error){
									console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
								}
						});
						 
						
					});
		 }
	}

	

  	//키워드 검색했을때
	$("#word-btn").click(function () { 
		let sido = $("#sido").val();
		let gugun = $("#gugun").val();
		let dong = $("#dong").val();
		let pg = 1;
		let key = $('select[name=key]').val();
		let word = $('input[name=word]').val();
		
		 $.ajax({
				url : "/apt?sidoName="+sido+"&gugunName="+gugun+"&dongName="+dong+"&pg=1&key="+key+"&word="+word,
				type : "GET",
				contentType:'application/json;charset=utf-8',
				dataType:'json',
				success:function(datas) {
					makeList(datas);
				},
				error:function(xhr, status, error){
					console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
				}
			});
		
	 });

	
});

function makeOverListener(map, marker, infowindow) {
    return function () {
      infowindow.open(map, marker);
      var infoTitle = document.querySelectorAll('.info-title');
      infoTitle.forEach(function (e) {
        var w = e.offsetWidth + 10;
        var ml = w / 2;

        e.parentElement.previousSibling.style.display = "center";
        e.parentElement.parentElement.style.border = "0px";
        e.parentElement.parentElement.style.background = "unset";
      });
    };
  }

  // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
  function makeOutListener(infowindow) {
    return function () {
      infowindow.close();
    };
  }

