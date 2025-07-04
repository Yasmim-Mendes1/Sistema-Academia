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
    private int Id_instrutor;
    private String Nome_instrutor;
    private String telefone;
    private String Espec_instrutor;
    
    public InstrutorModel(int Id_instrutor, String Nome_instrutor, String telefone, String Espec_instrutor){
        this.Id_instrutor = Id_instrutor;
        this.Nome_instrutor = Nome_instrutor;
        this.telefone = telefone;
        this.Espec_instrutor = Espec_instrutor;
    }
    
    public InstrutorModel(){
        Id_instrutor = 0;
        Nome_instrutor = " ";
        telefone = " ";
        Espec_instrutor = " ";
    }

    public int getIdinstrutor() {
        return Id_instrutor;
    }

    public void setIdinstrutor(int Id_instrutor) {
        this.Id_instrutor = Id_instrutor;
    }

    public String getNomeinstrutor() {
        return Nome_instrutor;
    }

    public void setNomeinstrutor(String Nome_instrutor) {
        this.Nome_instrutor = Nome_instrutor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEspecinstrutor() {
        return Espec_instrutor;
    }

    public void setEspecinstrutor(String Espec_instrutor) {
        this.Espec_instrutor = Espec_instrutor;
    }
}

