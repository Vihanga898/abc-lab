<%@page import="com.entity.Technician"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.TestType"%>
<%@page import="com.dao.TechnicianDao"%>
<%@page import="com.dao.TestTypeDao"%>
<%@page import="com.db.DBConnect"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link href="../css/style.css" rel="stylesheet" />
<script>
	function redirectTo(url) {
		window.location.href = url;
	}
</script>
</head>
<body>


	<nav>
		<input type="checkbox" id="check"> <label for="check"
			class="checkbtn"> <i class="fas fa-bars" id="menuIcon"></i>
		</label> <label class="logo">Colombo Consulting</label>
		<ul>
			<li><a href="admin_dash.jsp">Home</a></li>
			<li><a href="add_consultant.jsp">Add Consultant</a></li>
			<li><a href="consultant_delete.jsp">Consultant Details</a></li>
			<li><a href="view_user.jsp">User details</a></li>
			<li><a class="active" href="../user_login.jsp">Logout</a></li>
		</ul>
	</nav>

	<h2>Technician Details</h2>
	<button onclick="redirectTo('add_technician.jsp')">Add
		Technician</button>



	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Mobile Number</th>
				<th>Email</th>
				<th>Address</th>
				<th>Test Name</th>
				<th>Password</th>
				<th>Action</th>

			</tr>
		</thead>
		<tbody>
			<%
			TechnicianDao dao2 = new TechnicianDao(DBConnect.getConn());
			List<Technician> list2 = dao2.getAllTechnicians();
			for (Technician d : list2) {
			%>
			<tr>
				<td><%=d.getTechnicianId()%></td>
				<td><%=d.getName()%></td>
				<td><%=d.getMobno()%></td>
				<td><%=d.getEmail()%></td>
				<td><%=d.getAddress()%></td>
				<td><%=d.getTestName()%></td>
				<td><%=d.getPassword()%></td>
				<td><a href="edit_technician.jsp?id=<%=d.getTechnicianId()%>"
					class="btn btn-sm btn-primary">Edit</a> <a
					href="../deleteTechnician?technicianId=<%=d.getTechnicianId()%>"
					class="btn btn-sm btn-danger">Delete</a></td>
			</tr>
			<!-- Add other columns as needed -->
			<%
			}
			%>

		</tbody>
	</table>

	<section></section>

	<footer class="footer-distributed">

		<div class="footer-left">

			<h3>COLOMBO CONSULTANT</h3>

		</div>

		<div class="footer-center">

			<div>
				<i class="fa fa-map-marker"></i>
				<p>
					<span>No.56, Main Street,</span> Colombo 03.
				</p>
			</div>

			<div>
				<i class="fa fa-phone"></i>
				<p>+94 77 777 7777</p>
			</div>

			<div>
				<i class="fa fa-envelope"></i>
				<p>
					<a href="colomboconsultants@gamil.com">colomboconsultants@gamil.com</a>
				</p>
			</div>

		</div>

		<div class="footer-right">

			<p class="footer-company-about">
				<span>About the company</span> "Colombo Consulting: Your trusted
				partner for career growth. Expert guidance, personalized solutions,
				and unmatched support for your job-seeking journey. Unlock success
				with us."
			</p>

			<div class="footer-icons">

				<a href="#"><i class="fab fa-facebook"></i></a> <a href="#"><i
					class="fab fa-twitter"></i></a> <a href="#"><i
					class="fab fa-linkedin"></i></a> <a href="#"><i
					class="fab fa-github"></i></a>

			</div>

		</div>

	</footer>
	<script src="script.js"></script>
</body>
</html>
