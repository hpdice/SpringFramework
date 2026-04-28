<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.TimeZone" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Boot</title>
</head>
<body>
<%
Date now = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
String currentTime = sdf.format(now);
%>
<h1>Hello World!</h1>
<p>현재 서버 시간은 <%= currentTime %> 입니다.</p>
</body>
</html>