<%@page import="com.entity.TestType"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.TestTypeDao"%>
<%@page import="com.db.DBConnect"%>

<%
    int testTypeId = Integer.parseInt(request.getParameter("id"));
    TestTypeDao testTypeDao = new TestTypeDao(DBConnect.getConn());
    TestType testType = testTypeDao.getTestTypeById(testTypeId);
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link href="../css/style.css" rel="stylesheet" />
        <title>Edit Test Type</title>
    </head>
    <body>
        <nav>
            <!-- your navigation bar -->
        </nav>

        <h2>Edit Test Type</h2>

        <div class="container">
            <div class="content">
                <form action="../UpdateTestType" method="post">
                    <div class="input-box">
                        <span class="details">Test Type Name</span>
                        <input type="text" name="testName" placeholder="Test Type name" value="<%= (testType != null) ? testType.getTestName() : "" %>" required>
                    </div>

                    <div class="input-box">
                        <span class="details">Test Price</span>
                        <input type="number" name="testPrice" value="<%= (testType != null) ? testType.getTestPrice() : 0 %>" required>
                    </div>

                    <input type="hidden" name="id" value="<%= (testType != null) ? testType.getId() : 0 %>">
                    <div class="button">
                        <input type="submit" value="Edit" id="registerButton">
                    </div>
                </form>
            </div>
        </div>

        <footer class="footer-distributed">
            <!-- your footer section -->
        </footer>
    </body>
</html>
