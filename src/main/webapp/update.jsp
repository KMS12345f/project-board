<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<title>게시판 수정</title>
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
    height: 60vh;
    margin-left: 300px;
    text-align: center;
}
</style>
</head>
<body>

 <div id="wrap">

        <jsp:include page="top.jsp"></jsp:include>
        
        <jsp:include page="nav.jsp"></jsp:include>
        
       
        <div id="content">
        
        <form action="BoardUpdate" method="post">
        
        <div style="display: flexbox;">	
        
        <table class="table">
        
        	<tr>
				<td style="width: 8%">번호</td>
				<td style="width: 84%">제목</td>
				<td style="width: 8%">작성자</td>
			</tr>
			
			<c:forEach var="list" items="${list}">
			
			<tr>
				<td style="width: 8%"><input type="text" name="fnum" value="${list.fnum}" readonly="readonly" style="text-align: center; border:0 solid black;"></td>
				<td style="width: 84%"><input type="text" name="title" required="required" autocomplete="off" style="width: 700px;"></td>
				<td style="width: 8%"><input type="text" name="writer" value="${list.writer}" readonly="readonly" style="text-align: center; border:0 solid black;"></td>
			</tr>
			
			<tr>
				<td style="width: 45%; line-height: ">내용</td>
				<td colspan="3"><textarea rows="16" cols="120" name="content" autocomplete="off" required="required" style="float: left;"></textarea></td>
			</tr>
			
			</c:forEach>
		</table>
        </div>
        
        <c:forEach var="list" items="${list}">
			<input type="submit" value="수정완료" class="btn btn-outline-dark">
			<button type="button" onclick="location.href='BoardView'" class="btn btn-outline-dark">돌아가기</button>
		</c:forEach>

       	
		</form>
    </div> 

	<jsp:include page="footer.jsp"></jsp:include>

</div>

</body>
</html>