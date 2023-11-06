package Amarelinha.src.main.java;

import java.util.ArrayList;
import java.util.List;

public class Modalidades {
    private final ObjetoCaminhao Pequeno = new ObjetoCaminhao("Pequeno", 5.83, 1000);
    private final ObjetoCaminhao Gigante = new ObjetoCaminhao("Gigante", 62.8, 25000);
    private final ObjetoCaminhao Medio = new ObjetoCaminhao("Medio", 13.42, 4000);
    private final ObjetoCaminhao Grande = new ObjetoCaminhao("Grande", 29.21, 10000);
    public static double
    getValorKm(String tipoCaminhao){
        double modalidades = 0;
        return modalidades ;
    }
    private final List<ObjetoCaminhao> tiposDeCaminhao = new ArrayList<>();
    {
        tiposDeCaminhao.add(Pequeno);
        tiposDeCaminhao.add(Gigante);
        tiposDeCaminhao.add(Medio);
        tiposDeCaminhao.add(Grande);

        tiposDeCaminhao.sort(new CompararCapacidade());
    }

    public void teste(){
        for (ObjetoCaminhao i : tiposDeCaminhao){
            System.out.println(i.tipo);
        }
    }

    public void calculaMelhorValorKM(int peso){
        List<ObjetoCaminhao> tipos = this.tiposDeCaminhao;

        //Se valorAtual > capacidade, utilizar outro caminhao;
        //Se valor
    }



}
