<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "com.spring.board.BoardDTO" %>

<%
	//session 에 저장된 값을 가지고 온다. 
		//board : DB의 select 한 레코드를 저장하고 있는 dto 
	BoardDTO board = (BoardDTO) session.getAttribute("board"); 
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 페이지 </title>
</head>
<body>
<%= board.getSeq() %> <br> 
<%= board.getTitle() %> <br>
<%= board.getWriter() %> <br>
<%= board.getContent() %> <br>
<%= board.getRegDate() %> <br>
<%= board.getCnt() %> <br>
</body>
</html>