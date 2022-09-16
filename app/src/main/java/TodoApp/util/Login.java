/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TodoApp.util;

import TodoApp.model.Task;
import TodoApp.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class Login {
    public static User login(String username, String password){
         Connection connection = null;
         PreparedStatement statement = null;
         ResultSet resultSet = null;
         
         String sql = "SELECT * FROM users WHERE USERNAME = ? and PASSWORD = ?";
         User user = new User();
         
         try {
            connection = ConnectionFactory.getConnection("todoapp");
             
             // prepara a query sql
            statement = connection.prepareStatement(sql);
            // seta os valores dos respectivos campos
            statement.setString(1, username);
            statement.setString(2, password);
            // executa o comando de seleção
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                user.setId(resultSet.getInt("ID"));
                user.setUsername(resultSet.getString("USERNAME"));
                user.setUsername(resultSet.getString("PASSWORD"));
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter os dados do usuario " + e.getMessage(), e);
        } finally {
            // fecha conexão com o banco de dados
            ConnectionFactory.closeConnection(connection, statement, resultSet);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }
         
        return user;
         
    }
}
