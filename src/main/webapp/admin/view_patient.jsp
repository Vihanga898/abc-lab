
<%@page import="com.entity.Patient"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.PatientDao"%>
<%@page import="com.db.DBConnect"%>

<%
    PatientDao dao = new PatientDao(DBConnect.getConn());
    List<Patient> patients = dao.getAllPatients();
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link href="../css/style.css" rel="stylesheet" />
    </head>
    <body>


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

        <h2>User Details</h2>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Full Name</th>
                    <th>Age</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <% for (Patient patient : patients) {%>
                <tr>
                    <td><%= patient.getPatientId()%></td>
                    <td><%= patient.getFullName()%></td>
                    <td><%= patient.getAge()%></td>
                    <td><%= patient.getAddress()%></td>
                    <td><%= patient.getEmail()%></td>
                    <td><%= patient.getPassword()%></td>
                    <td><a href="../deletePatient?id=<%= patient.getPatientId() %>">Delete</a></td>
                </tr>
                <% }%>
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
