/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TodoApp.controller;


import TodoApp.model.User;
import TodoApp.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class UserController {

    public void save(User user) {
        Connection connection = null;
        PreparedStatement statement = null;

        // comando de inserção sql
        String sql = "INSERT INTO users(USERNAME,"
                + "PASSWORD)"
                + "VALUES (?,?)";

        try {
            // criar a conexao com o banco de dados
            connection = ConnectionFactory.getConnection("todoapp");

            // prepara a query sql
            statement = connection.prepareStatement(sql);

            // seta os valores dos respectivos campos
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            // executa o comando de inserção
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o usuario " + e.getMessage(), e);
        } finally {
            // fecha conexão com o banco de dados, statement
            ConnectionFactory.closeConnection(connection, statement);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }
    }


    public void removeById(int projectId) {
       //implementar 
    }
    
    public List<User> getAll() {
        Connection connection = null;
        PreparedStatement statement = null;

        // classe para armazenar os dados vindo do banco de dados
        ResultSet resultSet = null;

        List<User> users = new ArrayList<User>();
        // comando de seleção sql
        String sql = "SELECT * FROM users";

        try {
            // criar a conexao com o banco de dados
            connection = ConnectionFactory.getConnection("todoapp");

            // prepara a query sql
            statement = connection.prepareStatement(sql);

            // executa o comando de seleção
            resultSet = statement.executeQuery();

            // seta para cada project os respectivos valores
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("ID"));
                user.setUsername(resultSet.getString("USERNAME"));
                user.setPassword(resultSet.getString("PASSWORD"));
                
                // adiciona o project na lista
                users.add(user);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter os usuarios " + e.getMessage(), e);
        } finally {
            // fecha conexão com o banco de dados, statement e resultSet
            ConnectionFactory.closeConnection(connection, statement, resultSet);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }
        // retorna a lista de project
        return users;

    }
}
