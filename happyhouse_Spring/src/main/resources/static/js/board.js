$(() => {

         let pg = 1;
         let key = "";
         let word = "";

         $.ajax({
            url : "/board?&pg=1&key=&word=",
            type : "GET",
            contentType:'application/json;charset=utf-8',
            dataType:'json',
            success:function(datas) {
                console.log(datas);
                makeList(datas);
            },
            error:function(xhr, status, error){
                console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
            }

     });
     
     
     function makeList(datas){
         
         $("#boardlistbody").empty();
         
         if(datas.BoardDTO == 0){
              let str = `<h4 class="text-center mt-5">검색 결과가 없습니다</h4>`;
              $("#boardlistbody").append(str);
         }
         
         else{
              $.each(datas.BoardDTO, function(index, data) {
                  

                  let str = `<tr id="" class="">
                          <td><a class="boardselectlink" href="/board/selectboard?no=${data.no}&id=${data.id}">${data.subject}</a></td>    
                        <td>${data.id}</td>
                        <td>${data.no}</td>    
                        <td>${data.search}</td>                        
                    </tr>`;
                $("#boardlistbody").append(str);
                    
                });
              $("#boardlistbody").append(datas.PageNavigation.navigator);
              
              // 페이지 넘겼을때
              $(".page-item").click(function () {
                  // 맵 마커 가져오기
                 
                  // 아파트 리스트 가져오기
                        let pg = $(this).attr("data-pg");
                        let key = datas.listParameterDTO.key;
                        let word = datas.listParameterDTO.word;
                        
                         $.ajax({
                                url : "/board?&pg="+pg+"&key="+key+"&word="+word,
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
     
    // 키워드 검색했을때
        $("#word-btn").click(function () { 
            let pg = 1;
            let key = $('select[name=key]').val();
            let word = $('input[name=word]').val();
            
             $.ajax({
                    url : "/board?&pg=1&key="+key+"&word="+word,
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