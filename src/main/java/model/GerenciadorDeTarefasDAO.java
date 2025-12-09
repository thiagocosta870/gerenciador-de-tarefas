/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Thiag
 */
public class GerenciadorDeTarefasDAO {
    private static final String ARQUIVO_GERENCIADOR_DE_TAREFAS = "gerenciadorDeTarefas_db.txt";
    
    //Converter linha de texto em objeto:
    
    private ModelTarefas parseTarefas (String linha) {
        String[] partes = linha.split(";");
        if (partes.length == 4){
            try{
                int id = Integer.parseInt (partes [0]);
                String titulo = partes [1];
                String descricao = partes [2];
                String status = partes [3];
                return new ModelTarefas (id, titulo, descricao, status);
            } catch (NumberFormatException e) {
                System.out.println("Linha idnorada por formato incorreto do id" + linha);
            }
        }
        return null;
    }
    
    
    
}
