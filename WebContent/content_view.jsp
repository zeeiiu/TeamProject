<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style2.css?ver=1">
</head>
<body>
	<%@ include file="topmenu.jsp"%>

	<div class="wrapper" style="margin: 100px">
		<form action="modify.do" method="post">
			<table width="600" cellpadding="0" cellspacing="0" border="1">


				<tr>
					<td>회원번호</td>
					<td><input type="text" name="custno"
						value="${content_view.custno}" readonly></td>
				</tr>

				<tr>
					<td>회원성명</td>
					<td><input type="text" name="custname"
						value="${content_view.custname}"></td>
				</tr>


				<tr>
					<td>회원전화</td>
					<td><input type="text" name="phone"
						value="${content_view.phone}"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" name="address"
						value="${content_view.address}"></td>
				</tr>
				<tr>
					<td>가입일자</td>
					<td><input rows="10" name="joindate" ${content_view.joindate}></td>
				</tr>
				<tr>
					<td>고객등급[A:VIP, B:일반, C:직원]</td>
					<td><input name="grade">${content_view.grade}</td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input name="city">${content_view.city}</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정"
						style="margin-left: 86.5%">
					<!--  &nbsp;&nbsp;  -->
						<!-- <a href="list.do">조회</a> &nbsp;&nbsp;  -->
				</tr>


			</table>
		</form>
	</div>
<footer><%@ include file="footer.jsp"%>
</footer>
</body>
</html>