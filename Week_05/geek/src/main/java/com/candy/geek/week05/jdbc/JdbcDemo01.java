package com.candy.geek.week05.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zh0809
 * @date 2020/11/16 17:15
 **/
public class JdbcDemo01 {

    public static void main(String[] args) {
        String sql = "select * from sys_user where user_id = 1";
        Connection connection = DBUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
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
