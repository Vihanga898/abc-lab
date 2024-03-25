<%@page import="com.dao.TestTypeDao"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.TestType"%>
<%@page import="com.db.DBConnect"%>
<%@ page import="java.util.Objects" %>

<%
String successMsg = (String) session.getAttribute("succMsg");
String errorMsg = (String) session.getAttribute("errorMsg");

// Clear the messages from the session to avoid displaying them on subsequent requests
session.removeAttribute("succMsg");
session.removeAttribute("errorMsg");
%>

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
			class="checkbtn"> <i class="fas fa-bars" id="menuIcon"></i></label> <label
			class="logo">ABC Laboratories</label>
		<ul>
			<li><a href="home.jsp">Home</a></li>
			<li><a href="view_appointment.jsp">View Appointment</a></li>
			<li><a class="active" href="user_login.jsp">Logout</a></li>
		</ul>
	</nav>
	<h2>Make your Appointment Here</h2>
	<div class="container">
		<div class="content">
			<form action="addAppointment" method="post">
				<input type="hidden" name="patient_id"
					value="<%=session.getAttribute("patientObj")%>">
				<div class="user-details">
					<div class="input-box">
						<span class="details">Full Name</span> <input type="text"
							name="fullname" placeholder="Enter your name" required>
					</div>
					<div class="input-box">
						<span class="details">Gender</span> <select name="gender" required>
							<option value="" disabled selected>Select Gender</option>
							<option value="male">Male</option>
							<option value="female">Female</option>
						</select>
					</div>
					<div class="input-box">
						<span class="details">Age</span> <input type="number" name="age"
							min="18" placeholder="Enter your Age" required>
					</div>
					<div class="input-box">
						<span class="details">Appointment Date</span> <input type="date"
							name="appoint_date" required>
					</div>
					<div class="input-box">
						<span class="details">Email</span> <input type="email"
							name="email" placeholder="Enter your Email" required>
					</div>
					<div class="input-box">
						<span class="details">Phone No</span> <input type="tel"
							name="phno" placeholder="Enter your Phone Number" required>
					</div>
					<div class="input-box">
						<span class="details">Select Test Type</span> <select
							name="test_name" onchange="showPrice(this)" required>
							<option value="" disabled selected>Select Test Type</option>
							<%
							TestTypeDao dao = new TestTypeDao(DBConnect.getConn());
							List<TestType> list = dao.getAllTestType();
							for (TestType testType : list) {
							%>
							<option value="<%=testType.getTestName()%>"
								data-price="<%=testType.getTestPrice()%>"><%=testType.getTestName()%></option>
							<%
							}
							%>
						</select>
					</div>
					<div class="input-box">
						<span class="details">Price</span> <input type="text" name="price"
							placeholder="Select test type to see price" id="priceBox"
							readonly>
					</div>
					<textarea rows="4" name="address" placeholder="Enter your comments"></textarea>
				</div>
				<div class="button">
					<input type="submit" value="Submit" id="registerButton">
				</div>
				<!-- Add this button inside your form -->
				<div class="button">
					<input type="button" value="Make Payment" id="paymentButton"
						onclick="showPaymentPopup()">
				</div>
			</form>
			<!-- Payment Popup -->
			<!-- end popup -->
		</div>
	</div>
	<script>
    
    <%if (Objects.nonNull(successMsg)) {%>
        alert("Appointment Booked: <%=successMsg%>");
    <%} else if (Objects.nonNull(errorMsg)) {%>
        alert("Error: <%=errorMsg%>
		");
	<%}%>
		function showPrice(select) {
			var selectedOption = select.options[select.selectedIndex];
			var priceBox = document.getElementById("priceBox");
			var price = selectedOption.getAttribute("data-price");
			priceBox.value = price ? price : "Select test type to see price";
		}
	</script>
</body>
</html>
