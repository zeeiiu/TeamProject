<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style2.css?ver=1">
</head>
<body>

<%@ include file="topmenu.jsp" %>

<div class="wrapper" style="margin:100px"> 
<table width="1000" cellpadding="0" cellspacing="0" border="1">
      <tr>
         <td>회원번호 </td>
         <td>회원성명</td>
         <td>고객등급</td>
         <td>매출</td>
        
      </tr>
      <c:forEach var = "board" items="${sboards}">
      <tr>
         <%-- <td><a href="content_view.do?custno=${board.custno}">${board.custno}</a></td> --%>
         <td>${board.custno}</td>
         <td>${board.custname}</td>
         <td>${board.grade}</td>
         <td>${board.total}</td>
         
      </tr>
         
         
         
      </c:forEach>
      
      
     
   </table>
   </div>

<footer><%@ include file="footer.jsp" %>
</footer>
</body>
</html>