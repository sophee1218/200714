<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<th>도서번호</th>
		<td>${book.b_num}</td>
	</tr>
	<tr>
		<th>도서명</th>
		<td>${book.b_name}</td>
	</tr>
	<tr>
		<th>저자명</th>
		<td>${book.b_id}</td>
	</tr>
	<tr>
		<th>설명</th>
		<td>${book.b_desc}</td>
	</tr>
	<tr>
		<th>출판일</th>
		<td>${book.b_credat}</td>
	</tr>
</table>

</body>
</html>