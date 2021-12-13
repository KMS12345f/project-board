<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<title>글 작성</title>
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
        
 			
			<form action="boardInsert" method="get">
			
				<div style="display: flexbox;">		
				<table class="table">
					<tr>
						<td style="width: 20%; line-height: 30px;">제목</td>
						<td style="width: 80%"><input type="text" id="title" name="title" style="width: 80%; height: 30px;"></td>
					</tr>
					<tr>
						<td style="width: 20%">작성자</td>
						<td style="width: 80%"><input type="text" name="writer" value="<%=session.getAttribute("userId")%>" readonly="readonly" style="border:0 solid black; float: left; margin-left: 100px;"></td>
					</tr>
					<tr>
						<td style="width: 20%; line-height: 300px;">내용</td>
						<td style="width: 80%; white-space: pre;"><textarea rows="15" cols="110" id="text" name="text"></textarea></td>
					</tr>
				</table>
				
				</div>
				
				<input type="submit" value="작성하기" class="btn btn-outline-dark">
				<input type="reset" value="초기화" class="btn btn-outline-dark">
				<button type="button" onclick="history.back(-1);" class="btn btn-outline-dark">돌아가기</button>
				
			</form>
        </div>

		<jsp:include page="footer.jsp"></jsp:include>
    </div>

</body>
</html>