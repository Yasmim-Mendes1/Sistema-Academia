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
    private int Id_equipamento;
    private String Nome_equipamento;
    private String Espec_equipamento;
    private String Descricao_equipamento;
    
    public EquipamentoModel(int Id_equipamento, String Nome_equipamento, String Espec_equipamento, String Descricao_equipamento){
        this.Id_equipamento = Id_equipamento;
        this.Nome_equipamento = Nome_equipamento;
        this.Espec_equipamento = Espec_equipamento;
        this.Descricao_equipamento = Descricao_equipamento;
    }
    
    public EquipamentoModel(){
        this.Id_equipamento = 0;
        this.Nome_equipamento = " ";
        this.Espec_equipamento = "";
        this.Descricao_equipamento = " ";
    }

    public int getIdequipamento() {
        return Id_equipamento;
    }

    public void setIdequipamento(int Id_equipamento) {
        this.Id_equipamento = Id_equipamento;
    }

    public String getNomeequipamento() {
        return Nome_equipamento;
    }

    public void setNomeequipamento(String Nome_equipamento) {
        this.Nome_equipamento = Nome_equipamento;
    }

    public String getEspecequipamento() {
        return Espec_equipamento;
    }

    public void setEspecequipamento(String Espec_equipamento) {
        this.Espec_equipamento = Espec_equipamento;
    }

    public String getDescricaoequipamento() {
        return Descricao_equipamento;
    }

    public void setDescricaoequipamento(String Descricaoequipamento) {
        this.Descricao_equipamento = Descricao_equipamento;
    }
}
