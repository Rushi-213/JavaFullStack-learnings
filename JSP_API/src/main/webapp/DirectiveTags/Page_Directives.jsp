<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.Date ,java.util.Scanner" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Date d=new Date();
	out.print("Today is:"+d);
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter name:");
	String name = request.getParameter("Name");
%>
	<form action="Page_Directives.jsp" method="get">

    Enter Name:
    <input type="text" name="Name">

    <input type="submit" value="Submit">

</form>
	
<% 	
	out.print("NAME is: "+name);
%>
</body>
</html>
