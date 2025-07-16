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
import model.FichaExercicioModel;
import model.ExercicioModel;
import model.FichaModel;
import util.Conexao;

public class FichaExercicioController {
    
    
    public boolean inserir(FichaExercicioModel ficha_exercicio){
        boolean retorno =false;
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "INSERT INTO ficha_exercicio (id_ficha, id_exercicio, serie, repeticao, ordem) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, ficha_exercicio.getFicha().getId_ficha());
            sentenca.setInt(2, ficha_exercicio.getExercicio().getIdExercicio());
            sentenca.setInt(3, ficha_exercicio.getSeries());
            sentenca.setInt(4, ficha_exercicio.getRepeticao());
            sentenca.setInt(5, ficha_exercicio.getOrdem());
            
            if(!sentenca.execute()){
                retorno = true;
            }
        } catch (SQLException e){
            System.out.println("Erro ao inserir treino: " + e.getMessage());
        }
        
        c.desconectar();
        return retorno;
    }
    
    public boolean editar(FichaExercicioModel ficha_exercicio) {
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();

        String sql = "UPDATE ficha_exercicio SET ordem = ?, series = ?, repeticao = ? WHERE id_ficha = ? AND id_exercicio = ?";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);

            sentenca.setInt(1, ficha_exercicio.getOrdem());
            sentenca.setInt(2, ficha_exercicio.getSeries());
            sentenca.setInt(3, ficha_exercicio.getRepeticao());

            sentenca.setInt(4, ficha_exercicio.getFicha().getId_ficha());
            sentenca.setInt(5, ficha_exercicio.getExercicio().getIdExercicio());

            int linhasAfetadas = sentenca.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao editar o treino: " + e.getMessage());
        } finally {
            c.desconectar();
        }
        return retorno;
    }
    
    public boolean excluir(FichaExercicioModel ficha_exercicio){
        boolean retorno = false;
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "DELETE FROM ficha_exercicio WHERE id_ficha = ? AND id_exercicio = ?";
        
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, ficha_exercicio.getFicha().getId_ficha());
            sentenca.setInt(2, ficha_exercicio.getExercicio().getIdExercicio());
            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar treino! " + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public FichaExercicioModel selecionar(FichaExercicioModel ficha_exercicio){
        FichaExercicioModel retorno = null;
        Conexao c = new Conexao();
        c.conectar();
                
        String sql = "SELECT fe.series, fe.ordem, fe.repeticao, "
                + "f.id_ficha, f.objetivo, f.data_criacao, " 
                + "e.id_exercicio, e.nome AS nome_exercicio, " 
                + "FROM ficha_exercicio fe " 
                + "JOIN ficha f ON fe.id_ficha = f.id_ficha "
                + "JOIN exercicio e ON fe.id_exercicio = e.id_exercicio"
                + "WHERE fe.id_ficha = ? AND fe.id_exercicio = ?";
        
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, ficha_exercicio.getFicha().getId_ficha());
            sentenca.setInt(2, ficha_exercicio.getExercicio().getIdExercicio());
            ResultSet result = sentenca.executeQuery();

            if (result.next()) {
                retorno = new FichaExercicioModel();

                retorno.setSeries(result.getInt("serie"));
                retorno.setRepeticao(result.getInt("repeticao"));
                retorno.setOrdem(result.getInt("ordem"));

                FichaModel ficha = new FichaModel();
                ficha.setId_ficha(result.getInt("id_ficha"));
                ficha.setObjetivo(result.getString("objetivo"));
                ficha.setData_criacao(result.getTimestamp("data_criacao"));
                retorno.setFicha(ficha);

                ExercicioModel exercicio = new ExercicioModel();
                exercicio.setIdExercicio(result.getInt("id_exercicio"));
                exercicio.setNome(result.getString("nome_exercicio"));
                retorno.setExercicio(exercicio);
            }
        } catch (SQLException e) {
            System.out.println("Erro na seleção da ficha_exercicio: " + e.getMessage());
        }

        c.desconectar();
        return retorno;
    }
    
    public ArrayList<FichaExercicioModel> selecionarTodos() {
        ArrayList<FichaExercicioModel> lista = new ArrayList<>();
        Conexao c = new Conexao();
        c.conectar();

        String sql = "SELECT fe.id_ficha, fe.id_exercicio, fe.series, fe.repeticao, fe.ordem, "
                   + "f.objetivo, f.data_criacao, "
                   + "e.nome AS nome_exercicio, e.grupo_muscular, e.id_equipamento "
                   + "FROM ficha_exercicio fe "
                   + "JOIN ficha f ON fe.id_ficha = f.id_ficha "
                   + "JOIN exercicio e ON fe.id_exercicio = e.id_exercicio";

        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();

            while (rs.next()) {
                FichaExercicioModel fe = new FichaExercicioModel();

                FichaModel ficha = new FichaModel();
                ficha.setId_ficha(rs.getInt("id_ficha"));
                ficha.setObjetivo(rs.getString("objetivo"));
                ficha.setData_criacao(rs.getTimestamp("data_criacao"));
                fe.setFicha(ficha);

                ExercicioModel exercicio = new ExercicioModel();
                exercicio.setIdExercicio(rs.getInt("id_exercicio"));
                exercicio.setNome(rs.getString("nome_exercicio"));
                exercicio.setGrupoMuscular(rs.getString("grupo_muscular"));

                fe.setExercicio(exercicio);

                fe.setSeries(rs.getInt("series"));
                fe.setRepeticao(rs.getInt("repeticao"));
                fe.setOrdem(rs.getInt("ordem"));

                lista.add(fe);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar todos os ficha_exercicio: " + e.getMessage());
        } finally {
            c.desconectar();
        }
        return lista;
    }
}
