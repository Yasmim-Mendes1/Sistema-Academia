/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Yasmim Mendes
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.AlunoModel;
import util.Conexao;


public class AlunoController {
    
    public boolean inserir(AlunoModel aluno){
        boolean retorno = false;
        //CONECTAR COM O BANCO//
        Conexao c = new Conexao();
        c.conectar();
        //CRIAR SQL INSERT//  
        //TALVEZ ERRADO// N 29
        String sql = "insert into aluno (idade, nome, cpf, telefone, data_matricula)values (?,?,?,?,?)";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            //PASSAR PARAMETROS//
            sentenca.setInt(1, aluno.getIdade());
            sentenca.setString(2, aluno.getNome());
            sentenca.setString(3, aluno.getCpf());
            sentenca.setString(4, aluno.getTelefone());
            sentenca.setDate(5, aluno.getData_matricula());
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
    public boolean excluir(AlunoModel aluno){
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "Delete from aluno where id_aluno = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, aluno.getId_aluno());
            if(!sentenca.execute()){
                retorno = true;
            }
        } catch(SQLException e){
            System.out.println("Falha ao deletar "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public AlunoModel selecionar( AlunoModel aluno){
        AlunoModel retorno = null;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "select * from aluno where id_aluno = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, aluno.getId_aluno());
            ResultSet result = sentenca.executeQuery();
            if(result.next()){
               retorno = new  AlunoModel();
               retorno.setId_aluno(result.getInt("id_aluno"));
               retorno.setIdade(result.getInt("idade"));
               retorno.setNome(result.getString("Nome"));
               retorno.setCpf(result.getString("Cpf"));
               retorno.setTelefone(result.getString("Telefone"));
               retorno.setData_matricula(result.getDate("data_matricula"));
            }
        } catch(SQLException e){
            System.out.println("Erro na seleção "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public ArrayList<AlunoModel> selecionarTodos() {
        ArrayList<AlunoModel> lista = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();

        String sql = "SELECT * FROM aluno";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();

            while (result.next()) {
                AlunoModel aluno = new AlunoModel();
                aluno.setId_aluno(result.getInt("id_aluno"));
                aluno.setIdade(result.getInt("idade"));
                aluno.setNome(result.getString("nome"));
                aluno.setCpf(result.getString("cpf"));
                aluno.setTelefone(result.getString("telefone"));
                aluno.setData_matricula(result.getDate("data_matricula"));

                lista.add(aluno);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar alunos: " + e.getMessage());
        }

        c.desconectar();
        return lista;
    }
}
