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
CitiesDAO dao=new CitiesDAOImpl();
int g=1;
 for(City c:dao.getAllCities())
 {
 %>
	 <tr>
	 <td><%=c.getId() %></td>
	 <td><%=c.getFirstname() %></td>
	 <td><%=c.getLastname() %></td>

 <form name="first" action="cities" method="post">
 <input type="hidden" name="htmlFormName" value="Form-<%=c.getId()%>"/>
  <td><input type="submit" name="update" value="EDIT"/></td>
  <td><input type="submit" name="delete" value="DELETE"/></td>
</form>
	 </tr>
	 	
	 <%  
 }
 
%>
</table>

<form name="second" action="cities" method="post">

<input type="submit" name="add" value="ADD"/>
</form>
<%

String emsg=(String)request.getAttribute("msg");
%>

<h1>
<%= emsg %>
</h1>
</body>
</html>