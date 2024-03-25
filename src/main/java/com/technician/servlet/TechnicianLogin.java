package com.technician.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TechnicianDao;
import com.db.DBConnect;
import com.entity.Technician;

@WebServlet("/TechnicianLogin")
public class TechnicianLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tec_email = req.getParameter("email");
        String tec_password = req.getParameter("password");

        HttpSession session = req.getSession();

        TechnicianDao dao = new TechnicianDao(DBConnect.getConn());
        Technician technician = dao.login(tec_email, hashPassword(tec_password));

        if (technician != null) {
            session.setAttribute("technicianObj", technician);
            resp.sendRedirect("technician/technician_dash.jsp");
        } else {
            session.setAttribute("errorMsg", "Invalid email & password");
            resp.sendRedirect("technician/technician_login.jsp");
        }
    }

    // Placeholder for secure password hashing - replace with actual implementation
    private String hashPassword(String password) {
        return password;
    }
}
