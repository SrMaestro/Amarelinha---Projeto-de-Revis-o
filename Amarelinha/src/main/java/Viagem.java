package Amarelinha.src.main.java;

import java.util.*;

public class Viagem extends NovaCarga {
    private int distanciaTotal;
    private Map<String, Integer> Carga;
    private final List<SegmentoDeViagem> segmento = new Stack<>();
    private Map<String, Integer> caminhoes = new HashMap<>();
    private final Double[][] valorPorTrecho = new Double[24][24];
    private double peso;
    private double valor;

    private void descarregar(SegmentoDeViagem segmento){

        for(String s : segmento.getCarga().keySet()){
            if (!this.Carga.containsKey(s)){
                segmento.removeCarga(s);
                System.err.println("Item nao existe na carga inicial.");
            }else if (segmento.getCarga().get(s) > this.Carga.get(s)){
                segmento.setCargaZero(s);
                System.err.println("Quantidade nao pode ser maior do que a de produtos da carga.");
            }else {
                this.Carga.replace(s, this.Carga.get(s) - segmento.getCarga().get(s));
            }
        }
    }

    private void funcaoInicio(SegmentoDeViagem inicio){
        this.Carga = inicio.getCarga();
        this.peso = NovaCarga.calcularPesoDaCarga(this.Carga);

        ObjetoCusto o = Modalidades.calculaMelhorValorInicial(this.peso);

        this.caminhoes = o.getCaminhoes();
        this.valor = o.getValor();

        inicio.setTagDeEtapa("INICIO");
        segmento.add(inicio);
    }

    private void funcaoMeio(SegmentoDeViagem meio){
        descarregar(meio);
        meio.setTagDeEtapa("MEIO");
        segmento.add(meio);
    }

    private void funcaoFim(SegmentoDeViagem fim){
        fim.setCarga(this.Carga);
        descarregar(fim);
        fim.setTagDeEtapa("FIM");
        segmento.add(fim);
    }

    public List<SegmentoDeViagem> Viagem(SegmentoDeViagem inicio, SegmentoDeViagem meio, SegmentoDeViagem fim){
        this.funcaoInicio(inicio);
        this.funcaoMeio(meio);
        this.funcaoFim(fim);

        return segmento;
    }
}
