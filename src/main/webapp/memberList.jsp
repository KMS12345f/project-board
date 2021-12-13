<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<title>회원목록</title>
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
        
			<table class="table table-hover">

				<tr>
					<td style="width: 20%">이름</td>
					<td style="width: 20%">휴대전화</td>
					<td style="width: 20%">성별</td>
					<td style="width: 20%">가입일</td>
					<td style="width: 20%">부가사항</td>
				</tr>

				<c:forEach var="list" items="${list}">

				<tr>
					<td style="width: 20%"><a href="oneList?id=${list.id}" style="text-decoration: none; color: black;" id="name"> ${list.name}</a></td>
					<td style="width: 20%">${list.phone}</td>
					<td style="width: 20%">${list.gender}</td>
					<td style="width: 20%"><fmt:formatDate value="${list.regDate1}" type="date" pattern="yyyy-MM-dd" /></td>
					<td style="width: 20%">
					<button type="button" onclick="location.href='updateList?id=${list.id}'" class="btn btn-outline-dark">수정</button>
					<button type="button" onclick="location.href='deleteProcess?id=${list.id}'" class="btn btn-outline-dark">회원탈퇴</button>
					</td>
				</tr>
				
				</c:forEach>
			</table>
			
				<div>
				
					<form action="searchMember" method="get">
					
					<select name="userName">
						<option value="userName">회원이름</option>
					</select>
						<input type="text" name="name">
					
						<input type="submit" value="검색" class="btn btn-outline-dark">
					
					</form>
					
				</div>
			
				<div style="float: right;">
					<button type="button" onclick="location.href='memberInsert.jsp'" class="btn btn-outline-dark">회원추가</button>
					<button type="button" onclick="history.back(-1);" class="btn btn-outline-dark">돌아가기</button>
				</div>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>

</div>

</body>
</html>