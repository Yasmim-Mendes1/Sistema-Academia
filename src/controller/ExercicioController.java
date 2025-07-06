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
import util.Conexao;
import model.ExercicioModel;
import model.EquipamentoModel;


public class ExercicioController {

    public boolean inserir(ExercicioModel exercicio) {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "INSERT INTO exercicio (id_equipamento, nome, grupo_muscular) VALUES (?, ?, ?)";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, exercicio.getIdEquipamento().getId_equipamento());
            sentenca.setString(2, exercicio.getNome());
            sentenca.setString(3, exercicio.getGrupoMuscular());

            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir exercício: " + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public boolean editar(ExercicioModel exercicio) {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "UPDATE exercicio SET id_equipamento = ?, nome = ?, grupo_muscular = ? WHERE id_exercicio = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, exercicio.getIdEquipamento().getId_equipamento());
            sentenca.setString(2, exercicio.getNome());
            sentenca.setString(3, exercicio.getGrupoMuscular());
            sentenca.setInt(4, exercicio.getIdExercicio());

            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar exercício: " + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public boolean excluir(ExercicioModel exercicio) {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "DELETE FROM exercicio WHERE id_exercicio = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, exercicio.getIdExercicio());

            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir exercício: " + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public ExercicioModel selecionar(ExercicioModel exercicio) {
        ExercicioModel retorno = null;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "SELECT e.id_exercicio, e.nome, e.grupo_muscular, eq.id_equipamento, eq.nome AS nome_equipamento " +
                     "FROM exercicio e JOIN equipamento eq ON e.id_equipamento = eq.id_equipamento " +
                     "WHERE e.id_exercicio = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, exercicio.getIdExercicio());

            ResultSet result = sentenca.executeQuery();

            if (result.next()) {
                retorno = new ExercicioModel();
                retorno.setIdExercicio(result.getInt("id_exercicio"));
                retorno.setNome(result.getString("nome"));
                retorno.setGrupoMuscular(result.getString("grupo_muscular"));

                EquipamentoModel equipamento = new EquipamentoModel();
                equipamento.setId_equipamento(result.getInt("id_equipamento"));
                equipamento.setNome(result.getString("nome_equipamento"));

                retorno.setIdEquipamento(equipamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar exercício: " + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public ArrayList<ExercicioModel> selecionarTodos() {
        ArrayList<ExercicioModel> retorno = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();

        String sql = "SELECT e.id_exercicio, e.nome, e.grupo_muscular, eq.id_equipamento, eq.nome AS nome_equipamento " +
                     "FROM exercicio e JOIN equipamento eq ON e.id_equipamento = eq.id_equipamento";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();

            while (result.next()) {
                ExercicioModel e = new ExercicioModel();
                e.setIdExercicio(result.getInt("id_exercicio"));
                e.setNome(result.getString("nome"));
                e.setGrupoMuscular(result.getString("grupo_muscular"));

                EquipamentoModel equipamento = new EquipamentoModel();
                equipamento.setId_equipamento(result.getInt("id_equipamento"));
                equipamento.setNome(result.getString("nome_equipamento"));

                e.setIdEquipamento(equipamento);

                retorno.add(e);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar todos os exercícios: " + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
}
