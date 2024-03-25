package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Adminservlet
 */
@WebServlet("/adminservlet")
public class Adminservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String uemail = request.getParameter("username");
            String upwd = request.getParameter("password");

            // Check if the entered email and password match the stored ones
            if (isValidCredentials(uemail, upwd)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", uemail);
                response.sendRedirect("admin/admin_dash.jsp");
            } else {
                // Set error message in session attribute
                HttpSession session = request.getSession();
                session.setAttribute("errormsg", "Invalid email & password");
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Dummy method to simulate authentication (replace it with your actual authentication logic)
    private boolean isValidCredentials(String email, String password) {
        return "admin@gmail.com".equals(email) && "admin".equals(password);
    }
}
