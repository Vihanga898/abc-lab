package com.admin.servlet;

import com.dao.TechnicianDao;
import com.db.DBConnect;
import com.entity.Technician;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addTechnician")
public class AddTechnician extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String fullName = request.getParameter("fullname");
        String mobNo = request.getParameter("mob");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String testType = request.getParameter("testtype");
        String password = request.getParameter("password");

        // Validate inputs
        if (fullName == null || fullName.isEmpty() || mobNo == null || mobNo.isEmpty() ||
            email == null || email.isEmpty() || address == null || address.isEmpty() ||
            testType == null || testType.isEmpty() || password == null || password.isEmpty()) {
            // Handle invalid inputs
            response.sendRedirect("error.jsp");
            return;
        }

        // Create a Technician object
        Technician technician = new Technician();
        technician.setName(fullName);
        technician.setMobno(mobNo);
        technician.setEmail(email);
        technician.setAddress(address);
        technician.setTestName(testType);
        technician.setPassword(password);

        // Use the TechnicianDao to register the technician
        try (Connection conn = DBConnect.getConn()) {
            TechnicianDao technicianDao = new TechnicianDao(conn);
            boolean isSuccess = technicianDao.registerTechnician(technician);

            if (isSuccess) {
                // Redirect to a success page
                response.sendRedirect("admin/view_technician.jsp");
            } else {
                // Redirect to an error page
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            // Log the exception or handle it appropriately
            e.printStackTrace();
            // Redirect to an error page
            response.sendRedirect("error.jsp");
        }
    }
}
