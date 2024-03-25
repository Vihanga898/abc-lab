

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Objects" %>

<%
    String successMsg = (String) session.getAttribute("successMsg");
    String errorMsg = (String) session.getAttribute("errorMsg");

    // Clear the messages from the session to avoid displaying them on subsequent requests
    session.removeAttribute("successMsg");
    session.removeAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Login</title>
        <link rel="stylesheet" href="css/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>


        <nav>
            <input type="checkbox" id="check">
            <label class="logo">ABC Laboratories</label>
        </nav>

        <div class="container">

            <div class="title">Patient Login</div>


            <div class="content">
                <form action="patient_login" method="post">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Email</span>
                            <input name="email" type="text" placeholder="Enter your username" required>
                        </div>

                        <div class="input-box">
                            <span class="details">Password</span>
                            <input name="password"  type="password" placeholder="Enter your number" required>
                        </div>
                    </div>

                    <div class="button">
                        <input type="submit" value="Login">
                    </div>

                    <p> Don't have an account? <a href="patient_signup.jsp"><u>Create</u></a></p>
                    <p> Login as a <a href="technician/technician_login.jsp"><u>technician</u></a></p>
                    <p> Login as a <a href="admin/admin_login.jsp"><u>Admin</u></a></p>

                </form>
            </div>
        </div>
        
                <script>
            <% if (Objects.nonNull(successMsg)) { %>
                alert("Login Successful: <%= successMsg %>");
            <% } else if (Objects.nonNull(errorMsg)) { %>
                alert("Login Failed: <%= errorMsg %>");
            <% } %>
        </script>
    </body>
</html>
