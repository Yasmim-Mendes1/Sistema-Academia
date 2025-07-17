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
import model.InstrutorModel;
import util.Conexao;

public class InstrutorController {
    public boolean inserir(InstrutorModel instrutor){
        boolean retorno = false;
        //CONECTAR COM O BANCO//
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL INSERT//  
        String sql = "insert into instrutor (nome, telefone, especialidade)values (?,?,?)";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS//
            sentenca.setString(1, instrutor.getNome());
            sentenca.setString(2, instrutor.getTelefone());
            sentenca.setString(3, instrutor.getEspecialidade());
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
    
    public boolean editar(InstrutorModel instrutor){
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "update instrutor set nome = ?, telefone = ?, especialidade = ? where id_instrutor = ?";

        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setString(1, instrutor.getNome());
            sentenca.setString(2, instrutor.getTelefone());
            sentenca.setString(3, instrutor.getEspecialidade());
            sentenca.setInt(4, instrutor.getId_instrutor());
            if(!sentenca.execute()){
                retorno = true;
            }  
        } catch (SQLException e){
            System.out.println("Erro ao Editar "+ e.getMessage());
        }   
        c.desconectar();
        return retorno;
    }
    
    public boolean excluir(InstrutorModel instrutor){
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "Delete from instrutor where id_instrutor = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1,instrutor.getId_instrutor());
            if(!sentenca.execute()){
                retorno = true;
            }
        } catch(SQLException e){
            System.out.println("Falha ao deletar "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public InstrutorModel selecionar( InstrutorModel instrutor){
        InstrutorModel retorno = null;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "select * from instrutor where id_instrutor = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, instrutor.getId_instrutor());
            ResultSet result = sentenca.executeQuery();
            if(result.next()){
               retorno = new InstrutorModel();
               retorno.setId_instrutor(result.getInt("id_instrutor"));
               retorno.setNome(result.getString("nome"));
               retorno.setTelefone(result.getString("telefone"));
               retorno.setEspecialidade(result.getString("especialidade"));
            }
        } catch(SQLException e){
            System.out.println("Erro na seleção "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public ArrayList<InstrutorModel> selecionarTodos(){
        ArrayList<InstrutorModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();
        String sql = "select * from instrutor";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                InstrutorModel i = new InstrutorModel();
                i.setId_instrutor(result.getInt("id_instrutor"));
                i.setNome(result.getString("nome"));
                i.setTelefone(result.getString("telefone"));
                i.setEspecialidade(result.getString("especialidade"));
                retorno.add( i);
            }
        } catch(SQLException e){
            System.out.println("Erro na seleção "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
}
