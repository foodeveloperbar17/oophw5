package database;

import models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private Connection connection;

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productsDB", "root", "araqvs");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        String queryString = "select * from products";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryString);
            List<Product> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(getProductRow(resultSet));
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Product getProductById(String id) {
        String queryString = "select * from products where productid = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getProductRow(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

//    public List<Product> getProductsByIds(String[] ids){
//        String queryString = "select * from products where productid in (?)";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
//            preparedStatement.setArray(1, connection.createArrayOf("String", ids));
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<Product> result = new ArrayList<>();
//            while (resultSet.next()) {
//                result.add(getProductRow(resultSet));
//            }
//            return result;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }

    private Product getProductRow(ResultSet resultSet) {
        try {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String imageFile = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            return new Product(id, name, imageFile, price);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
