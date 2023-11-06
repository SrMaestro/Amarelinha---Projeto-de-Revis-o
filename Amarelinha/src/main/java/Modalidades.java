package Amarelinha.src.main.java;

import java.lang.reflect.Array;
import java.util.*;

public class Modalidades {
    private static final ObjetoCaminhao Pequeno = new ObjetoCaminhao("Pequeno", 5.83, 1000);
    private static final ObjetoCaminhao Gigante = new ObjetoCaminhao("Gigante", 62.8, 25000);
    private static final ObjetoCaminhao Medio = new ObjetoCaminhao("Medio", 13.42, 4000);
    private static final ObjetoCaminhao Grande = new ObjetoCaminhao("Grande", 29.21, 10000);

    private static final List<ObjetoCaminhao> tiposDeCaminhao = new ArrayList<>();

    {
        tiposDeCaminhao.add(Pequeno);
        tiposDeCaminhao.add(Gigante);
        tiposDeCaminhao.add(Medio);
        tiposDeCaminhao.add(Grande);

        tiposDeCaminhao.sort(new CompararCapacidade());
    }


    public static void teste(){
        for (ObjetoCaminhao i : tiposDeCaminhao){
            System.out.println(i.tipo);
        }
    }

    public static double getCustoCaminhao(String tipoDeCaminhao){
        for(ObjetoCaminhao o : tiposDeCaminhao){
            if (Objects.equals(o.tipo, tipoDeCaminhao)){
                return o.precoKm;
            }
        }
        return -1;
    }

    public static ObjetoCusto calculaMelhorValorInicial(Double pesoInicial){
        Map<String, Integer> caminhoes = new HashMap<>();
        {
            caminhoes.put("Pequeno", 0);
            caminhoes.put("Medio", 0);
            caminhoes.put("Grande", 0);
        }
        double peso = pesoInicial;
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
        System.out.println(pesoInicial);
        System.out.println(soma);

        return new ObjetoCusto(caminhoes, soma);

    }



}
