package com.revature.Servlets;

import com.revature.DAO.ReimbursementDAO;
import com.revature.models.Reimbursement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class reimbursementsServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log(""+resp.getStatus());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Reimbursement> reimbursements = (ArrayList<Reimbursement>) ReimbursementDAO.getReimbursments();
        req.setAttribute("reimb",reimbursements);
    }
}
