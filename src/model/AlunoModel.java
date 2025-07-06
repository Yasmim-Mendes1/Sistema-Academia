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

public class AlunoModel {
    private int id_aluno, idade;
    private String nome, cpf, telefone;
    private Date data_matricula;
    
    public AlunoModel(int id_aluno, int idade, String nome, String cpf, String telefone, Date data_matricula){
        this.id_aluno = id_aluno;
        this.idade = idade;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.data_matricula = data_matricula;
    }
    
    public AlunoModel(){
        id_aluno = 0;
        idade = 0;
        nome = " ";
        cpf = " ";
        telefone = " ";
        data_matricula = null;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(Date data_matricula) {
        this.data_matricula = data_matricula;
    }   
    
    @Override
    public String toString() {
        return String.valueOf(id_aluno);
    }
}