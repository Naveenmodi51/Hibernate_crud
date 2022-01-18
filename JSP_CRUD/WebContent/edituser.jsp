<%@page import="com.pack.dao.EmployeeDao"%>
<jsp:useBean id="u" class="com.pack.model.Employee"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
EmployeeDao empDao=new EmployeeDao();
 
int i=empDao.update(u);
response.sendRedirect("viewusers.jsp");
%>