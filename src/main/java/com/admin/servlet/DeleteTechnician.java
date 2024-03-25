package com.admin.servlet;

import com.dao.TechnicianDao;
import com.db.DBConnect;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteTechnician")
public class DeleteTechnician extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String technicianIdParameter = request.getParameter("technicianId");
        if (technicianIdParameter == null || technicianIdParameter.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "TechnicianId parameter is missing or empty");
            return;
        }

        try {
            int technicianId = Integer.parseInt(technicianIdParameter);

            TechnicianDao dao = new TechnicianDao(DBConnect.getConn());
            boolean success = dao.deleteTechnician(technicianId);

            HttpSession session = request.getSession();
            if (success) {
                session.setAttribute("successMsg", "Technician deleted successfully");
            } else {
                session.setAttribute("errorMsg", "Failed to delete technician");
            }

            response.sendRedirect("admin/view_technician.jsp");
        } catch (NumberFormatException e) {
            // Handle the case where "technicianId" is not a valid integer
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid technicianId parameter");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
