<%@page import="com.userbean.Addinfo"%>
<%@page import="com.userbean.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>

<%

String id = request.getParameter("myid");
int uid = Integer.parseInt(id);

Addinfo a = UserDao.getByUserId(uid);

if(a!=null){
	out.print("ID is "+a.getId()+"<br>");
	out.print("Name is "+a.getMyname()+"<br>");
	out.print("Email is "+a.getMyemail()+"<br>");
	out.print("City is "+a.getMycity()+"<br>");
	out.print("Age is "+a.getMyage()+"<br>");
}
else{
	out.print("Data not Found<br>");
}

%>

<a href="Edit.jsp?uid=<%=a.getId() %>">Edit</a>
<a href="Delete.jsp?uid=<%=a.getId() %>">Delete</a>

</body>
</html>