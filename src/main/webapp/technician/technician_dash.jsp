
<%@page import="com.dao.TechnicianDao"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Technician"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link href="../css/style.css" rel="stylesheet" />
<script>
    function redirectTo(url) {
        window.location.href = url;
    }
</script>
</head>
<body>
    <nav>
      <input type="checkbox" id="check">
      <label for="check" class="checkbtn">
        <i class="fas fa-bars" id="menuIcon"></i>
      </label>
      <label class="logo">ABC Laboratories</label>
      <ul>
        <li><a href="technician_dash.jsp">Home</a></li>
        <li><a href="view_appointment.jsp">User Appointment</a></li>
        <li><a class="active" href="technician_login.jsp">Logout</a></li>
      </ul>
    </nav>
    
    <h2>Technician Dashboard</h2>
    
    	<%
	Technician d = (Technician) session.getAttribute("technicianObj");
	TechnicianDao dao = new TechnicianDao(DBConnect.getConn());
	%>
    
    <div class="dashboard-container">
        <button class="dashboard-button">Technician Count <%=dao.countTechnicians()%></button>
        <button class="dashboard-button" onclick="redirectTo('view_appointment.jsp')">View Appointment</button>
    </div>
        

    
    <footer class="footer-distributed">

      <div class="footer-left">

        <h3>ABC Laboratories</h3>

      </div>

      <div class="footer-center">

        <div>
          <i class="fa fa-map-marker"></i>
          <p><span>No.56, Main Street,</span> Colombo 03.</p>
        </div>

        <div>
          <i class="fa fa-phone"></i>
          <p>+94 77 777 7777</p>
        </div>

        <div>
          <i class="fa fa-envelope"></i>
          <p><a href="colomboconsultants@gamil.com">abclaboratories@gamil.com</a></p>
        </div>

      </div>

      <div class="footer-right">

        <p class="footer-company-about">
          <span>About the company</span>
          "ABC Laboratories is a full-service medical laboratory in Los Angeles, providing quality diagnostic services to physicians and patients. Offering a wide range of clinical determinations and advanced testing."
        </p>

        <div class="footer-icons">

          <a href="#"><i class="fab fa-facebook"></i></a>
          <a href="#"><i class="fab fa-twitter"></i></a>
          <a href="#"><i class="fab fa-linkedin"></i></a>
          <a href="#"><i class="fab fa-github"></i></a>

        </div>

      </div>

    </footer>
        
               <script src="script.js"></script> 
</body>
</html>
