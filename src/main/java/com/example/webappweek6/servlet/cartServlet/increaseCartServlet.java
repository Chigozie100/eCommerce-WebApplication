package com.example.webappweek6.servlet.cartServlet;

import com.example.webappweek6.dao.CartDao;
import userModel.connection.DbCon;
import userModel.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "increaseCartServlet", value = "/quantity-increase")
public class increaseCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        int userId = (int) httpSession.getAttribute("userId");
        int proId = Integer.parseInt(request.getParameter("id"));
        try {
            CartDao cartDao = new CartDao(DbCon.getConnection());
           if(cartDao.increaseCart(proId, userId)){
               request.getRequestDispatcher("cart.jsp").forward(request,response);
           };
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
