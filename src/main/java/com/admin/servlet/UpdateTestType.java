package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TestTypeDao;
import com.db.DBConnect;
import com.entity.TestType;

@WebServlet("/UpdateTestType")
public class UpdateTestType extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve test type details from request parameters
            int testId = Integer.parseInt(request.getParameter("id"));
            String testName = request.getParameter("testName");
            double testPrice = Double.parseDouble(request.getParameter("testPrice"));

            // Create a TestType object with updated details
            TestType updatedTestType = new TestType(testId, testName, testPrice);

            // Update the test type in the database
            TestTypeDao testTypeDao = new TestTypeDao(DBConnect.getConn());
            boolean isSuccess = testTypeDao.updateTestType(updatedTestType);

            // Redirect based on the success of the update operation
            if (isSuccess) {
                response.sendRedirect("admin/viewTestTypes.jsp"); // Redirect to a success page
            } else {
                response.sendRedirect("error.jsp?message=Failed to update test type"); // Redirect to an error page
            }
        } catch (NumberFormatException e) {
            // Handle the case where there's a number format exception (e.g., invalid number format for test price)
            response.sendRedirect("error.jsp?message=Invalid input format"); // Redirect to an error page
        } catch (Exception e) {
            // Handle other exceptions (e.g., database connection issues)
            response.sendRedirect("error.jsp?message=Internal server error"); // Redirect to an error page
        }
    }
}
