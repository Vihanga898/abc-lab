package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TestTypeDao;
import com.db.DBConnect;

@WebServlet("/deleteTestType")
public class DeleteTestType extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteTestType() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String testTypeIdParameter = request.getParameter("id");
        if (testTypeIdParameter == null || testTypeIdParameter.isEmpty()) {
            response.sendRedirect("error.jsp?error=missingId");
            return;
        }

        try {
            int testTypeId = Integer.parseInt(testTypeIdParameter);

            TestTypeDao testTypeDao = new TestTypeDao(DBConnect.getConn());
            boolean isSuccess = testTypeDao.deleteTestType(testTypeId);

            if (isSuccess) {
                response.sendRedirect("admin/viewTestTypes.jsp?success=deleted");
            } else {
                response.sendRedirect("error.jsp?error=database");
            }
        } catch (NumberFormatException e) {
            // Handle the case where "id" is not a valid integer
            response.sendRedirect("error.jsp?error=invalidId");
        } catch (Exception e) {
            // Handle other exceptions
            response.sendRedirect("error.jsp?error=exception");
        }
    }
}
