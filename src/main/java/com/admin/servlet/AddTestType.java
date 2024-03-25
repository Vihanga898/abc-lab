package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;

import com.dao.TestTypeDao;
import com.db.DBConnect;
import com.entity.TestType;

@WebServlet("/addTestType")
public class AddTestType extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String testName = request.getParameter("testName");
        String testPriceStr = request.getParameter("testPrice");

        // Validate inputs
        if (testName == null || testName.isEmpty() || testPriceStr == null || testPriceStr.isEmpty()) {
            response.sendRedirect("error.jsp");
            return;
        }

        double testPrice;
        try {
            testPrice = Double.parseDouble(testPriceStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
            return;
        }

        TestType testType = new TestType();
        testType.setTestName(testName);
        testType.setTestPrice(testPrice);

        Connection conn = null;

        try {
            conn = DBConnect.getConn();

            TestTypeDao testTypeDao = new TestTypeDao(conn);
            boolean success = testTypeDao.addTestType(testType);

            if (success) {
                response.sendRedirect("admin/viewTestTypes.jsp"); // Redirect to a success page
            } else {
                response.sendRedirect("error.jsp"); // Redirect to an error page
            }
        } finally {
            // Close the connection in the finally block to ensure it gets closed
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
