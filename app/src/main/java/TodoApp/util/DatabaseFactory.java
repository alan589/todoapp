/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TodoApp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ALAN
 */
public class DatabaseFactory {

    public static void createDatabase(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "CREATE DATABASE IF NOT EXISTS " + name;

        try {
            // criar a conexao com o banco de dados
            connection = ConnectionFactory.getConnection("");
            // prepara a query sql
            statement = connection.prepareStatement(sql);
            statement.execute();
            createTables();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar database " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }
    }

    public static void createTables() {
        String sqlTable1 = "CREATE TABLE IF NOT EXISTS projects ("
                + "ID int(11) AUTO_INCREMENT, "
                + "IDUSER int(11) NOT NULL, "
                + "NAME varchar(50) NOT NULL, "
                + "DESCRIPTION varchar(255), "
                + "CREATEAT datetime NOT NULL, "
                + "UPDATEAT datetime NOT NULL, "
                + "PRIMARY KEY (ID), "
                + "FOREIGN KEY (IDUSER) REFERENCES users(ID)"
                + ")";

        String sqlTable2 = "CREATE TABLE IF NOT EXISTS tasks ("
                + "IDPROJECT int(11) NOT NULL, "
                + "ID int(11) AUTO_INCREMENT, "
                + "NAME varchar(50) NOT NULL, "
                + "DESCRIPTION varchar(255), "
                + "NOTES varchar(255), "
                + "COMPLETED bit(1) NOT NULL, "
                + "DEADLINE date NOT NULL, "
                + "CREATEAT datetime NOT NULL, "
                + "UPDATEAT datetime NOT NULL, "
                + "PRIMARY KEY (ID), "
                + "FOREIGN KEY (IDPROJECT) REFERENCES projects(ID)"
                + ")";
        
        String sqlTable3 = "CREATE TABLE IF NOT EXISTS users ("
                + "ID int(11) AUTO_INCREMENT, "
                + "USERNAME varchar(50) NOT NULL, "
                + "PASSWORD varchar(50) NOT NULL, "
                + "PRIMARY KEY (ID)"
                + ")";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection("todoapp");
            statement = connection.prepareStatement(sqlTable3);
            statement.execute();
            statement = connection.prepareStatement(sqlTable1);
            statement.execute();
            statement = connection.prepareStatement(sqlTable2);
            statement.execute();
            

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar a tabela " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }

    }
}
