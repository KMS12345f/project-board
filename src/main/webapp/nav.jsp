<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style type="text/css">
/* navbar 부분 */
#navigate{
    width: 100%;
    height: 8vh;
    margin-top: 5px;
    display: flex;

}
#nlogo{
    margin-left: 80px;
}
#collapsibleNavbar{
    margin-left: 100px;
}
#dropdowNav{
    margin-left: auto;
    margin-right: 100px;
}
</style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark" id="navigate">
  <div class="container-fluid" id="nlogo">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#">공지사항</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="BoardView">자유게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">게시판준비중...</a>
        </li>
        </ul>
        
        <c:if test="${userId != null}">
        <div class="dropdown" style="margin-left: auto;">
        	<button type="button" class="btn btn-dark dropdown-toggle" data-toggle="dropdown">
		      <%=session.getAttribute("message2")%>
		    </button>
		 		<div class="dropdown-menu">
		 			<c:choose>
		 				<c:when test="${userId == 'admin'}">
		 					<a class="dropdown-item" href="list">회원관리</a>
		 				</c:when>
		 				
		 				<c:otherwise>
		 					<a class="dropdown-item" href="oneList?id=<%=session.getAttribute("userId")%>">My page</a>
		 				</c:otherwise>
		 				
		 			</c:choose>
		 					
			     			<a class="dropdown-item" href="#" id="btnLogout">로그아웃</a>
			    </div>
		</div>
		</c:if>
  		
    </div>
  </div>
</nav>

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<script type="text/javascript">

	$(function(){
	
		$("#btnLogout").click(function(){
			location.href="Logout"
			
		});

	});
</script>
</body>
</html>