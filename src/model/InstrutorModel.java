/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yasmim Mendes
 */
public class InstrutorModel {
    private int id_instrutor;
    private String nome;
    private String telefone;
    private String especialidade;

    public InstrutorModel(int id_instrutor, String nome, String telefone, String especialidade){
        this.id_instrutor = id_instrutor;
        this.nome = nome;
        this.telefone = telefone;
        this.especialidade = especialidade;
    }
    
    public InstrutorModel(){
        id_instrutor = 0;
        nome = " ";
        telefone = " ";
        especialidade = " ";
    }

    public int getId_instrutor() {
        return id_instrutor;
    }

    public void setId_instrutor(int id_instrutor) {
        this.id_instrutor = id_instrutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    @Override
    public String toString() {
        return String.valueOf(id_instrutor);
    }
}
