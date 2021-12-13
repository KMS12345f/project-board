<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<style type="text/css">
body{
	background-image: url('main.jpg');
	background-repeat : no-repeat;
 	background-size: cover;
 	font-family: 'KOTRA_BOLD-Bold';
}
@font-face {
    font-family: 'KOTRA_BOLD-Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-10-21@1.1/KOTRA_BOLD-Bold.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}


#title{
	margin-top: 230px;
	margin-left: 960px;
	width: 500px;
	height: 200px;
	line-height: 160px;
	font-size: 2em;
	transform: rotate(2deg);
}
#menu{
	margin-top: 160px;
	margin-left: 940px;
	width: 500px;
	height: 200px;
	line-height: 160px;
	display: flex;
	justify-content: space-between;
}
</style>
</head>
<body>
	
	
	
<div class="wrap">

		<div id="title"  class="wrap-item">
			<h1 style="color: white"> 게시판 첫 걸음...</h1>
		</div>

		<div id="menu" class="wrap-item">
 			<c:choose>
				<c:when test="${userId == null}">
			
					<h1><a href="login.jsp" style="text-decoration: none; color: white;">로그인</a></h1>
					<h1><a href="memberInsert.jsp" style="text-decoration: none; color: white">회원가입</a></h1>
					<h1><a href="BoardView" style="text-decoration: none; color: white;" id="boardButton">게시판</a></h1>
	
				</c:when>
	
				<c:when test="${userId == 'admin'}">
		
					<h2><a href="list" style="text-decoration: none; color: white; font-size: 32px;">회원리스트</a></h2>
					<h2><a href="BoardView" style="text-decoration: none; color: white; font-size: 32px;">게시판</a></h2>
					<h2><a href="#" id="btnLogout" style="text-decoration: none; color: white; font-size: 32px;">로그아웃</a></h2>
	
				</c:when>
		
				<c:otherwise>
	
					<c:forEach var="list" items="${list}">
					<h1><a href="oneList?id=${list.id}" style="text-decoration: none; color: white; font-size: 32px;">myPage</a></h1>
					</c:forEach>
					<h1><a href="BoardView" style="text-decoration: none; color: white; font-size: 32px;">게시판</a></h1>
					<h1><a id="btnLogout" href="#" style="text-decoration: none; color: white; font-size: 32px;" >로그아웃</a></h1>
					
				</c:otherwise>
	
	
			</c:choose>
		</div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<script type="text/javascript">

	$(function(){
	
		$("#btnLogout").click(function(){
			location.href="Logout"
			
		});
		
		$("#boardButton").click(function(){
			alert("로그인을 해주세요")
			event.preventDefault();
		});
	});

</script>
</body>
</html>