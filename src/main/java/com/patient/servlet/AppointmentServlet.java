package com.patient.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDAO;
import com.dao.TechnicianDao;
import com.db.DBConnect;
import com.entity.Appointment;
import com.entity.Patient;

@WebServlet("/addAppointment")
public class AppointmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Patient patient = (Patient) session.getAttribute("patientObj");
        String errorMsg = null;

        if (patient == null) {
            errorMsg = "Patient details not found.";
        } else {
            int patientId = patient.getPatientId();
            String fullname = req.getParameter("fullname");
            String gender = req.getParameter("gender");
            String age = req.getParameter("age");
            String appointDate = req.getParameter("appoint_date");
            String email = req.getParameter("email");
            String phNo = req.getParameter("phno");
            String testName = req.getParameter("test_name");
            String testPrice = req.getParameter("test_price");
            String address = req.getParameter("address");

            TechnicianDao technicianDAO = new TechnicianDao(DBConnect.getConn());
            int technicianId = technicianDAO.getTechnicianIdByTestName(testName);

            if (technicianId == 0) {
                errorMsg = "No technician found for the selected test name.";
            } else {
                // Generate ID dynamically or retrieve from the request parameters
                int appointmentId = generateAppointmentId(); // Replace this with your logic to generate ID

                // For testId and status, they will be set by default values or retrieved from database later.
                int testId = 0; // Replace with the actual test id later
                String status = "Pending"; // Or any other default status later
                Appointment appointment = new Appointment(appointmentId, patientId, fullname, gender, age, appointDate, email, phNo, testId, testName, address, technicianId, status);
                AppointmentDAO appointmentDAO = new AppointmentDAO(DBConnect.getConn());
                if (appointmentDAO.addAppointment(appointment)) {
                    session.setAttribute("succMsg", "Appointment Booked.");
                } else {
                    errorMsg = "Failed to book appointment. Please try again.";
                }
            }
        }

        if (errorMsg != null) {
            session.setAttribute("errorMsg", errorMsg);
        }
        // Clear session attributes related to the patient
        session.removeAttribute("patientObj");

        resp.sendRedirect(req.getContextPath() + "/home.jsp"); // Replace with your actual JSP page
    }

    // Example method to generate appointment ID
    private int generateAppointmentId() {
        // Replace this with your logic to generate ID dynamically
        return (int) (Math.random() * 1000);
    }
}
