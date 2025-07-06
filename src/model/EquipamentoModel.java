/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yasmim Mendes
 */
public class EquipamentoModel {
    private int id_equipamento;
    private String nome;
    private String especialidade;
    private String descricao;

    public EquipamentoModel(int id_equipamento, String nome, String especialidade, String descricao){
        this.id_equipamento = id_equipamento;
        this.nome = nome;
        this.especialidade = especialidade;
        this.descricao = descricao;
    }
    
    public EquipamentoModel(){
        this.id_equipamento = 0;
        this.nome = " ";
        this.especialidade = "";
        this.descricao = " ";
    }

    public int getId_equipamento() {
        return id_equipamento;
    }

    public void setId_equipamento(int id_equipamento) {
        this.id_equipamento = id_equipamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
