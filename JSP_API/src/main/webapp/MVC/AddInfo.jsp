<%@page import="com.MVC.UserDAO"%>
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

int r = UserDAO.SaveUser(u);
if(r>0){
	out.print("Data inserted.......<br>");
	out.print("ID is "+u.getId()+"<br>");
	out.print("Name is "+u.getMyname()+"<br>");
	out.print("Email is "+u.getMyemail()+"<br>");
	out.print("City is "+u.getMycity()+"<br>");
	out.print("Age is "+u.getMyage()+"<br>");
}
else{
	out.print("Data not inserted..........");
}

%>

</body>
</html>