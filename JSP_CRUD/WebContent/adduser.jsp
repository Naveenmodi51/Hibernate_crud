<%@page import="com.pack.dao.EmployeeDao"%>
<jsp:useBean id="u" class="com.pack.model.Employee"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
EmployeeDao empDao=new EmployeeDao();
int i=empDao.save(u);
if(i>0){
response.sendRedirect("adduser-success.jsp");
}else{
response.sendRedirect("adduser-error.jsp");
}
%>