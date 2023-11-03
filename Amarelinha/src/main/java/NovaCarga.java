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
    protected static Map<String, Integer> criarCarga(){
        return new HashMap<>();
    }


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
        }else{
            for(String i : Carga.keySet()){
                System.out.println(i + ": " + Carga.get(i));
            }
        }
    }


//    public void calculaMelhorValorInicial(Map<String, Integer> Carga){
//        double pesoInicial = calcularPesoDaCarga(Carga);
//        double peso = pesoInicial;
//
//        while (peso > 0) {
//            if (peso > 8000){
//                peso -= peso >= 10000 ? 10000 : peso;
//                caminhoes.replace("Grande", caminhoes.get("Grande") + 1);
//            } else if (peso > 6000) {
//                peso -= peso >= 8000 ? 8000 : peso;
//                caminhoes.replace("Medio", caminhoes.get("Medio") + 2);
//            } else if (peso > 5000) {
//                peso -= peso >= 6000 ? 6000 : peso;
//                caminhoes.replace("Pequeno", caminhoes.get("Pequeno") + 2);
//                caminhoes.replace("Medio", caminhoes.get("Medio") + 1);
//            } else if (peso > 4000) {
//                peso -= peso >= 5000 ? 5000 : peso;
//                caminhoes.replace("Pequeno", caminhoes.get("Pequeno") + 1);
//                caminhoes.replace("Medio", caminhoes.get("Medio") + 1);
//            } else if (peso > 2000) {
//                peso -= peso >= 4000 ? 4000 : peso;
//                caminhoes.replace("Medio", caminhoes.get("Medio") + 1);
//            } else if (peso > 1000) {
//                peso -= peso >= 2000 ? 2000 : peso;
//                caminhoes.replace("Pequeno", caminhoes.get("Pequeno") + 2);
//            } else {
//                peso -= peso;
//            }
//        }
//
//        double soma = 0;
//        for(String i : caminhoes.keySet()){
//            switch (i){
//                case "Pequeno":
//                    soma += caminhoes.get(i) * 5.83;
//                    break;
//                case "Medio":
//                    soma += caminhoes.get(i) * 13.42;
//                    break;
//                case "Grande":
//                    soma += caminhoes.get(i) * 29.21;
//                default:
//                    soma += 0;
//                    break;
//            }
//        }
//        System.out.println(pesoInicial);
//        System.out.println(soma);
//    }
}