

<%@page import="java.util.List"%>
<%@page import="com.sigma.june25.model.City"%>
<%@page import="com.sigma.june25.dao.CitiesDAOImpl"%>
<%@page import="com.sigma.june25.dao.CitiesDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%
List<City> cities=(List<City>)request.getAttribute("cities");



for(City c:cities)
{
%>
<tr>
<td><%=c.getId() %></td>
<td><%=c.getFirstname() %></td>
<td><%=c.getLastname() %></td>


</tr>
	
<%  
}



%>
</table>


</body>
</html>