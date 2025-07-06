/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Yasmim Mendes
 */

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.EquipamentoModel;
import util.Conexao;

public class EquipamentoController {
    public boolean inserir(EquipamentoModel equipamento){
        boolean retorno = false;
        //CONECTAR COM O BANCO//
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL INSERT//  
        //TALVEZ ERRADO// N 29
        String sql = "insert into equipamento (nome, especialidade, descricao)values (?,?,?)";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS//
            sentenca.setString(1, equipamento.getNome());
            sentenca.setString(2, equipamento.getEspecialidade());
            sentenca.setString(3, equipamento.getDescricao());
            //EXEC SENTENÇA//
            if(!sentenca.execute()){
                retorno = true;
            }
        } catch(SQLException e){
            System.out.println("Erro na sentenca SQL"+ e.getMessage());
        }
        //DESCONECTAR//
        c.desconectar();
        return retorno;
    }
    
    public boolean excluir(EquipamentoModel equipamento){
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "Delete from equipamento where id_equipamento = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, equipamento.getId_equipamento());
            if(!sentenca.execute()){
                retorno = true;
            }
        } catch(SQLException e){
            System.out.println("Falha ao deletar "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public EquipamentoModel selecionar( EquipamentoModel equipamento){
        EquipamentoModel retorno = null;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "select * from equipamento where id_equipamento = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, equipamento.getId_equipamento());
            ResultSet result = sentenca.executeQuery();
            if(result.next()){
               retorno = new EquipamentoModel();
               retorno.setId_equipamento(result.getInt("id_equipamento"));
               retorno.setNome(result.getString("nome"));
               retorno.setEspecialidade(result.getString("especialidade"));
               retorno.setDescricao(result.getString("descricao"));
            }
        } catch(SQLException e){
            System.out.println("Erro na seleção "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public ArrayList<EquipamentoModel> selecionarTodos(){
        ArrayList<EquipamentoModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        String sql = "select * from equipamento";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                EquipamentoModel eq = new EquipamentoModel();
                eq.setId_equipamento(result.getInt("id_equipamento"));
                eq.setNome(result.getString("nome"));
                eq.setEspecialidade(result.getString("especialidade"));
                eq.setDescricao(result.getString("descricao"));
                retorno.add(eq);
            }
        } catch(SQLException e){
            System.out.println("Erro na seleção "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
}
