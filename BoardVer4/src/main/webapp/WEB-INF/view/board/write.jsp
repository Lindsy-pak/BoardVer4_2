<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>
	<h1>글쓰기</h1>
	<div>
		<form action="write" method="post"><!--action="/board/write"  -->
			<%-- <input type="hidden" name="iuser" value="${loginUser.iuser}">보안문제 때문에 이렇게 사용하면x 누군가 스크립트로 글수정을 할 수 있기 때문 --%>
			<div><input type="text" name="title" placeholder="제목"></div>
			<br>
			<div><textarea name="ctnt"></textarea></div>
			<div>
				<input type="submit" value="글쓰기">
				<input type="reset" value="초기화">
			</div>
		</form>
	</div>
</body>
</html>