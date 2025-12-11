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
import java.util.stream.Collectors;

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
        
        public boolean atualizar (ModelTarefas tarefaAtualizada){
            List<ModelTarefas> tarefas = listarTodas();
            boolean encontrada = false;
            
            for (int i=0; i<tarefas.size(); i++){
                ModelTarefas tarefaExistente = tarefas.get(i);
                if (tarefaExistente.getId() == (tarefaAtualizada.getId())) {
                    
                    tarefaExistente.setTitulo(tarefaAtualizada.getTitulo()); 
                    tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
                    tarefaExistente.setStatus(tarefaAtualizada.getStatus());
                    
                    encontrada = true;
                    break;
                }
            }
            
            if (encontrada) {
                reescreverArquivo (tarefas);
                return true;
            }
            System.err.println(">>>> ATUALIZAR FALHOU: Tarefa com ID " + tarefaAtualizada.getId() + " não encontrada."); // <--- ADICIONE ESTA LINHA!
            return false;
               
        }
        
        public boolean deletar (int id) {
            List<ModelTarefas> tarefas = listarTodas();
            
            List<ModelTarefas> tarefasRestantes = tarefas.stream()
                    .filter(c -> !(c.getId() == id))
                    .collect(Collectors.toList());
                    
            if (tarefasRestantes.size() < tarefas.size()){
                reescreverArquivo (tarefasRestantes);
                return true;
            }
            return false;
        } 
        
        private void reescreverArquivo(List<ModelTarefas> tarefas){
            try (BufferedWriter writer = new BufferedWriter (new FileWriter (ARQUIVO_GERENCIADOR_DE_TAREFAS, false))){
                
                for (ModelTarefas tarefa : tarefas){
                    writer.write (tarefa.toFileString());
                    writer.newLine();
                    
                    
                }
            } catch (IOException e) {
                System.err.println("Erro ao reescrever arquivo: " + e.getMessage());
            }
        }
     
     
        }