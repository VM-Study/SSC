package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyJDBC {
    private final String jdbc;
    private final String username;
    private final String password;
    private final String table;

    public MyJDBC(String jdbc, String username, String password, String table) {
        this.jdbc = jdbc;
        this.username = username;
        this.password = password;
        this.table = table;
    }

    public Set<String> loadDB() {
        Set<String> list = new HashSet<>();
        try {
            Connection connection = DriverManager.getConnection(jdbc, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM java.dictionary");

            while (resultSet.next()) {
                list.add(resultSet.getString(table));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
