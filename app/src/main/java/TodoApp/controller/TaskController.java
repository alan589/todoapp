/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TodoApp.controller;

import TodoApp.model.Task;
import TodoApp.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALAN
 */
public class TaskController {

    public void save(Task task) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        
        // comando de inserção sql
        String sql = "INSERT INTO tasks(IDPROJECT,"
                + "NAME,"
                + "DESCRIPTION,"
                + "COMPLETED,"
                + "NOTES,"
                + "DEADLINE,"
                + "CREATEAT,"
                + "UPDATEAT)"
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {
            // criar a conexao com o banco de dados
            connection = ConnectionFactory.getConnection("todoapp");
            
            // prepara a query sql
            statement = connection.prepareStatement(sql);
            
            // seta os valores dos respectivos campos
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreateAt().getTime()));
            statement.setDate(8, new Date(task.getUpdateAt().getTime()));
            
            // executa o comando de inserção
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a tarefa " + e.getMessage(), e);
        } finally {
            // fecha a conexão
            ConnectionFactory.closeConnection(connection, statement);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }
    }

    public void update(Task task) {
        Connection connection = null;
        PreparedStatement statement = null;
        // comando de atualização sql
        String sql = "UPDATE tasks SET "
                + "IDPROJECT = ?, "
                + "NAME = ?, "
                + "DESCRIPTION = ?, "
                + "COMPLETED = ?, "
                + "NOTES = ?, "
                + "DEADLINE = ?, "
                + "CREATEAT = ?, "
                + "UPDATEAT = ? "
                + "WHERE ID = ?";

        try {
            // criar a conexao com o banco de dados
            connection = ConnectionFactory.getConnection("todoapp");
            
            // prepara a query sql
            statement = connection.prepareStatement(sql);
            
            // seta os valores dos respectivos campos    
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreateAt().getTime()));
            statement.setDate(8, new Date(task.getUpdateAt().getTime()));
            statement.setInt(9, task.getId());
            
            // executa o comando de atualização
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a tarefa " + e.getMessage(), e);
        } finally {
            // fecha a conexão
            ConnectionFactory.closeConnection(connection, statement);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }

    }

    public void removeById(int taskId) {
        // comando de remoção sql
        String sql = "DELETE FROM tasks WHERE ID = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // criar a conexao com o banco de dados
            connection = ConnectionFactory.getConnection("todoapp");
            
            // prepara a query sql
            statement = connection.prepareStatement(sql);
            
            // seta os valores dos respectivos campos
            statement.setInt(1, taskId);
            
            // executa o comando de remoção
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar a tarefa");
        } finally {
            // fecha a conexão
            ConnectionFactory.closeConnection(connection, statement);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }
    }

    public List<Task> getAll(int projectId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Task> tasks = new ArrayList<Task>();
        // comando de seleção sql
        String sql = "SELECT * FROM tasks WHERE IDPROJECT = ?";

        try {
            // criar a conexao com o banco de dados
            connection = ConnectionFactory.getConnection("todoapp");
            
             // prepara a query sql
            statement = connection.prepareStatement(sql);
            // seta os valores dos respectivos campos
            statement.setInt(1, projectId);
            
            // executa o comando de seleção
            resultSet = statement.executeQuery();
            
            
            // seta para cada task os respectivos valores
            while (resultSet.next()) {
                Task task = new Task();
                task.setIdProject(resultSet.getInt("IDPROJECT"));
                task.setId(resultSet.getInt("ID"));
                task.setName(resultSet.getString("NAME"));
                task.setDescription(resultSet.getString("DESCRIPTION"));
                task.setIsCompleted(resultSet.getBoolean("COMPLETED"));
                task.setNotes(resultSet.getString("NOTES"));
                task.setDeadline(resultSet.getDate("DEADLINE"));
                task.setCreateAt(resultSet.getDate("CREATEAT"));
                task.setUpdateAt(resultSet.getDate("UPDATEAT"));
                
                // adiciona a task na lista
                tasks.add(task);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter as tarefas " + e.getMessage(), e);
        } finally {
            // fecha conexão com o banco de dados
            ConnectionFactory.closeConnection(connection, statement, resultSet);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }
        // retorna a lista de task
       
        return tasks;

    }

}
