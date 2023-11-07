package Amarelinha.src.main.java;

import java.util.*;

public class Viagem extends NovaCarga {
    private int distanciaTotal;
    private final Map<String, Integer> Carga;
    private final List<SegmentoDeViagem> segmento = new Stack<>();
    private Map<String, Integer> caminhoes = new HashMap<>();
    private final Double[][] valorPorTrecho = new Double[24][24];
    private double peso;
    private double valor;



    public Viagem(SegmentoDeViagem inicio){
        this.Carga = inicio.Carga;
        this.peso = NovaCarga.calcularPesoDaCarga(this.Carga);

        ObjetoCusto o = Modalidades.calculaMelhorValorInicial(this.peso);

        this.caminhoes = o.getCaminhoes();
        this.valor = o.getValor();

        segmento.add(inicio);


    }

}
