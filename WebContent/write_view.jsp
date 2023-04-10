<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.*" %>
 <%@ page import="board.vo.BoardVO" %>

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
<script src="shop_script.js"></script>

      <form name="frm" action="write.do" method="post">
<table width="600" cellpadding="0" cellspacing="0" border="1">
         
        
         <tr>
            <td> 회원번호 </td>
            <td> <input type="text" name="custno" value="${board.vo.BoardVO.getCustno()}" readonly> (자동입력)</td>
         </tr>
         
         <tr>
            <td> 회원성명 </td>
            <td> <input type="text" name="custname" ></td>
         </tr>
         
         
         <tr>
            <td> 회원전화 </td>
            <td> <input type="text" name="phone" ></td>
         </tr>
         <tr>
            <td> 회원주소 </td>
            <td> <input type="text" name="address" ></td>
         </tr>
         <tr>
            <td> 가입일자 </td>
            <td> <input rows="10" name="joindate" ></td>
         </tr>
         <tr>
            <td> 고객등급[A:VIP, B:일반, C:직원] </td>
            <td> 
            
            <select style="margin-right:90%" > 
            <option value="A">VIP</option>
            <option value="B">일반</option>
            <option value="C">직원</option>
            </select>
            </td>
         </tr>
         <tr>
            <td> 도시코드 </td>
            <td> <input name="city" >${content_view.city}</td>
         </tr>
         <tr >
            <td colspan="2"> <input type="submit" value="등록" style="margin-left:86.5%" onclick="fn_submit(); return false;"> &nbsp;&nbsp; <a href="list.do">조회</a> &nbsp;&nbsp; 
         </tr>
         
         
   </table>
      </form>
   </div>
   
<footer><%@ include file="footer.jsp" %>
</footer>
</body>
</html>