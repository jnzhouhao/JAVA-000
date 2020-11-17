package com.candy.geek.week05.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author zh0809
 * @date 2020/11/16 17:09
 **/
public class DBUtil {

    private static final String URL = "jdbc:mysql://10.20.12.24:33060/qlgd_ybt_staff?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PWD = "password";

    static {
        // 注册驱动
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        // 取得数据库连接
        try {
            con = DriverManager.getConnection(URL, USER, PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(AutoCloseable... closeable) {
        for (AutoCloseable autoCloseable : closeable) {
            try {
                if (autoCloseable != null) {
                    autoCloseable.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
