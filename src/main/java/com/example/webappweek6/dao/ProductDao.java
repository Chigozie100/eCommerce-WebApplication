package com.example.webappweek6.dao;

import userModel.connection.DbCon;
import userModel.model.Cart;
import userModel.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public static boolean addProduct(Product product) throws SQLException, ClassNotFoundException {
        String getProduct = "SELECT * FROM product Where Pro_name= ?";

        PreparedStatement pst = DbCon.getConnection().prepareStatement(getProduct);
        pst.setString(1, product.getPro_name());


        ResultSet result = pst.executeQuery();

        String name = "";
        int quantity =0;
        while (result.next()){
            name = result.getString("pro_name");
            quantity = result.getInt("pro_qty");
        }
        if (name.equals("")){

            String addingProduct = "INSERT INTO product (pro_name, pro_price, pro_qty, pro_category) VALUES (?, ?, ?, ?)";
            PreparedStatement st = DbCon.getConnection().prepareStatement(addingProduct);
            st.setString(1, product.getPro_name());
            st.setString(2, product.getPro_price());
            st.setInt(3, product.getPro_qty());
            st.setString(4, product.getPro_category());
            int res = st.executeUpdate();
                if(res > 0){
                    return true;
                }
        }
        else {
            product.setPro_qty(product.getPro_qty() + quantity);
            String addingProduct = "UPDATE product set pro_qty = ? where Pro_name = ?";
            PreparedStatement update = DbCon.getConnection().prepareStatement(addingProduct);
            update.setInt(1, product.getPro_qty());
            update.setString(2, product.getPro_name());
            int res = update.executeUpdate();
            if(res > 0){
                return true;
            }
        }
        return false;
    }

    public static List<Product> getAllProduct() throws SQLException, ClassNotFoundException {

       List<Product> products = new ArrayList<>();
        String allProduct = "SELECT * FROM product";
        PreparedStatement t = DbCon.getConnection().prepareStatement(allProduct);
        ResultSet resultSet = t.executeQuery();

        while (resultSet.next()){
            Product product = new Product();
            product.setPro_id(resultSet.getInt("pro_id"));
           product.setPro_qty(resultSet.getInt("pro_qty"));
           product.setPro_name(resultSet.getString("pro_name"));
            product.setPro_price(resultSet.getString("pro_price"));
           product.setPro_category(resultSet.getString("pro_category"));
           product.setImage(resultSet.getString("image"));
           products.add(product);
        }
        return products;
    }

    public static boolean editProduct(Product product) throws SQLException, ClassNotFoundException {
        String sql = "update product set Pro_name= ?, pro_price=?, pro_qty=?, pro_category= ? where pro_id=? ";
        PreparedStatement a = DbCon.getConnection().prepareStatement(sql);

        int i = 0;
        try {
            a.setString(1, product.getPro_name());
            a.setString(2, product.getPro_price());
            a.setInt(3, product.getPro_qty());
            a.setString(4, product.getPro_category());
            a.setInt(5, product.getPro_id());
            i = a.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i > 0) {
            return true;
        }
        return false;
    }
    public static void deleteProduct(int id) throws SQLException, ClassNotFoundException {
        String l = "delete from product where pro_id=?";
        PreparedStatement a = DbCon.getConnection().prepareStatement(l);

        try {
            a.setInt(1, id);
            a.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
