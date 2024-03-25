
<%@page import="com.entity.TestType"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.TestTypeDao"%>
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

        <h2>Add Technician</h2>

        <div class="container">
            <div class="content">
                <form action="../addTechnician" method="post">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Name</span>
                            <input type="text" name="fullname" placeholder="Technician name" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Mobile Number</span>
                            <input type="tel" name="mob" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Email</span>
                            <input type="email" name="email" placeholder="Email" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Address</span>
                            <input type="text" name="address" placeholder="Address" required>
                        </div>

                        <div class="input-box">
                            <span class="details">Test Type</span>
                            <select required name="testtype">
                                <option value="" disabled selected>Select test type</option>
                                <%
                                    TestTypeDao dao = new TestTypeDao(DBConnect.getConn());
                                    List<TestType> list = dao.getAllTestType();
                                    for (TestType s : list) {
                                %>
                                <option><%=s.getTestName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>


                        <div class="input-box">
                            <span class="details">Password</span>
                            <input type="password" name="password" placeholder="Enter Consultant Password" required>
                        </div>
                    </div>

                    <div class="button">
                        <input type="submit" value="Submit" id="registerButton">
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
