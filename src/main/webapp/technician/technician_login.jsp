

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Technician Login</title>
        <link rel="stylesheet" href="../css/style.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        
      <nav>
      <input type="checkbox" id="check">
      <label class="logo">ABC Laboratories</label>
    </nav>
               
    <div class="container">
    <div class="title">Technician Login</div>
    <div class="content">
        <form action="../TechnicianLogin" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Email</span>
            <input type="email" name="email" placeholder="Enter your Email" required>
          </div>

          <div class="input-box">
            <span class="details">Password</span>
            <input type="password" name="password" placeholder="Enter your Password" required>
          </div>
        </div>

        <div class="button">
          <input type="submit" value="Login">
        </div>
          
          <p> Login as a <a href="../patient_login.jsp">patient</a></p>
          <p> Login as a <a href="../admin/admin_login.jsp">Admin</a></p>
      </form>
    </div>
  </div>
        
        <section></section>
        
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
