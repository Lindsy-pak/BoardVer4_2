<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mod</title>
</head>
<body>
	<h1>글수정</h1>
		<div>
			<div><input type="button" value="뒤로가기" onclick="moveToList()"></div>
			<form action="mod" method="post">
				<div><input type="hidden" name="iboard" value="${data.iboard}" readonly></div>
				<!-- readonly를 사용하면 type에 적혀진 값이 수정이 되지 않는다  -->
				<div><input type="text" name="title" placeholder="제목" value="${data.title}"></div>
				<br>
				<div><textarea name="ctnt">${data.ctnt}</textarea></div>
				<div>
					<input type="submit" value="글수정">
					<input type="reset" value="초기화">
				</div>
			</form>
		</div>
		<script>
			function moveToList(){
				location.href="/board/list";
			}
		</script>
</body>
</html>