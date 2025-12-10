 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.Random;
import model.ModelGerenciadorDeTarefasDAO;
import model.ModelTarefas;

/**
 *
 * @author Thiag
 */
public class ControllerTarefas {
    private ModelGerenciadorDeTarefasDAO dao = new ModelGerenciadorDeTarefasDAO();
    
    
    public boolean cadastrarTarefa (String titulo, String descricao, String status){
        if (titulo == null || titulo.trim().isEmpty() || descricao == null || descricao.trim().isEmpty()){
            System.err.println("Erro. O titulo e a descricao nao podem ser vazios. ");
            return false;
        }
        
        Random geradorId = new Random();
        int idGerado = geradorId.nextInt(9000) + (1000);
        
        ModelTarefas novaTarefa = new ModelTarefas (idGerado, titulo, descricao, status);
        
        dao.salvar (novaTarefa);
        return true;
    }
    
    public List<ModelTarefas> listaTarefas () {
        return dao.listarTodas();
    }
    
}
