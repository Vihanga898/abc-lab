

<%@page import="com.db.DBConnect"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="css/styles.css" />

</head>
<body>
	<nav>
      <input type="checkbox" id="check">
      <label for="check" class="checkbtn">
        <i class="fas fa-bars" id="menuIcon"></i>
      </label>
      <label class="logo">ABC Laboratories</label>
      <ul>
        <li><a href="makeappointment.jsp">Make Appointment</a></li>
        <li><a href="pview_appointment.jsp">View Appointment</a></li>
        <li><a class="active" href="patient_login.jsp">Logout</a></li>
      </ul>
    </nav>
        
        <img src="images/consulting.png" class="center-img" id="mainImage">
        
        <div class="company">
            <h1>We Are ABC Laboratories</h1>
            <p>Advancing Healthcare through Precision Testing and Compassionate Service</p>
        </div>
        
        <section class="dir-appoint">
            <h1> Make your appointment directly</h1>
            
            <p>Contact us to make your appointment directly through below details. </p>
            
            <i class="fas fa-phone"></i> Phone: +94 77 777 7777<br>
        <i class="fas fa-envelope"></i> Email: abclaboratories@gamil.com<br>
        <i class="fas fa-map-marker-alt"></i> Address: No.56, Main Street, Colombo 03.
            
        </section>
        
        
        <%@include file="component/footer.jsp"%>
        
        <script src="js/script.js"></script>
                
</body>
</html>
