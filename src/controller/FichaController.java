/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.Conexao;
import model.FichaModel;
import model.AlunoModel;
import model.InstrutorModel;

public class FichaController {
    
    public boolean inserir(FichaModel ficha) {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "INSERT INTO ficha (id_aluno, id_instrutor, objetivo, data_criacao) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, ficha.getAluno().getId_aluno());
            sentenca.setInt(2, ficha.getInstrutor().getId_instrutor());
            sentenca.setString(3, ficha.getObjetivo());
            sentenca.setTimestamp(4, ficha.getData_criacao());

            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir ficha: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }

    public boolean editar(FichaModel ficha) {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "UPDATE ficha SET id_aluno = ?, id_instrutor = ?, objetivo = ?, data_criacao = ? WHERE id_ficha = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, ficha.getAluno().getId_aluno());
            sentenca.setInt(2, ficha.getInstrutor().getId_instrutor());
            sentenca.setString(3, ficha.getObjetivo());
            sentenca.setTimestamp(4, ficha.getData_criacao());
            sentenca.setInt(5, ficha.getId_ficha());

            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar ficha: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }


    public boolean excluir(FichaModel ficha) {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "DELETE FROM ficha WHERE id_ficha = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, ficha.getId_ficha());
            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar ficha! " + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }


    public FichaModel selecionar(FichaModel ficha) {
        FichaModel retorno = null;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "SELECT f.id_ficha, f.objetivo, f.data_criacao, "
                   + "a.id_aluno, a.nome AS nome_aluno, "
                   + "i.id_instrutor, i.nome AS nome_instrutor "
                   + "FROM ficha f "
                   + "JOIN aluno a ON f.id_aluno = a.id_aluno "
                   + "JOIN instrutor i ON f.id_instrutor = i.id_instrutor "
                   + "WHERE f.id_ficha = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, ficha.getId_ficha());
            ResultSet result = sentenca.executeQuery();

            if (result.next()) {
                retorno = new FichaModel();
                retorno.setId_ficha(result.getInt("id_ficha"));
                retorno.setObjetivo(result.getString("objetivo"));
                retorno.setData_criacao(result.getTimestamp("data_criacao"));

                AlunoModel aluno = new AlunoModel();
                aluno.setId_aluno(result.getInt("id_aluno"));
                aluno.setNome(result.getString("nome_aluno"));
                retorno.setAluno(aluno);

                InstrutorModel instrutor = new InstrutorModel();
                instrutor.setId_instrutor(result.getInt("id_instrutor"));
                instrutor.setNome(result.getString("nome_instrutor"));
                retorno.setInstrutor(instrutor);
            }
        } catch (SQLException e) {
            System.out.println("Erro na seleção da ficha: " + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }


    public ArrayList<FichaModel> selecionarTodos() {
        ArrayList<FichaModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();

        String sql = "SELECT f.id_ficha, f.objetivo, f.data_criacao, "
                   + "a.id_aluno, a.nome AS nome_aluno, "
                   + "i.id_instrutor, i.nome AS nome_instrutor "
                   + "FROM ficha f "
                   + "JOIN aluno a ON f.id_aluno = a.id_aluno "
                   + "JOIN instrutor i ON f.id_instrutor = i.id_instrutor";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();

            while (result.next()) {
                FichaModel ficha = new FichaModel();

                ficha.setId_ficha(result.getInt("id_ficha"));
                ficha.setObjetivo(result.getString("objetivo"));
                ficha.setData_criacao(result.getTimestamp("data_criacao"));

                AlunoModel aluno = new AlunoModel();
                aluno.setId_aluno(result.getInt("id_aluno"));
                aluno.setNome(result.getString("nome_aluno"));
                ficha.setAluno(aluno);

                InstrutorModel instrutor = new InstrutorModel();
                instrutor.setId_instrutor(result.getInt("id_instrutor"));
                instrutor.setNome(result.getString("nome_instrutor"));
                ficha.setInstrutor(instrutor);

                retorno.add(ficha);
            }
        } catch (SQLException e) {
            System.out.println("Erro na seleção de todas as fichas: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }
}