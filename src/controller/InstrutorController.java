/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.InstrutorModel;
import util.Conexao;
/**
 *
 * @author Yasmim Mendes
 */
public class InstrutorController {
    public boolean inserir(InstrutorModel instrutor){
        boolean retorno = false;
        //CONECTAR COM O BANCO//
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL INSERT//  
        //TALVEZ ERRADO// N 29
        String sql = "insert into instrutor (Nome_instrutor, telefone, Espec_instrutor)values (?,?,?)";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS//
            sentenca.setString(1, instrutor.getNomeinstrutor());
            sentenca.setString(2, instrutor.getTelefone());
            sentenca.setString(3, instrutor.getEspecinstrutor());
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
        String sql = "update instrutor set Nome_instrutor = ?, " 
        + " telefone = ?, Espec_instrutor = ? where = Id_instrutor = ?";       
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setString(1, instrutor.getNomeinstrutor());
            sentenca.setString(2, instrutor.getTelefone());
            sentenca.setString(3, instrutor.getEspecinstrutor());
            sentenca.setInt(4, instrutor.getIdinstrutor());
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
        String sql = "Delete from instrutor where Id_instrutor = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1,instrutor.getIdinstrutor());
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
        String sql = "select * from instrutor where Id_instrutor = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, instrutor.getIdinstrutor());
            ResultSet result = sentenca.executeQuery();
            if(result.next()){
               retorno = new InstrutorModel();
               retorno.setIdinstrutor(result.getInt("Idinstrutor"));
               retorno.setNomeinstrutor(result.getString("Nomeinstrutor"));
               retorno.setTelefone(result.getString("telefone"));
               retorno.setEspecinstrutor(result.getString("Especinstrutor"));
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
        String sql = "select * from equipamento";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            while(result.next()){
                InstrutorModel i = new InstrutorModel();
                i.setIdinstrutor(result.getInt("Idinstrutor"));
                i.setNomeinstrutor(result.getString("Nomeinstrutor"));
                i.setTelefone(result.getString("Telefone"));
                i.setEspecinstrutor(result.getString("Especinstruto"));
                retorno.add( i);
            }
        } catch(SQLException e){
            System.out.println("Erro na seleção "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
}
