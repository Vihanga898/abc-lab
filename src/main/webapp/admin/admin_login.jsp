

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Signup</title>
        <link rel="stylesheet" href="../css/style.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        
      <nav>
      <input type="checkbox" id="check">
      <label class="logo">ABC Laboratories</label>
    </nav>
               
    <div class="container">
    <div class="title">Admin Login</div>
    
    <c:if test="${not empty errorMessage}">
    <p class="text-center text-danger fs-5">${errorMessage}</p>
    </c:if>

    
    <div class="content">
      <form action="../adminservlet" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Email</span>
            <input type="text" name="username" id="username" placeholder="Enter your username" required>
          </div>

          <div class="input-box">
            <span class="details">Password</span>
            <input type="password" name="password" id="password" placeholder="Enter your number" required>
          </div>
        </div>

        <div class="button">
          <input type="submit" value="Login">
        </div>
          
        <p> Login as a <a href="../patient_login.jsp"><u>Patient</u></a></p>
          <p> Login as a <a href="../technician/technician_login.jsp"><u>Technician</u></a></p>
      </form>
    </div>
  </div>
        
        <section></section>
        
        <footer class="footer-distributed">

      <div class="footer-left">

        <h3>COLOMBO CONSULTANT</h3>

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
          <p><a href="colomboconsultants@gamil.com">colomboconsultants@gamil.com</a></p>
        </div>

      </div>

      <div class="footer-right">

        <p class="footer-company-about">
          <span>About the company</span>
          "Colombo Consulting: Your trusted partner for career growth. Expert guidance, personalized solutions, and unmatched support for your job-seeking journey. Unlock success with us."
        </p>

        <div class="footer-icons">

          <a href="#"><i class="fab fa-facebook"></i></a>
          <a href="#"><i class="fab fa-twitter"></i></a>
          <a href="#"><i class="fab fa-linkedin"></i></a>
          <a href="#"><i class="fab fa-github"></i></a>

        </div>

      </div>

    </footer>
   
             
    </body>
</html>
