package com.admin.servlet;

import com.dao.PatientDao;
import com.db.DBConnect;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeletePatientServlet
 */
@WebServlet("/deletePatient")
public class DeletePatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int patientId;
        try {
            patientId = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid patient ID");
            return;
        }

        PatientDao dao = new PatientDao(DBConnect.getConn());
        boolean success = dao.deletePatient(patientId);

        HttpSession session = request.getSession();
        if (success) {
            session.setAttribute("successMsg", "Patient deleted successfully");
        } else {
            session.setAttribute("errorMsg", "Failed to delete patient");
        }

        response.sendRedirect("admin/view_patient.jsp");
    }
}
