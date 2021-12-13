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
    height: 65vh;
    margin-left: 300px;
}
#commentall{
	width: 70%;
	height: 20vh;
	
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
						<td style="width: 8%">${list.fnum}</td>
						<td style="width: 70%">${list.title}</td>
						<td style="width: 14%">${list.writer}</td>
						<td style="width: 8%">${list.viewCount+1}</td>
					</tr>
					
					<tr>
						<td>내용</td>
						<td colspan="3">${list.content}</td>
					</tr>
				
				</c:forEach>
			</table>
		</div>
				
				

				<div id="commentList">
					<table id="resultTable" border="1">
						<tr>
							<td id="commentCode">번호</td>
							<td>작성자</td>
							<td id="comment">댓글</td>
							<td id="crg">작성일</td>
							<td id="cde">삭제하기</td>
						</tr>

					</table>
				</div>
	
	
				<div id="commentinsert">
					<form action="">
						<input type="text" id="content" name="content" style="width: 100px; height: 50px;">
				
						<input type="submit" value="댓글작성">
					</form> 

				</div>
			
			</div>
	
				
			<div id="btngroup" style="float:right;">
				<c:forEach var="list" items="${list}">
					<button type="button" class="btn btn-outline-dark" onclick="location.href='BoardUpdateList?writer=${list.writer}&fnum=${list.fnum}'">수정하기</button>
					<button type="button" class="btn btn-outline-dark" onclick="location.href='BoardDelete?writer=${list.writer}&fnum=${list.fnum}'">글삭제</button>
				</c:forEach>
					<button type="button" class="btn btn-outline-dark" onclick="location.href='BoardView'">돌아가기</button>
				</div>
			</div>

        
	<jsp:include page="footer.jsp"></jsp:include>

    </div>



</body>
</html>