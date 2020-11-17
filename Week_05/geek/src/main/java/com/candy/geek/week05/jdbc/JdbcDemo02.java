package com.candy.geek.week05.jdbc;

import java.sql.*;

/**
 * @author zh0809
 * @date 2020/11/16 17:22
 **/
public class JdbcDemo02 {

    public static void main(String[] args) {
        String sql = "select * from sys_user where user_id = ?";
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 1);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String userName = resultSet.getString("username");
                System.out.println("userName = " + userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet, statement, connection);
        }
    }

}
