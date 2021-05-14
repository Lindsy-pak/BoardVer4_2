<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<style>
	*{ padding:0; margin:0; }
	body{ font-family:"맑은고딕", sanserif; }
	
	select {
		width: 200px;
		padding: .8em .5em;
		font-family:"맑은고딕", sanserif;
		background: url('https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg') no-repeat 95% 50%; no-repeat;
		border: 1px solid #999;
		-webkit-appearance: none;
		-moz-appearance: none;
    	appearance: none;
/*     	select::-ms-expand {
  		for IE 11 
  		display: none; }*/
	}
	#button {margin-top: 10px;}
</style>
</head>
<body>
	<div id="wrap">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" placeholder="ID"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="pw" placeholder="PW"></td>
			</tr>
			<tr>
				<td>PW 확인</td>
				<td><input type="password" name="pwchk" placeholder="PW확인"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="unm" placeholder="성명"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<label><input type="radio" name="gender" value="0" checked>여자</label>
					<label><input type="radio" name="gender" value="1" checked>남자</label>
				</td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td>
					<input type="text" name="umail"> @ 
					<input type="text" name="umail">
					<select>
						<option selected>Select</option>
						<option>naver.com</option>
						<option>google.com</option>
						<option>nate.com</option>
						<option>yahoo.com</option>
					</select>
				</td>
			</tr>
		</table>
		<div id="button">
			<span><a href="/board/list"><input type="button" value="Login"></a></span>
			<span><a href="/user/join"><input type="button" value="Join"></a></span>
		</div>
	</div>

</body>
</html>