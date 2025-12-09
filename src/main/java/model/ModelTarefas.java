/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Thiag
 */
public class ModelTarefas {
    // Atributos 
    private int id;
    private String titulo;
    private String descricao;
    
    //Construtor
    public ModelTarefas (int id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }
    // Getter
    public int getid() {
        return id;
    }
    public String gettitulo () {
        return titulo;
    }
    public String getdescricao () {
        return descricao;
    }
    // Setters
    public void setid (int id) {
        this.id = id;
    }
    public void settitulo (String titulo) {
        this.titulo = titulo;
    }
    public void setdescricao (String descricao) {
        this.descricao = descricao;
    }
}
