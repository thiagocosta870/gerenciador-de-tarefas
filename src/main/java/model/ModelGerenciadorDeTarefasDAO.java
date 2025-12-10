/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiag
 */
public class ModelGerenciadorDeTarefasDAO {
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
                System.out.println("Linha ignorada por formato incorreto do id" + linha);
            }
        }
        return null;
    }
    
     public List<ModelTarefas> listarTodas() {
     List<ModelTarefas> tarefas = new ArrayList<>();
     File arquivo = new File(ARQUIVO_GERENCIADOR_DE_TAREFAS);
     
      if (!arquivo.exists() || arquivo.length() == 0) {
            return tarefas;
        }
    
      try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_GERENCIADOR_DE_TAREFAS))) {
      String linha;
      while ((linha = reader.readLine()) != null) {
        if (linha.trim().isEmpty()) continue;
        
        ModelTarefas tarefa = parseTarefas(linha);
        if (tarefa != null) {
        tarefas.add(tarefa);
        }
        }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo de tarefas: " + e.getMessage());
        }
            return tarefas;
      }
        
     public void salvar (ModelTarefas tarefa){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_GERENCIADOR_DE_TAREFAS, true))) {
            writer.write(tarefa.toFileString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao salvar tarefa no arquivo: " + e.getMessage());
        }
        }
     
     
        }