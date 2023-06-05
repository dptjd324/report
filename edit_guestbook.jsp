<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">

<title>방명록 수정</title>
</head>
<body>
		<div class="edit-guestbook">
		<form name= "form1">
			<h2>방명록 수정</h2> 
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
			
			<button type="button" class="btn btn-primary" onclick="location.href='guestbook1.jsp';">수정</button>
			<button type="button" class="btn btn-primary" onclick="location.href='guestbook1.jsp';">삭제</button>
			<button type="button" class="btn btn-primary" onclick="location.href='guestbook1.jsp';">목록</button>
		</form>
	</div>
		
	
	
</body>
</html>