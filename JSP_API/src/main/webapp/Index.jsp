<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello JSP.....Welcome to JSP</h1>
<%
	int a=10;
	out.print(a);
	
	int sum=addition(10,20);
	out.print(sum);
%>
<%!
	int addition(int x,int y){
	return x+y;
	}

%>

<%=
	"Addition is"+addition(20,30) 
%>

</body>
</html>