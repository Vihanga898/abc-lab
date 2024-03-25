package com.patient.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PatientDao;
import com.db.DBConnect;
import com.entity.Patient;

@WebServlet("/patient_login")
public class PatientLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            PatientDao dao = new PatientDao(DBConnect.getConn());
            Patient patient = dao.login(email, password);

            if (patient != null) {
                HttpSession session = req.getSession();
                // Set the authenticated user object in the session
                session.setAttribute("patientObj", patient);
                // Set a success message in the session
                session.setAttribute("successMsg", "Login successful!");
                // Redirect to the home page or any desired page
                resp.sendRedirect("home.jsp");
            } else {
                // Set an error message in the session
                HttpSession session = req.getSession();
                session.setAttribute("errorMsg", "Invalid email or password");
                // Redirect back to the login page
                resp.sendRedirect("patient_login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
