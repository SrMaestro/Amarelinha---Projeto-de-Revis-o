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

public class TiposDeProduto {
    static private final Map<String, Double> listaDeItens = new HashMap<>(){{
        put("CELULAR", 0.7);
        put("GELADEIRA", 50.0);
        put("AIR FRYER", 3.5);
        put("CADEIRA", 5.0);
        put("LUMINARIA", 0.8);
        put("LAVADORA DE ROUPA", 15.0);
        put("PLAYSTATION 5", 3.9);
        put("NINTENDO SWITCH", 0.3);
    }};

    public static void adicionarItem(String item, double peso){
        item = item.toUpperCase();

        if(peso > 0){
            listaDeItens.put(item, peso);
            System.out.println("Item: " + item + " adicionado ao sistema");
        }else{
            System.out.println("Peso deve ser superior a 0.");
        }
    }

    public static boolean verificaExistencia(String item){
        item = item.toUpperCase();

        return listaDeItens.containsKey(item);
    }

    public static void atualizarPeso(String item, double novoPeso){
        item = item.toUpperCase();

        if(!verificaExistencia(item)){
            System.out.println("Item: '" + item + "' nao existe.");
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