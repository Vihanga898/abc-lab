<%@ page import="com.dao.AppointmentDAO" %>
<%@ page import="com.entity.Appointment" %>
<%@ page import="com.db.DBConnect" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link href="../css/style.css" rel="stylesheet" />
    </head>
    <body>
        <nav>
            <input type="checkbox" id="check">
            <label for="check" class="checkbtn">
                <i class="fas fa-bars" id="menuIcon"></i>
            </label>
            <label class="logo">Colombo Consulting</label>
            <ul>
                <li><a class="active" href="../user_login.jsp">Logout</a></li>
            </ul>
        </nav>

        <h2>Consultant Dashboard</h2>

        <div class="container">
            <div class="title">User Approval</div>

            <%
                int id = Integer.parseInt(request.getParameter("id"));
                AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
                Appointment appointment = dao.getAppointmentById(id);
            %>


            <input type="hidden" name="userid" value="<%= appointment.getPatientId()%>">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">Patient Name</span>
                    <input type="text" value="<%= appointment.getFullname()%>" readonly>
                </div>

                <div class="input-box">
                    <span class="details">Age</span>
                    <input type="text" value="<%= appointment.getAge()%>" readonly>
                </div>

                <div class="input-box">
                    <span class="details">Phone No</span>
                    <input type="text" value="<%= appointment.getPhNo()%>" readonly>
                </div>

                <div class="input-box">
                    <span class="details">Set time</span>
                    <textarea rows="4" name="comm" placeholder="Set the time"></textarea>
                </div>

                <input type="hidden" name="id" value="<%= appointment.getId()%>">
                <input type="hidden" name="cid" value="<%= appointment.getTechnicianId()%>">
            </div>

            <div class="button">
                <input type="submit" value="set time">
            </div>


        </div>

        <footer class="footer-distributed">
            <!-- Your existing footer content -->
        </footer>
    </body>
</html>
