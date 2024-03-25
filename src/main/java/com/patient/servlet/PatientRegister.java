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

@WebServlet("/patient_register")
public class PatientRegister extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String fullName = req.getParameter("fullname");
            String age = req.getParameter("age");
            String address = req.getParameter("address");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            // Perform basic validation
            if (fullName == null || age == null || address == null || email == null || password == null
                    || fullName.isEmpty() || age.isEmpty() || address.isEmpty() || email.isEmpty()
                    || password.isEmpty()) {
                // Handle invalid input
                resp.sendRedirect("patient_signup.jsp?error=InvalidInput");
                return;
            }

            Patient patient = new Patient(0,fullName, age, address, email, password);

            PatientDao dao = new PatientDao(DBConnect.getConn());
            boolean registrationStatus = dao.register(patient);

            HttpSession session = req.getSession();

            if (registrationStatus) {
                session.setAttribute("successMsg", "Registration Successful");
                resp.sendRedirect("patient_login.jsp");
            } else {
                session.setAttribute("errorMsg", "Registration Failed. Please try again.");
                resp.sendRedirect("patient_signup.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}


