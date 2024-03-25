<%@page import="com.entity.Technician"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Appointment"%>
<%@page import="com.dao.TechnicianDao"%>
<%@page import="com.dao.AppointmentDAO"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Make appointment</title>
<link rel="stylesheet" href="../css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<nav>
		<input type="checkbox" id="check"> <label for="check"
			class="checkbtn"> <i class="fas fa-bars" id="menuIcon"></i>
		</label> <label class="logo">ABC Laboratories</label>
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
				<th>Action</th>
			</tr>
		</thead>
		<tbody>

			<%
			HttpSession session1 = request.getSession(false);
			if (session != null) {
				System.out.println("Session ID: " + session.getId()); // Debugging statement

				Patient patient = (Patient) session.getAttribute("patientObj");
				if (patient != null) {
					System.out.println("Patient object in session: " + patient); // Debugging statement

					try {
				AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
				List<Appointment> list = dao.getAllAppointmentByLoginPatient(patient.getPatientId());
				for (Appointment ap : list) {
					TechnicianDao dao2 = new TechnicianDao(DBConnect.getConn());
					Technician technician = dao2.getTechnicianById(ap.getTechnicianId()); // Changed variable name to 'technician'
			%>

			<tr>
				<th><%=ap.getFullname()%></th>
				<td><%=ap.getGender()%></td>
				<td><%=ap.getAge()%></td>
				<td><%=ap.getAppointDate()%></td>
				<td><%=ap.getTestName()%></td>
				<td><%=ap.getFullname()%></td>
				<td><%=ap.getStatus()%></td>
				<td><a href="approve.jsp?id=<%=ap.getId()%>"
					class="btn btn-warning btn-sm">Set Time For Appointment</a></td>
			</tr>
			<%
			}
			} catch (Exception e) {
			System.out.println("Error retrieving appointments: " + e.getMessage()); // Debugging statement
			e.printStackTrace();
			}
			} else {
			System.out.println("Patient object is null in session"); // Debugging statement
			}
			} else {
			System.out.println("Session is null"); // Debugging statement
			}
			%>

		</tbody>
	</table>

	<section></section>

	<script src="js/script.js" defer></script>
</body>
</html>
