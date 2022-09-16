/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TodoApp.model;

import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Project {
    private int id;
    private int idUser;
    private String name;
    private String description;
    private Date createAt;
    private Date updateAt;

    public Project(int id, int idUser, String name, String description, Date createAt, Date updateAt) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Project() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
    

    @Override
    public String toString() {
        return this.name;
    }
    
    
    
}
