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

    public void calculaMelhorValorInicial(){
        double peso = this.peso;

        while (peso > 0) {
            if (peso > 8000){
                peso -= peso >= 10000 ? 10000 : peso;
                caminhoes.replace("Grande", caminhoes.get("Grande") + 1);
            } else if (peso > 6000) {
                peso -= peso >= 8000 ? 8000 : peso;
                caminhoes.replace("Medio", caminhoes.get("Medio") + 2);
            } else if (peso > 5000) {
                peso -= peso >= 6000 ? 6000 : peso;
                caminhoes.replace("Pequeno", caminhoes.get("Pequeno") + 2);
                caminhoes.replace("Medio", caminhoes.get("Medio") + 1);
            } else if (peso > 4000) {
                peso -= peso >= 5000 ? 5000 : peso;
                caminhoes.replace("Pequeno", caminhoes.get("Pequeno") + 1);
                caminhoes.replace("Medio", caminhoes.get("Medio") + 1);
            } else if (peso > 2000) {
                peso -= peso >= 4000 ? 4000 : peso;
                caminhoes.replace("Medio", caminhoes.get("Medio") + 1);
            } else if (peso > 1000) {
                peso -= peso >= 2000 ? 2000 : peso;
                caminhoes.replace("Pequeno", caminhoes.get("Pequeno") + 2);
            } else {
                peso -= peso;
            }
        }

        double soma = 0;
        for(String i : caminhoes.keySet()){
            switch (i){
                case "Pequeno":
                    soma += caminhoes.get(i) * 5.83;
                    break;
                case "Medio":
                    soma += caminhoes.get(i) * 13.42;
                    break;
                case "Grande":
                    soma += caminhoes.get(i) * 29.21;
                default:
                    soma += 0;
                    break;
            }
        }
        System.out.println(this.peso);
        System.out.println(soma);
    }

    public Viagem(SegmentoDeViagem inicio){
        this.Carga = inicio.Carga;
        this.peso = NovaCarga.calcularPesoDaCarga(this.Carga);
        segmento.add(inicio);
    }




}
