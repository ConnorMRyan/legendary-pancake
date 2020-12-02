package com.revature.Servlets;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.revature.DAO.ReimbursementDAO;
import com.revature.models.Reimbursement;
import com.revature.utils.ImageConvert;
import com.revature.utils.JsonBuilder;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

 public class reimbServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Reimbursement> reimbursements = new ArrayList<>();
        reimbursements = (ArrayList<Reimbursement>) ReimbursementDAO.getReimbursments();
        PrintWriter pw = response.getWriter();
        JsonArray array = new JsonArray();
        for (Reimbursement remb:
             reimbursements) {
            String js = JsonBuilder.makeJSON(remb);
            JsonObject rootNode = JsonParser.parseString(js).getAsJsonObject();
            JsonElement reciept =  rootNode.get("receipt");
            //Do something with this image later.
            BufferedImage bI = ImageConvert.arrayToImage(reciept.getAsString().getBytes());
            rootNode.remove("receipt");
            array.add(rootNode);
        }
        pw.write(String.valueOf(array));
        response.setContentType("application/json");
        response.setStatus(200);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/reimbursements");
        dispatcher.forward(request, response);
        response.sendRedirect("/reimbursements");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}


