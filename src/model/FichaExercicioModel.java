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
    private FichaModel ficha = new FichaModel();
    private ExercicioModel exercicio = new ExercicioModel();
    private int series;
    private int repeticao;
    private int ordem;
    
    public FichaExercicioModel(){
        ficha = null;
        exercicio = null;
        series = 0;
        repeticao = 0;
        ordem = 0;
    }

    public FichaModel getFicha() {
        return ficha;
    }

    public void setFicha(FichaModel ficha) {
        this.ficha = ficha;
    }

    public ExercicioModel getExercicio() {
        return exercicio;
    }

    public void setExercicio(ExercicioModel exercicio) {
        this.exercicio = exercicio;
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