
<%@page import="com.entity.TestType"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.TestTypeDao"%>
<%@page import="com.dao.TechnicianDao"%>
<%@page import="com.entity.Technician"%>
<%@page import="com.db.DBConnect"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link href="../css/style.css" rel="stylesheet" />
    </head>
    <body>

        <%
            int technicianId = Integer.parseInt(request.getParameter("id"));
            TechnicianDao dao = new TechnicianDao(DBConnect.getConn());
            Technician technician = dao.getTechnicianById(technicianId);
        %>

        <nav>
            <input type="checkbox" id="check">
            <label for="check" class="checkbtn">
                <i class="fas fa-bars" id="menuIcon"></i>
            </label>
            <label class="logo">Colombo Consulting</label>
            <ul>
                <li><a href="admin_dash.jsp">Home</a></li>
                <li><a href="add_consultant.jsp">Add Consultant</a></li>
                <li><a href="consultant_delete.jsp">Consultant Details</a></li>
                <li><a href="view_user.jsp">User details</a></li>
                <li><a class="active" href="../user_login.jsp">Logout</a></li>
            </ul>
        </nav>

        <h2>Edit Consultant</h2>

        <div class="container">
            <div class="content">
                <form action="../UpdateTechnician" method="post">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Name</span>
                            <input type="text" name="fullname" placeholder="Technician name" value="<%= technician.getName()%>" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Mobile Number</span>
                            <input type="tel" name="mob" value="<%= technician.getMobno()%>" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Email</span>
                            <input type="email" name="email" placeholder="Email" value="<%= technician.getEmail()%>" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Address</span>
                            <input type="text" name="address" placeholder="Address" value="<%= technician.getAddress()%>" required>
                        </div>

                        <div class="input-box">
                            <span class="details">Test Type</span>
                            <select required name="testtype">
                                <option value="" disabled>Select test type</option>
                                <%
                                    List<TestType> testTypes = new TestTypeDao(DBConnect.getConn()).getAllTestType();
                                    for (TestType testType : testTypes) {
                                        String selected = (testType.getTestName().equals(technician.getTestName())) ? "selected" : "";
                                %>
                                <option <%= selected%>><%= testType.getTestName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>

                        <div class="input-box">
                            <span class="details">Password</span>
                            <input type="password" name="password" placeholder="Enter Consultant Password" value="<%= technician.getPassword()%>" required>
                        </div>
                    </div>
                    <input type="hidden" name="id" value="<%= technician.getTechnicianId()%>">
                    <div class="button">
                        <input type="submit" value="Edit" id="registerButton">
                    </div>
                </form>
            </div>

        </div>

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
