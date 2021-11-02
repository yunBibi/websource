<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div{
	margin-bottom: 10px;
	}
	
	label{
	display: inline-block;
	width:150px;
	}
	
	input{
	padding:5px;
	}
</style>
</head>
<body>
<form action="info.jsp" method="post">
<div>
<label for="userid">아이디</label>
<input type="text" id="userid" name="userid" />
</div>
<div>
<label for="password">비밀번호</label>
<input type="text" id="password" name="password" />
</div>
<div>
<label for="username">이름</label>
<input type="text" id="username" name="username" />
</div>
<button type="submit">전송</button>
</form>



</body>
</html>