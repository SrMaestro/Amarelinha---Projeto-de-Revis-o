package Amarelinha.src.main.java;

import java.util.*;

public class Viagem extends NovaCarga {
    private int distanciaTotal;
    private Map<String, Integer> Carga;
    private List<SegmentoDeViagem> segmento = new Stack<>();
    private final Map<String, Integer> caminhoes = new HashMap<>();
    {
        caminhoes.put("Pequeno", 0);
        caminhoes.put("Medio", 0);
        caminhoes.put("Grande", 0);
    }
    private final Double[][] valorPorTrecho = new Double[24][24];
    private double peso;


    public Viagem(SegmentoDeViagem inicio){
        this.Carga = inicio.Carga;
        this.peso = NovaCarga.calcularPesoDaCarga(this.Carga);
        segmento.add(inicio);
    }

}
