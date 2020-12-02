package com.revature.Servlets;

import com.revature.DAO.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.utils.Authentication;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class loginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if(!Authentication.verifyUser(user,pass)){
            response.sendRedirect("badlogin.html");
        }else{
            Cookie userIs = new Cookie("user",user);
            Cookie logged = new Cookie("loggedIn","true");
            Employee emp = EmployeeDAO.getEmployeeFromUsername(user);
            assert emp != null;
            Cookie ID = new Cookie("ID",""+ emp.getId());
            response.addCookie(userIs);
            response.addCookie(logged);
            response.sendRedirect("main.html");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<h3>Hello Servlet</h3>");
        out.print("</body></html>");
    }
}
