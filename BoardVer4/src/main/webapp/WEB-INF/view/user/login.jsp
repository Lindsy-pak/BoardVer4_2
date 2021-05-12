<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%=application.getContextPath()%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Goblin+One&display=swap')
	;

* {
	margin: 0;
	padding: 0;
}

html, body {
	width: 100%;
	height: 100%;
}


a {
	color: black;
	text-decoration: none;
}

#title {
	font-size: 54px;
	font-family: 'Goblin One', cursive;
	color: #000;
}
#bg {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%; 
	/* background-image: linear-gradient(25deg, #b248d4, #d587b3, #ecc08c, #faf857); */
	background: #FFFFD6 url('../../../img/Cat.png') center center/cover no-repeat;
	z-index: 0;
}

#wrap {
	margin-top: 100px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-content: center;
	text-align: center;
/* 	z-index: 0; position아니면 안먹음 */
}

.errMsg {
	color: red
}
;
</style>
</head>
<body>
	<div id="bg">
		<div id="wrap">
			<div id="title">
				<h1>fucking JSP World</h1>
			</div>

			<br>
			<div class="errMsg">${errMsg}</div>
			<br>
			<div>
				<form action="login" method="post">
					<div>
						<input type="text" name="uid" placeholder="아이디">
					</div>
					<div>
						<input type="password" name="upw" placeholder="비밀번호">
					</div>
					<br>
					<div>
						<input type="submit" value="Login">
					</div>
				</form>
			</div>
			<div>
				<a href="join">회원가입</a>
				<!-- /join 하려면 /user/join 해야함 -->
			</div>
		</div>
	</div>
</body>
</html>