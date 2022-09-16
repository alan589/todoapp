/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TodoApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aluno
 */
public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String USER = "root";
    public static final String PASS = "";

    public static Connection getConnection(String databaseName) {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL + databaseName, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("\nErro ao tentar se conectar com o banco de dados", e);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("\nErro ao fechar a conexão", e);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }

        } catch (Exception e) {
            throw new RuntimeException("\nErro ao fechar a conexão", e);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement,
            ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }

        } catch (Exception e) {
            throw new RuntimeException("\nErro ao fechar a conexão", e);
        }
    }

}
