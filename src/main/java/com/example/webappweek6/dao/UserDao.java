package com.example.webappweek6.dao;

import userModel.connection.DbCon;
import userModel.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
int userID;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;


    public String userLogin(String email, String password) {
        String str = "invalid";
        try {
            query = "select * from user where email=? and password=?";
            pst = DbCon.getConnection().prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
                String resEmail = rs.getString("email");
                String passWord = rs.getString("password");

                if((resEmail.equals(email)) && (passWord.equals(password))){
                     str = rs.getString("role");
                }
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return str;
    }

    public boolean userSignUp(String email, String password) throws SQLException, ClassNotFoundException {
        query = "select * from user where email=? and password=?";
        pst = DbCon.getConnection().prepareStatement(query);
        pst.setString(1, email);
        pst.setString(2, password);
        rs = pst.executeQuery();
            rs.next();

                query = "insert into user(email, password) VALUES(?,?)";
                pst = DbCon.getConnection().prepareStatement(query);
                pst.setString(1, email);
                pst.setString(2, password);
                int result = pst.executeUpdate();
                if (result > 0) return true;



        return false;
    }

//    public ResultSet getUser(String email){
//
//    }
    public int getUserId(String email,String password){
        try {
            query = "select user_id from user where email=? and password=?";
            pst = DbCon.getConnection().prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()) {
                userID = rs.getInt("user_id");
            }
            }
        catch (Exception e){
            e.getMessage();
        }
       return userID;
    }
}