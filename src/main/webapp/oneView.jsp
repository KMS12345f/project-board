<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script> -->
<style type="text/css">
body{
    padding: 0px;
}
/* 큰 박스들 */
#wrap{
    width: 100%;
    height: 100vh;
}

#content{
    width: 70%;
    height: auto;
    margin-left: 300px;
}
#commentStart{
	width: 70%;
	height: auto;
	margin-left: 300px;
}
#commentList{
	width: 70%;
	height: auto;
	margin-left: 300px;
	margin-bottom: 10px;
}
#commentinsert{
	width: 70%;
	height: auto;
	margin-left: 300px;
}
#btngroup{

}
</style>
</head>
<body>

	<div id="wrap">

        <jsp:include page="top.jsp"></jsp:include>

        
        <jsp:include page="nav.jsp"></jsp:include>

        
        <div id="content" style="display: flex; flex-direction: column;">
            <div >
                <table class="table table-hover">

					<tr>
						<td style="width: 8%">번호</td>
						<td style="width: 70%">제목</td>
						<td style="width: 14%">작성자</td>
						<td style="width: 8%">조회수</td>
					</tr>
				
				<c:forEach var="list" items="${list}">
					<tr>
						<td style="width: 8%"><input type="hidden" id="fnum" value="${list.fnum}">${list.fnum}</td>
						<td style="width: 70%">${list.title}</td>
						<td style="width: 14%"><input type="hidden" id="writer" value="${list.writer}"> ${list.writer}</td>
						<td style="width: 8%">${list.viewCount+1}</td>
					</tr>
					
					<tr>
						<td>내용</td>
						<td colspan="3" style="white-space:pre-wrap;">${list.content}</td>
					</tr>
				
				</c:forEach>
			</table>
			</div>
		</div>
			
			<div id="commentStart">
				<h1> 댓글 </h1>
			</div>
			
			<div id="commentList">
					<table id="resultTable1" class="table">
						<tr>
							<td>번호</td>
							<td>작성자</td>
							<td>댓글</td>
							<td>작성일</td>
							<td>삭제여부</td>
						</tr>

					</table>
				</div>	
		
		<div id="commentinsert">
		
			댓글 입력 : <input type="text" id="comtext" name="comtext">
			작성자 : <input type="text" id="comwriter" name="comwriter" value="${userId}">
		<button type="button" id="commentbtn" class="btn btn-outline-dark">댓글작성</button>	
	
	
				
				

				</div>
	
			<div id="btngroup" style="float:right; margin-right: 250px;">
			 		<c:forEach var="list" items="${list}"> 
					<button type="button" class="btn btn-outline-dark" onclick="location.href='BoardUpdateList?writer=${list.writer}&fnum=${list.fnum}'">수정하기</button>
					<button type="button" class="btn btn-outline-dark" onclick="location.href='BoardDelete?writer=${list.writer}&fnum=${list.fnum}'">글삭제</button>
					 </c:forEach>
					<button type="button" class="btn btn-outline-dark" onclick="location.href='BoardView'">돌아가기</button>
				
			</div>

        
		<jsp:include page="footer.jsp"></jsp:include>
	

    </div>

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<script type="text/javascript">

	$(function(){
		$(document).ready(function(){
			var fnum = $("#fnum").val();
			
			 $.ajax({
			      url : "/project/Comment",   
			      type : "POST",   
			      data : {fnum:fnum},
			      success : function(data) {
			          console.log('log---------'+data);
			          
			          
			          var tableElement = "<tr>"; 

		               $.each(data , function(i){
		                   var cfnum = data[i].fnum;
		                   var cnum = data[i].cnum;  
		                   var writer = data[i].writer;  
		                   var comment = data[i].comment;  
		                   var regDate3 = data[i].regDate3;  
		                   var idNo = "cdelete"+cnum;

		                 tableElement += '<td id="cnum">'
		                 			+ cnum
		                	 		+ '</td><td id="writer">' 
		                            + writer
		                            + '</td><td id="comment">' 
		                            + comment 
		                            + '</td><td id="regDate3">' 
		                            + regDate3 
		                             + '</td><td id="cde">'
		                             +'<a id="'+idNo+'"class="btn btn-outline-light text-dark ml-right "  href="#" >삭제하기</a>' 
		                            +'</td>';
		                 tableElement += '</tr>';
		                 
		                 $(document).on("click", "#"+idNo, function() {
			                  
			                     if("${userId}"=="admin"){
			                         if(!confirm('정말 삭제하시겠습니까?')){
			                        	 alert("취소하였습니다!")
			                        	 return false;
			                          }else {
			                            location.href='CommentDelete?cnum='+cnum;
			                            location.reload(); 
			                          }

			                    }else{
			                        if("${userId}"==writer){
			                             if(!confirm('정말 삭제하시겠습니까?')){
			                            	 alert("취소하였습니다!")
			                                 return false;
			                              }else {
			                                location.href='CommentDelete?cnum='+cnum;
			                                location.reload(); 
			                              }
			                        }else{
			                           alert("권한이 없습니다.")
			                           return false;
			                        }    
			                    } 
			                    
			                  });
		                 
		               });
		               
		               $("#resultTable1").append(tableElement);
			      },
			      error : function(request, status, error) {
		              alert("code:"+request.status);
		              alert("CommemtView에러");
		                       
		     	 }   
			      
			  })
		})
		
		 $("#commentbtn").on("click",function(){
         var fnum = $("#fnum").val()
         var comtext = $("#comtext").val()
         var comwriter = $("#comwriter").val()

          $.ajax({
               url : "/project/CommentInsert",   
               type : "get",  
               data : {fnum:fnum, comtext:comtext, comwriter:comwriter},
               success : function(data) {          
                   location.reload();                                 
                   
                   
                       },
               error : function(request, status, error) {
                       alert("code:"+request.status);
                       alert("CommemtView에러");
                                
               }   
         })

		
		
		 })
		
	}); 
		

</script>

</body>
</html>