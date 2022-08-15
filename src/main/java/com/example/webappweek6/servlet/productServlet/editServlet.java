package com.example.webappweek6.servlet.productServlet;

import com.example.webappweek6.dao.UserDao;
import com.example.webappweek6.dao.ProductDao;
import userModel.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value = "/editproduct")
public class editServlet extends HttpServlet {
    private static Product product;
    private static UserDao userDao;
    private  static PrintWriter printWriter;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        printWriter = response.getWriter();
        userDao = new UserDao();
        product = new Product();

        product.setPro_id(Integer.parseInt(request.getParameter("id")));
        product.setPro_name(request.getParameter("proName"));
        product.setPro_price(request.getParameter("proPrice"));
        product.setPro_qty(Integer.parseInt(request.getParameter("proQuantity")));
        product.setPro_category(request.getParameter("proCategory"));

            try {
                if (ProductDao.editProduct(product)){
                    request.getRequestDispatcher("viewProduct.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

    }
}
