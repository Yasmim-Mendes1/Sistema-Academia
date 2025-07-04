/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.EquipamentoModel;
import util.Conexao;

/**
 *
 * @author Yasmim Mendes
 */
public class EquipamentoController {
    public boolean inserir(EquipamentoModel equipamento){
        boolean retorno = false;
        //CONECTAR COM O BANCO//
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL INSERT//  
        //TALVEZ ERRADO// N 29
        String sql = "insert into equipamento (Nome_equipamento, Espec_equipamento, Descricao_equipamento)values (?,?,?)";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS//
            sentenca.setString(1, equipamento.getNomeequipamento());
            sentenca.setString(2, equipamento.getEspecequipamento());
            sentenca.setString(3, equipamento.getDescricaoequipamento());
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
    
    public boolean editar(EquipamentoModel equipamento){
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "update equipamento set Nome_equipamento = ?, " 
        + " Espec_equipamento = ?, Descricao_equipamento = ? where = Id_equipamento = ?";       
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setString(1, equipamento.getNomeequipamento());
            sentenca.setString(2, equipamento.getEspecequipamento());
            sentenca.setString(3, equipamento.getDescricaoequipamento());
            sentenca.setInt(4, equipamento.getIdequipamento());
            if(!sentenca.execute()){
                retorno = true;
            }  
        } catch (SQLException e){
            System.out.println("Erro ao Editar "+ e.getMessage());
        }   
        c.desconectar();
        return retorno;
    }
    
    public boolean excluir(EquipamentoModel equipamento){
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "Delete from equipamento where Id_equipamento = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, equipamento.getIdequipamento());
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
        String sql = "select * from equipamento where Id_equipamento = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, equipamento.getIdequipamento());
            ResultSet result = sentenca.executeQuery();
            if(result.next()){
               retorno = new EquipamentoModel();
               retorno.setIdequipamento(result.getInt("Idequipamento"));
               retorno.setNomeequipamento(result.getString("Nomeequipamento"));
               retorno.setEspecequipamento(result.getString("Especequipamento"));
               retorno.setDescricaoequipamento(result.getString("Descricaoequipamento"));
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
                eq.setIdequipamento(result.getInt("Idequipamento"));
                eq.setNomeequipamento(result.getString("Nomeequipamento"));
                eq.setEspecequipamento(result.getString("Especequipamento"));
                eq.setDescricaoequipamento(result.getString("Descricaoequipamento"));
                retorno.add(eq);
            }
        } catch(SQLException e){
            System.out.println("Erro na seleção "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
}
