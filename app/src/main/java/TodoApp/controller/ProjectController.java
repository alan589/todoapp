/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TodoApp.controller;

import TodoApp.model.Project;
import TodoApp.model.User;
import TodoApp.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ProjectController {

    public void save(Project project) {
        Connection connection = null;
        PreparedStatement statement = null;

        // comando de inserção sql
        String sql = "INSERT INTO projects(NAME,"
                + "IDUSER,"
                + "DESCRIPTION,"
                + "CREATEAT,"
                + "UPDATEAT)"
                + "VALUES (?,?,?,?,?)";

        try {
            // criar a conexao com o banco de dados
            connection = ConnectionFactory.getConnection("todoapp");

            // prepara a query sql
            statement = connection.prepareStatement(sql);

            // seta os valores dos respectivos campos
            statement.setString(1, project.getName());
            statement.setInt(2, project.getIdUser());
            statement.setString(3, project.getDescription());
            statement.setDate(4, new Date(project.getCreateAt().getTime()));
            statement.setDate(5, new Date(project.getUpdateAt().getTime()));

            // executa o comando de inserção
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o projeto " + e.getMessage(), e);
        } finally {
            // fecha conexão com o banco de dados, statement
            ConnectionFactory.closeConnection(connection, statement);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }
    }

    public void update(Project project) {
        Connection connection = null;
        PreparedStatement statement = null;
        // comando de atualização sql
        String sql = "UPDATE projects SET "
                + "NAME = ?, "
                + "DESCRIPTION = ?, "
                + "CREATEAT = ?, "
                + "UPDATEAT = ? "
                + "WHERE ID = ?";
        
        try {
            // criar a conexao com o banco de dados
            connection = ConnectionFactory.getConnection("todoapp");

            // prepara a query sql
            statement = connection.prepareStatement(sql);

            // seta os valores dos respectivos campos    
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreateAt().getTime()));
            statement.setDate(4, new Date(project.getUpdateAt().getTime()));
            statement.setInt(5, project.getId());

            // executa o comando de atualização
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar o projeto " + e.getMessage(), e);
        } finally {
            // fecha conexão com o banco de dados, statement
            ConnectionFactory.closeConnection(connection, statement);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }

    }

    public void removeById(int projectId) {
        // comando de remoção sql
        String sql = "DELETE FROM projects WHERE ID = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // criar a conexao com o banco de dados
            connection = ConnectionFactory.getConnection("todoapp");

            // prepara a query sql
            statement = connection.prepareStatement(sql);

            // seta os valores dos respectivos campos
            statement.setInt(1, projectId);

            // executa o comando de remoção
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar o projeto");
        } finally {
            // fecha conexão com o banco de dados, statement
            ConnectionFactory.closeConnection(connection, statement);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }
    }

    public List<Project> getAll() {
        Connection connection = null;
        PreparedStatement statement = null;

        // classe para armazenar os dados vindo do banco de dados
        ResultSet resultSet = null;

        List<Project> projects = new ArrayList<Project>();
        // comando de seleção sql
        String sql = "SELECT * FROM projects";

        try {
            // criar a conexao com o banco de dados
            connection = ConnectionFactory.getConnection("todoapp");

            // prepara a query sql
            statement = connection.prepareStatement(sql);

            // executa o comando de seleção
            resultSet = statement.executeQuery();

            // seta para cada project os respectivos valores
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("ID"));
                project.setName(resultSet.getString("NAME"));
                project.setDescription(resultSet.getString("DESCRIPTION"));
                project.setCreateAt(resultSet.getDate("CREATEAT"));
                project.setUpdateAt(resultSet.getDate("UPDATEAT"));

                // adiciona o project na lista
                projects.add(project);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter os projetos " + e.getMessage(), e);
        } finally {
            // fecha conexão com o banco de dados, statement e resultSet
            ConnectionFactory.closeConnection(connection, statement, resultSet);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }
        // retorna a lista de project
        return projects;

    }
    
    public List<Project> getAll(User user) {
        Connection connection = null;
        PreparedStatement statement = null;

        // classe para armazenar os dados vindo do banco de dados
        ResultSet resultSet = null;

        List<Project> projects = new ArrayList<Project>();
        // comando de seleção sql
        String sql = "SELECT * FROM projects WHERE IDUSER = ?";

        try {
            // criar a conexao com o banco de dados
            connection = ConnectionFactory.getConnection("todoapp");

            // prepara a query sql
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, user.getId());

            // executa o comando de seleção
            resultSet = statement.executeQuery();

            // seta para cada project os respectivos valores
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("ID"));
                project.setIdUser(resultSet.getInt("IDUSER"));
                project.setName(resultSet.getString("NAME"));
                project.setDescription(resultSet.getString("DESCRIPTION"));
                project.setCreateAt(resultSet.getDate("CREATEAT"));
                project.setUpdateAt(resultSet.getDate("UPDATEAT"));

                // adiciona o project na lista
                projects.add(project);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter os projetos " + e.getMessage(), e);
        } finally {
            // fecha conexão com o banco de dados, statement e resultSet
            ConnectionFactory.closeConnection(connection, statement, resultSet);
            System.out.println("A conexão com o banco de dados foi fechada com sucesso");
        }
        // retorna a lista de project
        return projects;

    }

    public int getProjectId(Project project) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        int projectId;

        String sql = "SELECT ID FROM projects WHERE NAME = ?";

        try {
            connection = ConnectionFactory.getConnection("todoapp");
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            resultSet = statement.executeQuery();
            resultSet.next();
            projectId = resultSet.getInt("ID");

        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter o ID do projeto " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        return projectId;
    }
}
