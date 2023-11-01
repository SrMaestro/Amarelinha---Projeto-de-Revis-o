package Amarelinha.src.main.java;

import java.util.HashMap;
import java.util.Map;

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
public class novaCarga {
    private final Map<String, Integer> quantidadeDeItens = new HashMap<>();

    public void adicionarCarga(String item, int quantidade){
        if (quantidade < 1){
            System.out.println("Quantidade deve ser maior que 0.");
            return;
        }

        if(tiposDeProduto.verificaExistencia(item)) {
            quantidadeDeItens.put(item, quantidade);
            System.out.println("Adicionado " + quantidade + " " + item);
        }else{
            System.out.println("Item: '"+ item +"' não existe no sistema, adicione o antes de utilizar.");
        }
    }

    public void retirarCarga(String item, int quantidade){
        if(quantidade < 1){
            System.out.println("Quantidade deve ser maior ou igual a 1");
        }

        if(!quantidadeDeItens.containsKey(item)){
            return;
        }

        int valorAtual = quantidadeDeItens.get(item);

        if(valorAtual >= quantidade){
            quantidadeDeItens.replace(item, valorAtual-quantidade);
            System.out.println("Removido " + quantidade + " " + item + " da carga. Restam: "
                    + quantidadeDeItens.get(item));
        }else{
            System.out.println("Não é possivel remover uma quantidade superior a presente na carga");
        }

        if (quantidadeDeItens.get(item) == 0) {
            quantidadeDeItens.remove(item);
        }
    }

    public double calcularPesoDaCarga(){
        if(quantidadeDeItens.isEmpty()){
            return 0;
        }

        double acumulado = 0;

        for(String i : quantidadeDeItens.keySet()){
            int quantidade = quantidadeDeItens.get(i);
            double peso = tiposDeProduto.getListaDeItens().get(i);

            acumulado += quantidade * peso;
        }

        return acumulado;
    }

    public void verificarCarga(){
        System.out.println("------------------------");
        if (quantidadeDeItens.isEmpty()){
            System.out.println("Carga vazia.");
            return;
        }else{
            for(String i : quantidadeDeItens.keySet()){
                System.out.println(i + ": " + quantidadeDeItens.get(i));
            }
        }
        System.out.println("------------------------");


    }

}