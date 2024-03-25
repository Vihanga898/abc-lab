

<%@page import="com.entity.Technician"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Appointment"%>
<%@page import="com.dao.TechnicianDao"%>
<%@page import="com.dao.AppointmentDAO"%>
<%@page import="com.dao.AppointmentDAO"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Patient"%>
<%@page import="com.entity.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Make appointment</title>
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<nav>
		<input type="checkbox" id="check"> <label for="check"
			class="checkbtn"> <i class="fas fa-bars" id="menuIcon"></i>
		</label> <label class="logo">Colombo Consulting</label>
		<ul>
			<li><a href="home.jsp">Home</a></li>
			<li><a href="appointment.jsp">Make Appointment</a></li>
			<li><a class="active" href="user_login.jsp">Logout</a></li>
		</ul>
	</nav>

	<h2>Appointments</h2>

	<table>
		<thead>
			<tr>
				<th>Full Name</th>
				<th>Gender</th>
				<th>Age</th>
				<th>Appointment Date</th>
				<th>Test Name</th>
				<th>Consultant Name</th>
				<th>Appointment Time</th>
			</tr>
		</thead>
		<tbody>

			<%
			Patient patient = (Patient) session.getAttribute("patientObj");
			if (patient != null) {
				AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
				TechnicianDao dao2 = new TechnicianDao(DBConnect.getConn());
				List<Appointment> list = dao.getAllAppointmentByLoginPatient(patient.getPatientId());
				for (Appointment ap : list) {
					Technician d = dao2.getTechnicianById(ap.getTechnicianId());
			%>


			<tr>
				<td><%=ap.getFullname()%></td>
				<td><%=ap.getGender()%></td>
				<td><%=ap.getAge()%></td>
				<td><%=ap.getAppointDate()%></td>
				<td><%=ap.getTestName()%></td>
				<td><%=ap.getFullname()%></td>
				<td>
					<%
					if ("Pending".equals(ap.getStatus())) {
					%> <a href="#" class="btn btn-sm btn-warning">Pending</a>
					<%
					} else {
					%> <%=ap.getStatus()%> <%
 }
 %>
				</td>
			</tr>
			<%
			}
			}
			%>



		</tbody>
	</table>

	<section></section>


	<script src="js/script.js" defer></script>
</body>
</html>
