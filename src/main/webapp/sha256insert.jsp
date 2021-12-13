<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>로그인 화면</title>
<style type="text/css">
body{
    padding: 0px;
    background-color: gainsboro;
}

#loginTitle{
	width: 200px;
    height: 100px;
	margin-top: 180px;
	margin-left: 900px;
}

#loginbox{
	width: 400px;
    height: 300px;
	margin-top: 80px;
	margin-left: 800px;
}
#id, #pwd, #btn1{
	margin-bottom: 20px; 
}
</style>
</head>
<body>

		<div id="loginTitle">
			<h1> LOG IN</h1>
		</div>

			<div id="loginbox">
				<form action="shainsert" method="post">
					
					<input type="text" id="id" name="id" placeholder="아이디를 입력해주세요" style="width: 350px; height: 50px;">
					<br>
					<input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력해주세요" style="width: 350px; height: 50px;">
					<%-- <span style="color: red;"><%=session.getAttribute("message1") %></span> --%>
					 <br>
					 
					<input type="submit" value="가입하기" class="btn btn-success btn-block" id="btn1" style="width: 350px; height: 50px;">
					<button type="button" onclick="history.back(-1);" class="btn btn-success btn-block" style="width: 350px; height: 50px;">돌아가기</button> 
				</form>
			</div>			

	
</body>
</html>