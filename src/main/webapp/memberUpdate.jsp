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
<title>회원수정</title>
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
input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
    autocomplete : off;
	size : 4; 
	maxlength : 4; 
	required : required;
    
}

</style>
</head>
<body>

<div id="wrap">

        <jsp:include page="top.jsp"></jsp:include>

        
        <jsp:include page="nav.jsp"></jsp:include>

        
        <div id="content">
        
			<form action="updateProcess" method="get">
			
				<table class="table">
				
					<tr>
						<td style="width: 10%">아이디</td>
						<td style="width: 8%">이름</td>
						<td style="width: 25%">휴대전화</td>
						<td style="width: 12%">생년월일</td>
						<td style="width: 22%">이메일</td>
						<td style="width: 7%">성별</td>
						<td style="width: 16%">가입일</td>
					</tr>
					
					<c:forEach var="list" items="${list}">

					<tr>
						<td style="width: 10%"><input type="text" name="id" id="id" value="${list.id}" readonly="readonly" style="text-align: center; border:0 solid black;"></td>
						<td style="width: 8%"><input type="text" name="name" id="name" placeholder="이름을 입력해주세요" autocomplete="off" required="required"></td>
						<td style="width: 25%"><input type="number" name="phone1" id="phone1" autocomplete="off" size="3" maxlength="3" required="required">
						-<input type="number" name="phone2" id="phone2" autocomplete="off" size="4" maxlength="4" required="required">
						-<input type="number" name="phone3" id="phone3" autocomplete="off" size="4" maxlength="4" required="required"></td>
						<td style="width: 12%">${list.birth}</td>
						<td style="width: 22%"><input type="email" name="email" id="email" placeholder="메일주소를 입력해주세요" required="required"></td>
						<td style="width: 7%">${list.gender}</td>
						<td style="width: 16%">${list.regDate1}</td>
					</tr>
					
					</c:forEach>
				</table>
					<div id="btngroup" style="margin-top: 400px;">
					<input type="submit" value="수정완료" class="btn btn-outline-dark">
					<input type="reset" value="초기화" class="btn btn-outline-dark">
					<button type="button" onclick="history.back(-1);" class="btn btn-outline-dark">돌아가기</button>
					</div>
			</form>

		</div>
		
		
		<jsp:include page="footer.jsp"></jsp:include>
</div>

</body>
</html>