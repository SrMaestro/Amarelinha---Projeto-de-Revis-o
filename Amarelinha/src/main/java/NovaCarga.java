package Amarelinha.src.main.java;

import java.util.*;

/* Classe responsável por realizar o gerenciamento da carga nos caminhões:

     * Mantém a contagem de cada produto específico para cada entrega;
     * Permite adicionar items a uma carga por meio do método adicionarCarga();
     * Permite remover items de uma carga por meio do método retirarCarga();
     * Permite ver o peso total da carga por meio do método calcularPesoDaCarga();

    Os métodos adicionar e retirar Carga, recebem os argumentos "Tipo de item", que deve
   ser um item que consta na lista tipos de produto, e que está presente no caminhão, para
   cada método respectivamente... O segundo argumento é a quantidade de um mesmo item envolvidos
   na ação;

    Método calcularPesoDaCarga imprime o peso total da carga;
    Método verificarCarga imprime todos os items e suas quantidades presentes.
   */
abstract class NovaCarga {
    protected static void adicionarCarga(String item, int quantidade, Map<String, Integer> Carga){
        item = item.toUpperCase();

        if (quantidade < 1){
            System.err.println("Quantidade deve ser maior que 0.");
            return;
        }

        if(TiposDeProduto.verificaExistencia(item)) {
            Carga.put(item, quantidade);
        }else{
            System.err.println("Item: '"+ item +"' não existe no sistema, adicione o antes de utilizar.");
        }
    }



    protected static void retirarCarga(String item, int quantidade, Map<String, Integer> Carga){
        item = item.toUpperCase();

        if(quantidade < 1){
            System.err.println("Quantidade deve ser maior ou igual a 1");
        }

        if(!Carga.containsKey(item)){
            System.err.println("Item: '" + item + "' nao existe na carga");
            return;
        }

        int valorAtual = Carga.get(item);

        if(valorAtual >= quantidade){
            Carga.replace(item, valorAtual-quantidade);
            System.out.println("Removido " + quantidade + " " + item + " da carga. Restam: "
                    + Carga.get(item));
        }else{
            System.err.println("Não é possivel remover uma quantidade superior a presente na carga");
        }

        if (Carga.get(item) == 0) {
            Carga.remove(item);
        }
    }



    protected static double calcularPesoDaCarga(Map<String, Integer> Carga){
        if(Carga.isEmpty()){
            return 0;
        }

        double acumulado = 0;

        for(String i : Carga.keySet()){
            int quantidade = Carga.get(i);
            double peso = TiposDeProduto.getListaDeItens().get(i);

            acumulado += quantidade * peso;
        }

        return acumulado;
    }



    protected static void verificarCarga(Map<String, Integer> Carga){
        if (Carga.isEmpty()){
            System.out.println("Carga vazia.");
            return;
        }else{
            for(String i : Carga.keySet()){
                System.out.println(i + ": " + Carga.get(i));
            }
        }
    }

}