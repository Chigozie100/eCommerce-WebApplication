package com.example.webappweek6.servlet.cartServlet;

import com.example.webappweek6.dao.CartDao;
import userModel.connection.DbCon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "removeCartServlet", value = "/remove-from-cart")
public class removeCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession httpSession = request.getSession();
        int userId = (int) httpSession.getAttribute("userId");
        try {
            CartDao cartDao = new CartDao(DbCon.getConnection());
            cartDao.removeCart(id, userId);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
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
