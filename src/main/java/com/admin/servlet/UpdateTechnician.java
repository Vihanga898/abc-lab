package com.admin.servlet;

import com.dao.TechnicianDao;
import com.db.DBConnect;
import com.entity.Technician;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateTechnician")
public class UpdateTechnician extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve parameters from the request
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("fullname");
            String mobno = request.getParameter("mob");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String testName = request.getParameter("testtype");
            String password = request.getParameter("password");

            // Perform input validation
            if (name == null || name.isEmpty() || mobno == null || mobno.isEmpty() || email == null || email.isEmpty()
                    || address == null || address.isEmpty() || testName == null || testName.isEmpty() || password == null || password.isEmpty()) {
                response.sendRedirect("error.jsp?error=missingFields");
                return;
            }

            // Create a Technician object with updated details
            Technician updatedTechnician = new Technician();
            updatedTechnician.setTechnicianId(id);
            updatedTechnician.setName(name);
            updatedTechnician.setMobno(mobno);
            updatedTechnician.setEmail(email);
            updatedTechnician.setAddress(address);
            updatedTechnician.setTestName(testName);
            updatedTechnician.setPassword(password);

            // Update the technician details using DAO
            TechnicianDao dao = new TechnicianDao(DBConnect.getConn());
            boolean success = dao.updateTechnician(updatedTechnician);

            if (success) {
                // Redirect to a success page or show a success message
                response.sendRedirect("admin/view_technician.jsp");
            } else {
                // Redirect to an error page or show an error message
                response.sendRedirect("error.jsp?error=updateFailed");
            }
        } catch (NumberFormatException e) {
            // Handle the case where ID is not a valid integer
            response.sendRedirect("error.jsp?error=invalidId");
        }
    }
}
