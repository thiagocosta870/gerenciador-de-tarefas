/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import view.ViewTarefasDetalhes;

/**
 *
 * @author Thiag
 */

public class ModelTarefas {
    // Atributos 
    private int id;
    private String titulo;
    private String descricao;
    private String status;
    
    //Construtor
    public ModelTarefas (int id, String titulo, String descricao, String status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
    }

    public ModelTarefas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String toFileString() {
        return id + ";" + titulo + ";" + descricao + ";" + status;
    }
    
    
    // Getter
    public int getId(){
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getDescricao () {
        return descricao;
    }
    
    public String getStatus () {
        return status;
    }
    
    // Setters
    public void setId (int id) {
        this.id = id;
    }
    
    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }
    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }
    public void setStatus (String status) {
        this.status = status;
    }
     
}
