<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="u" class="com.MVC.AddInfo"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Data</title>
</head>
<body>
<h1> Update Here </h1>
<form action="Update.jsp">

<%

String id = request.getParameter("uid");

int uid = Integer.parseInt(id);

%>

<input type="text" name="myid" value=<%=u.getId() %>><br><br>
<input type="text" name="myname" value=<%=u.getMyname() %>><br><br>
<input type="text" name="myemail" value=<%=u.getMyemail() %>><br><br>
<input type="text" name="mycity" value=<%=u.getMycity() %>><br><br>
<input type="text" name="myage" value=<%=u.getMyage() %>><br><br>
<input type="submit">

</form>
</body>
</html>