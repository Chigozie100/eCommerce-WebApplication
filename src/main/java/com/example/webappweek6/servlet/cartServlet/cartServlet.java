package com.example.webappweek6.servlet.cartServlet;

import com.example.webappweek6.dao.CartDao;
import userModel.connection.DbCon;
import userModel.model.Cart;
import userModel.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "cartServlet", value = "/add-to-cart")
public class cartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   try {
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       int proId = Integer.parseInt(request.getParameter("id"));
       HttpSession httpSession = request.getSession();

       if (httpSession.getAttribute("name") == null) {
           response.sendRedirect("login.jsp");
       } else {
           int userId = (int) httpSession.getAttribute("userId");
           CartDao cartDao = new CartDao(DbCon.getConnection());
           if (cartDao.addToCart(proId, userId)) {
               response.sendRedirect("index.jsp");
           } else {
               response.sendRedirect("index.jsp");
           }
       }
   }
   catch (Exception e){
       e.getMessage();
   }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
