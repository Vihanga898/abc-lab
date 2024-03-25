<%
if (session.getAttribute("name") == null) {
    response.sendRedirect("patient_login.jsp");
}
%>
