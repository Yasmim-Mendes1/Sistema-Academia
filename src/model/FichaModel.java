/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yasmim Mendes
 */
import java.sql.Date;

public class FichaModel {
    private int id_ficha;
    private AlunoModel aluno;
    private InstrutorModel instrutor;
    private String objetivo;
    private java.sql.Timestamp data_criacao;

    
    public FichaModel(){
        id_ficha = 0;
        aluno = null;
        instrutor = null;
        objetivo = "";
        data_criacao = null;
    }
    
    public int getId_ficha() {
        return id_ficha;
    }

    public void setId_ficha(int id_ficha) {
        this.id_ficha = id_ficha;
    }

    public AlunoModel getAluno() {
        return aluno;
    }

    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }

    public InstrutorModel getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(InstrutorModel instrutor) {
        this.instrutor = instrutor;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public java.sql.Timestamp getData_criacao() {
        return data_criacao; 
    }
    
    public void setData_criacao(java.sql.Timestamp data_criacao) { 
        this.data_criacao = data_criacao; 
    }
    
    @Override
    public String toString() {
        return "Ficha ID: " + this.getId_ficha();
    }
}