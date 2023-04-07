<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style2.css">
</head>
<body>
<%@ include file="topmenu.jsp" %>
<%-- <%@ include file="signUpHeader.jsp"%> --%>
<div class="wrapper" style="margin:100px"> 
      
<table style="width:100%"  border="1">
      
      <tr>
         <td>회원번호 </td>
         <td>회원성명</td>
         <td>전화번호</td>
         <td>주소</td>
         <td>가입일자</td>
         <td>고객등급</td>
         <td>거주지역</td>
      </tr>
      <c:forEach var="board" items="${boards}">
      <tr>
         <td><a style="color:blue;" href="content_view.do?custno=${board.custno}">${board.custno}</a></td>
         <td>${board.custname}</td>
         <td>${board.phone}</td>
         <td>${board.address}</td>
         <td>${board.joindate}</td>
         <td>${board.grade}</td>
         <td>${board.city}</td>
      </tr>
         
         
         
      </c:forEach>
      
      
      <!-- <tr>
         <td colspan="5"> <a href="write_view.do">등록</a> </td>
         <td colspan="2"><a href="list.do">조회</a> &nbsp;&nbsp;
      </tr> -->
   </table>

</div>
<footer><%@ include file="footer.jsp" %>
</footer>
</body>
</html>