<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<div>로그인 성공</div>
	<div>${loginUser.unm}님 (${loginUser.uid}) 환영합니다.</div>
	<div><a href="/user/logout">Logout</a></div><!-- 1차 주소값이 board라서 user붙임 -->
	<div><a href="/board/write">글쓰기</a></div>
	<div>리스트</div>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${list}" var="item">
				<tr onclick="moveToDetail(${item.iboard})">
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.unm}</td>
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
			<!--foreach items = "웹개발할 떄는주로 ArrayList사용 (배열의 주소값)"  -->
		</table>
	</div>
	<script>
		function moveToDetail(iboard) {
			location.href="/board/detail?iboard=" + iboard;
		}
	</script>
</body>
</html>