/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yasmim Mendes
 */
public class ExercicioModel {
    private int id_exercicio;
    private EquipamentoModel id_equipamento = new EquipamentoModel();
    String nome;
    String grupo_muscular;
    
    public ExercicioModel(){
        id_exercicio = 0;
        id_equipamento = new EquipamentoModel();
        nome = "";
        grupo_muscular = "";
    }
    
    public int getIdExercicio(){
        return id_exercicio;
    }
    public void setIdExercio(int id_exercicio){
        this.id_exercicio = id_exercicio;
    }
    
    public EquipamentoModel getIdEquipamento(){
        return id_equipamento;
    }
    public void setIdEquipamento(EquipamentoModel id_equipamento){
        this.id_equipamento = id_equipamento;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getGrupoMuscular(){
        return grupo_muscular;
    }
    public void setGrupoMuscular(String grupo_muscular){
        this.grupo_muscular = grupo_muscular;
    }
}