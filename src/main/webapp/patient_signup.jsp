

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Signup</title>
        <link rel="stylesheet" href="css/style.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        
      <nav>
      <input type="checkbox" id="check">
      <label class="logo">ABC Laboratories</label>
      <ul>
        <li><a class="active" href="index.jsp">Logout</a></li>
      </ul>
    </nav>
               
    <div class="container">
    <div class="title">Patient Registration</div>
    <div class="content">
      <form action="patient_register" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Full Name</span>
            <input name="fullname" type="text" placeholder="Enter your name" required>
          </div>
          <div class="input-box">
            <span class="details">Age</span>
            <input name="age" type="number" placeholder="Enter your age" required>
          </div>
          <div class="input-box">
            <span class="details">Address</span>
            <input name="address" type="text" placeholder="Enter your address" required>
          </div>
          <div class="input-box">
            <span class="details">Email</span>
            <input name="email" type="text" placeholder="Enter your email" required>
          </div>
          <div class="input-box">
            <span class="details">Phone Number</span>
            <input name="phno" type="text" placeholder="Enter your phone number" required>
          </div>
          <div class="input-box">
            <span class="details">Password</span>
            <input name="password"  type="password" placeholder="Enter your password" required>
          </div>
        </div>

        <div class="button">
            <input type="submit" value="Register" id="registerButton">
        </div>
          
          <p> If you have an account login <a href="patient_login.jsp"><u>Here</u></a></p>
      </form>
    </div>
  </div>
        
        <script src="js/script.js" defer></script>
    </body>
</html>
