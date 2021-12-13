<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
    width: 70%;
    height: 60vh;
    margin-left: 300px;
}
.td1{
	text-align: center;
}
.td2{
	margin-left: 300px;
}
#btngroup{
	display: flex;
	justify-content: center;
}
input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
</style>
</head>
<body>

<div id="wrap">

        <jsp:include page="top.jsp"></jsp:include>

        
        <jsp:include page="nav.jsp"></jsp:include>

        
        <div id="content">
			<br>
		<form action="memberProcess" method="post">
		<table class="table table-hover">
		
			<tr>
				<td style="width: 20%" class="td1">아이디(*)</td>
				<td style="width: 40%" class="td2"><input type="text" name="id" id="id" placeholder="아이디를 입력해주세요" autocomplete="off" required="required" size="40">
				<button type="button" id="idbtn" class="btn btn-outline-dark">중복확인</button></td>
			</tr>
			
			<tr><td colspan="3"><div id="idCh" style="text-align: center;"></div></td></tr>

			
			<tr>
				<td style="width: 20%" class="td1">비밀번호(*)</td>
				<td style="width: 40%" class="td2"><input type="password" name="pwd" id="pwd" placeholder="비밀번호를 입력해주세요" autocomplete="off" required="required" size="40"></td>
			</tr>
						
			<tr>
				<td style="width: 20%" class="td1">비밀번호 확인(*)</td>
				<td style="width: 40%" class="td2"><input type="password" name="pwd2" id="pwd2" placeholder="비밀번호 확인" autocomplete="off" required="required" size="40"></td>
			</tr>			
							
						
			<tr>
				<td colspan="3"><div id="passCheck" style="text-align: center;"></div></td>
			</tr>			
		
			<tr>
				<td style="width: 20%" class="td1">이름(*)</td>
				<td style="width: 40%" class="td2"><input type="text" name="name" id="name" placeholder="이름을 입력해주세요" autocomplete="off" required="required" size="40"></td>
			</tr>		

			<tr>
				<td style="width: 20%" class="td1">전화번호(*)</td>
				<td style="width: 40%" class="td2"><input type="number" name="phone1" id="phone1" autocomplete="off" maxlength="3" required="required" size="13">
				- <input type="number" name="phone2" id="phone2" autocomplete="off" maxlength="4" required="required" size="13">
				- <input type="number" name="phone3" id="phone3" autocomplete="off" maxlength="4" required="required" size="13"></td>
			</tr>
			
			<tr>
				<td style="width: 20%" class="td1">생년월일</td>
				<td style="width: 40%" class="td2"><input type="date" name="birth" id="birth" size="40"></td>
			</tr>

			<tr>
				<td style="width: 20%" class="td1">이메일</td>
				<td style="width: 40%" class="td2"><input type="email" name="email" id="email" placeholder="메일주소를 입력해주세요" size="40"></td>
			</tr>
			
			<tr>
				<td style="width: 20%" class="td1">성별</td>
				<td style="width: 40%" class="td2">남자<input type="radio" name="gender" id="gender" value="남자"> 여자<input type="radio" name="gender" id="gender" value="여자"></td>
			</tr>
	
		</table>

			<br>
			<div id="btngroup">
				<input type="submit" value="가입하기" id="okbutton" class="btn btn-outline-dark" style="margin-right: 20px;">
				<input type="reset" value="초기화" class="btn btn-outline-dark" style="margin-right: 20px;">
				<button type="button" onclick="history.back(-1);" class="btn btn-outline-dark">돌아가기</button>
			</div>
		</form>

		</div>

		<jsp:include page="footer.jsp"></jsp:include>

</div>

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    
<script type="text/javascript">

	$(function(){
		var isnum = false;
		var pis = false;

		$("#idbtn").click(function(){
			var id = $("#id").val();
			
			$.ajax({
				url : "idCheck",
				type : "POST",
				data : {id:id},
				success : function (data) {
					
					if(data == 1){
						
						$("#idCh").text("중복된 아이디 입니다.")
						.css({"color":"red"});
						return isnum = false;
					}else if(data == 2){
						$("#idCh").text("아이디를 입력해 주세요.")
						.css({"color":"red"});
						return isnum = false;
					}else if(data == 0){
						$("#idCh").text("입력 가능한 아이디 입니다.")
						.css({"color":"blue"});
						return isnum = true;
					}
				},
				error : function(request, status, error){
					alert("에러");
					alert("code:"+request.status);
				}
			})
		}) 
		
		$("#pwd2").focusout(function(){
			
            var pwd = $("#pwd").val();
            var pwd2 = $("#pwd2").val();
            
            if(pwd == ""){
                $("#passCheck").text("비밀번호는 공백이 불가합니다.")
                .css({"color":"red"})
                return pis = false;
            }else if(pwd2 == ""){
                $("#passCheck").text("비밀번호는 공백이 불가합니다.")
                .css({"color":"red"})
                return pis = false;
            }else if(pwd == pwd2){
                $("#passCheck").text("비밀번호가 일치합니다.")
                .css({"color":"blue"})
                return pis = true;                
            }else if(pwd != pwd2){
                $("#passCheck").text("비밀번호가 일치하지않습니다.")
                .css({"color":"red"})
                return pis = false;
            }
            })	
		
		$("#okbutton").click(function(){
			if(isnum == false){
                alert("아이디 중복확인 확인해주세요.")
                event.preventDefault();
            }
			
            if(pis == false){
                    alert("비밀번호를 확인해주세요.")
                    event.preventDefault();
                }
            })
		
	});

</script>

</body>
</html>