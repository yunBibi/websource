<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-8"></div>
			<div class="col-4">
				<form action="/menber/joinProcess.jsp" method="post">
					<div class="form-group">
						<label for="userid">아이디</label> <input type="text"
							class="form-control" id="userid" name="userid">
					</div>
					<div class="form-group">
						<label for="password">비밀번호</label> <input type="password"
							class="form-control" id="password" name="password">
					</div>
					<div class="form-group">
						<label for="password1">비밀번호 확인</label> <input type="text"
							class="form-control" id="password1" name="password1">
					</div>
					<div class="form-group">
						<label for="name">이름</label> <input type="text"
							class="form-control" id="name" name="name">
					</div>
					<div class="gender" id="gender" name="gender">
						성별
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" id="male" name="male" class="male"> <label
								class="male" for="male">남</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" id="female" name="female" class="female">
							<label class="female" for="female">여</label>
						</div>
					</div>
					<div class="form-group">
						<label for="email">이메일</label> <input type="text"
							class="form-control" id="email" name="email">
					</div>

					<button type="submit" class="btn btn-primary">입력</button>
					<button type="button" class="btn btn-primary">취소</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>