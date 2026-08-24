<%@page import="com.MVC.UserDAO"%>
<%@page import="com.MVC.AddInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="u" class="com.MVC.AddInfo"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<%
int r= UserDAO.saveInfo(u);
if(r>0){
	out.print("Data inserted Successfully");
	out.print("Name is: "+u.getName());
	out.print("Email is: "+u.getEmail());
}
%>
</body>
</html>