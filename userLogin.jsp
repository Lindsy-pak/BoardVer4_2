<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	*{ padding:0; margin:0; }
	body{ font-family: "맑은고딕", san-serif; background-image: linear-gradient(22deg, #1b00f5, #9a49d2, #d080ac, #f7b781); no-repeat; }
	a{ text-decoration: none; color:black;}
	#wrap {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-content: center;
		text-align: center;
		margin-top: 200px;
	}
	#button { margin-top:10px;}
</style>
</head>
<body>

</head>
<body>
	<div id="wrap">
	<div>${errMsg}</div>
		<form action="login" method="post">
			<div>ID : <input type="text" name="id" placeholder="ID"></div>
			<div>PW : <input type="password" name="pw" placeholder="PW"></div>
			<div id="button">
				<span><input type="submit" value="Login"></span>
				<span><a href="/user/join"><input type="button" value="Join"></a></span>
			</div>
		</form>
	</div>
</body>
</html>