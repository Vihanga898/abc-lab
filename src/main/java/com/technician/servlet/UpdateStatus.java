package com.technician.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDAO;
import com.db.DBConnect;

@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            int technicianId = Integer.parseInt(req.getParameter("technicianId"));
            String time = req.getParameter("time");

            HttpSession session = req.getSession();

            if (id > 0 && technicianId > 0 && time != null && !time.isEmpty()) {
            	if (dao.updateAppointmentStatus(id, technicianId, time)) {
            	    session.setAttribute("successMessage", "Appointment status and time updated successfully");
            	} else {
            	    session.setAttribute("errorMessage", "Failed to update appointment status and time");
            	}

            } else {
                session.setAttribute("errorMessage", "Invalid parameters");
            }
            resp.sendRedirect("technician/view_appointment.jsp");
        } catch (NumberFormatException e) {
            handleException(req, resp, "Invalid parameter format", e);
        } catch (Exception e) {
            handleException(req, resp, "Something went wrong on the server", e);
        } finally {
            dao.closeConnection(); // Close the connection to release resources
        }
    }

    private void handleException(HttpServletRequest req, HttpServletResponse resp, String errorMessage, Exception e) throws IOException {
        e.printStackTrace();
        HttpSession session = req.getSession();
        session.setAttribute("errorMessage", errorMessage);
        resp.sendRedirect("technician/view_appointment.jsp");
    }
}
