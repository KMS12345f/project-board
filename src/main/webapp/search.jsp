<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
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
    width: 80%;
    height: 65vh;
    margin-left: 200px;
}
/* content부분 */
td{
text-align: center;
}
</style>
</head>
<body>
    <div id="wrap">

        <jsp:include page="top.jsp"></jsp:include>

        
        <jsp:include page="nav.jsp"></jsp:include>

        
        <div id="content">
            <div style="display: flexbox;">
                <table class="table table-hover">

					<tr>
					<td style="width: 5%">번호</td>
					<td style="width: 55%">제목</td>
					<td style="width: 10%">작성자</td>
					<td style="width: 5%">조회수</td>
					<td style="width: 10%">작성시간</td>

					</tr>
				
				<c:forEach var="list" items="${list}">
					<tr>
					<td style="width: 5%">${list.fnum}</td>
					<td style="width: 55%"><a href="BoardOneView?fnum=${list.fnum}&viewCount=${list.viewCount}" style="color: black; text-decoration: none;" id="check1">${list.title}</a></td>
					<td style="width: 10%">${list.writer}</td>
					<td style="width: 5%">${list.viewCount}</td>
					<td style="width: 10%">${list.regDate2}</td>

				
				</tr>
				
				</c:forEach>
				</table>
				</div>
						
						<form action="Search" method="get">
							<select name="search">
								<option value="title">제목</option>
								<option value="writer">작성자</option>
								</select>
								<input type="text" name="searchvalue">
								<input type="submit" value="찾기" class="btn btn-outline-dark">
						
						</form>
				<div id="btngroup" style="float:right; margin-right: 25px;">
						<button type="button" class="btn btn-outline-dark" onclick="location.href='freeboard/insert.jsp'">작성하기</button>
						<button type="button" class="btn btn-outline-dark" onclick="history.back(-1);">돌아가기</button>
				</div>
			</div>

        
	<jsp:include page="footer.jsp"></jsp:include>

    </div>
</body>
</html>