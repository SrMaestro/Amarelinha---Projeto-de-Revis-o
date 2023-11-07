package Amarelinha.src.main.java;

public class ObjetoCaminhao {
    String tipo = null;
    Double precoKm = null;
    Integer capacidade = null;

    protected ObjetoCaminhao(String tipo, Double precoKm, Integer capacidade){
        this.tipo = tipo;
        this.precoKm = precoKm;
        this.capacidade = capacidade;
    }
}