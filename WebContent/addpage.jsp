<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String msg=(String)request.getAttribute("amg"); 
if(msg!=null)
{
out.println(msg);	
}

%>

<form name="addform" action="cities" method="post">
<input type="hidden" name="Addform" value="Adding"/>
SID<input type="text" name="sid"/><br>
FIRSTNAME<input type="text" name="firstname"/><br>
LASTNAME<input type="text" name="lastname"/><br>
<input type="submit" name="addstudent" value="SAVE">
</form>
<%

%>
</body>
</html>