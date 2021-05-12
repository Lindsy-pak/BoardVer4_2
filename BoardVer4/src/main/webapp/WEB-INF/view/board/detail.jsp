<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${data.title}</title>
</head>
<body>
	<div><input type="button" value="뒤로가기" onclick="moveToList()"></div>
	<div><h1>디테일 페이지</h1></div>
	<div>${param.iboard}</div>
	
	<div>글번호 :  ${data.iboard}</div>
	<div>제목 :  ${data.title}</div>
	<div>글쓴이 ${data.unm}</div>
	<div>작성일시 ${data.regdt}</div>
	<div>${data.ctnt}</div>
	
	<c:if test="${loginUser.iuser == data.iuser}"> 
	<!-- 내가 쓴글만 삭제와 수정이 되도록 만들어주는 기능  -->
	<div>
	<a href="del?iboard=${param.iboard}"><input type="button" value="삭제"></a>
	<a href="mod?iboard=${param.iboard}"><input type="button" value="수정"></a>
	</div>
	</c:if>
	
	<script>
		function moveToList(){
			location.href="/board/list";
		}
	</script>
	
</body>
</html>