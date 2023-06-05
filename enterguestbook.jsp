<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width", initial-scale="1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<title>방명록 입력</title>
</head>
<script type="text/javascript">
function validateInput() {
	  var id = document.getElementById("id").value;
	  var email = document.getElementById("email").value;
	  var title = document.getElementById("titel").value;
	  var password = document.getElementById("password").value;
	 
	  if (id === "" || email === "" || title === "" || password === "") {
		    alert("모든 입력란을 채워주세요.");
	  } else{ 
		  }   
	  }
</script>
<body>
	<div class="enter-guestbook">
		<form name= "form1">
			<h2>방명록 입력</h2> 
			<label class="form-label">작성자</label>
			<input type="text" name="id" class="form-control" size = "20"><br>
			<label>이메일</label>
			<input type="email" name="email" size = "20"><br>
			<label>제목</label>
			<input type="text" name="title" size = "20"><br>
			<label>비밀번호</label>
			<hr>
			<input type="password" name="password" size ="20"><br>	
			<textarea class = "form1"	rows= "6"></textarea>
			
			<button type="button" class="btn btn-primary" onclick="location.href='guestbook1.jsp';">입력</button>
			<button type="button" class="btn btn-primary" onclick="location.href='enterguestbook.jsp';">취소</button>
			<button type="button" class="btn btn-primary" onclick="location.href='guestbook1.jsp';">목록</button>
		</form>
	</div>
		
</body>
	
</html>