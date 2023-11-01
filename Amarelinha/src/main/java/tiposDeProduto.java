package Amarelinha.src.main.java;

import java.util.HashMap;
import java.util.Map;

/*
    Classe responsável por gerenciar os produtos existentes no sistema, e suas informações(peso).

    A lista já consta com alguns itens por padrão.

    ** Métodos como 'getListaDeItens' e 'verificaExistencia' são uteis somente para funcionalidade BackEnd

    * adicionarItem adiciona um produto à lista, e recebe 'String nome' e 'int peso' como parametros.
    * atualizarPeso atualiza o peso de um PRODUTO EXISTENTE, e recebe 'String nomeDoItem' e 'int novoPeso' como parametros.

 */

public class tiposDeProduto {
    static private final Map<String, Double> listaDeItens = new HashMap<>(){{
        put("Celular", 0.7);
        put("Geladeira", 50.0);
        put("Air Fryer", 3.5);
        put("Cadeira", 5.0);
        put("Luminaria", 0.8);
        put("Lavadora de roupa", 15.0);
        put("PlayStation 5", 3.9);
        put("Nintendo Switch", 0.3);
    }};

    public static void adicionarItem(String item, double peso){
        if(peso > 0){
            listaDeItens.put(item, peso);
            System.out.println("Item: " + item + " adicionado ao sistema");
        }else{
            System.out.println("Peso deve ser superior a 0.");
        }
    }

    public static boolean verificaExistencia(String item){
        return listaDeItens.containsKey(item);
    }

    public static void atualizarPeso(String item, double novoPeso){
        if(!verificaExistencia(item)){
            System.out.println("Item nao existe.");
            return;
        }

        if(novoPeso <= 0){
            System.out.println("Peso deve ser superior a 0.");
            return;
        }

        listaDeItens.replace(item, novoPeso);
    }

    public static Map<String, Double> getListaDeItens() {
        return listaDeItens;
    }
}