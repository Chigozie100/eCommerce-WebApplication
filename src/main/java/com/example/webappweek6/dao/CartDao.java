package com.example.webappweek6.dao;

import userModel.connection.DbCon;
import userModel.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public CartDao(Connection connection) {
        this.connection = connection;
    }

    public boolean addToCart(int proId, int userId) throws SQLException, ClassNotFoundException {
        String addProduct = "SELECT * FROM cart Where proId= ? and userId=?";
        preparedStatement = connection.prepareStatement(addProduct);
        preparedStatement.setInt(1, proId);
        preparedStatement.setInt(2, userId);
        ResultSet set = preparedStatement.executeQuery();


        if(set.next()){
            int quantity = set.getInt("quantity");

            String query = "update cart set quantity = ? where proId = ? and userId = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,quantity+1);
            preparedStatement.setInt(2, proId);
            preparedStatement.setInt(3, userId);

            int res = preparedStatement.executeUpdate();
            if (res > 0){
                return true;
            }
        }
        else {
            String addPro = "INSERT INTO cart (proId, userId, quantity) VALUES (?, ?, ?)";
            int quantity = 1;
            preparedStatement = connection.prepareStatement(addPro);
            preparedStatement.setInt(1, proId);
            preparedStatement.setInt(2, userId);
            preparedStatement.setInt(3,quantity);
         int i =   preparedStatement.executeUpdate();
         if(i > 0){
             System.out.println("yea");
         }
        }
     return false;
    }

    public List<Product> getAllCartProduct(int userId) throws SQLException {
        List<Product> products = new ArrayList<>();

        String query1 =  "select Pro_name,pro_price,quantity,pro_category,proId from product  join cart on product.pro_id " +
                        "= cart.proId and cart.userId = ?";
      preparedStatement = connection.prepareStatement(query1);
      preparedStatement.setInt(1, userId);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
          Product product = new Product();
          product.setPro_name(resultSet.getString("Pro_name"));
          product.setPro_price(resultSet.getString("pro_price"));
          product.setPro_qty(resultSet.getInt("quantity"));
          product.setPro_id(resultSet.getInt("proId"));
          product.setPro_category(resultSet.getString("pro_category"));
          products.add(product);
      }
    return products;
    }


    public void removeCart(int id ,int userId) throws SQLException, ClassNotFoundException {
        String str = "delete from cart where proId=? and userId=?";
        preparedStatement = connection.prepareStatement(str);

        try {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean increaseCart(int id, int userId) throws SQLException {
        String cartPro = "select * from cart where proId=? and userId=?";

        preparedStatement = connection.prepareStatement(cartPro);
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, userId);
        ResultSet rs  = preparedStatement.executeQuery();

        if (rs.next()){
            int quantity = rs.getInt("quantity");
            String str = "update cart set quantity=? where proId=? and userId=?";

            preparedStatement = connection.prepareStatement(str);
            preparedStatement.setInt(1,quantity+1);
            preparedStatement.setInt(2, id);
            preparedStatement.setInt(3, userId);

            int res = preparedStatement.executeUpdate();

            if (res > 0){
                return true;
            }

            }
        return false;
    }

    public boolean decreaseCart(int id, int userId) throws SQLException {
        String cartPro = "select * from cart where proId=? and userId=?";

        preparedStatement = connection.prepareStatement(cartPro);
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, userId);
        ResultSet rs  = preparedStatement.executeQuery();

        if (rs.next()){
            int quantity = rs.getInt("quantity");
            String str = "update cart set quantity=? where proId=? and userId=?";

            preparedStatement = connection.prepareStatement(str);
            preparedStatement.setInt(1,quantity-1);
            preparedStatement.setInt(2, id);
            preparedStatement.setInt(3, userId);

            int res = preparedStatement.executeUpdate();

            if (res > 0){
                return true;
            }

        }
        return false;
    }


}
