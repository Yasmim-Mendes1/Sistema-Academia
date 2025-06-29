/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yasmim Mendes
 */
public class FichaExercicioModel {
    private FichaModel id_ficha = new FichaModel();
    private ExercicioModel id_exercicio = new ExercicioModel();
    private int series;
    private int repeticao;
    private int ordem;
    
    public FichaExercicioModel(){
        id_ficha = null;
        id_exercicio = null;
        series = 0;
        repeticao = 0;
        ordem = 0;
    }

    public FichaModel getId_ficha() {
        return id_ficha;
    }

    public void setId_ficha(FichaModel id_ficha) {
        this.id_ficha = id_ficha;
    }

    public ExercicioModel getId_exercicio() {
        return id_exercicio;
    }

    public void setId_exercicio(ExercicioModel id_exercicio) {
        this.id_exercicio = id_exercicio;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(int repeticao) {
        this.repeticao = repeticao;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
}