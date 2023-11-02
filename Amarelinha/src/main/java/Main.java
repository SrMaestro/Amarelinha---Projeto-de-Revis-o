package Amarelinha.src.main.java;

public class Main {
    // AVISO: A FUNÇÃO MAIN SEMPRE SERÁ A ÚLTIMA

    public static void teste1(){
        /*
        AVISO: ESTE TESTE NÃO COBRE ERROS DE TIPO (ex passar uma 'String' ao invez de 'int'

        Teste básico para todas os métodos implementados nas classes tiposDeProduto e novaCarga.
         */

        NovaCarga carga1 = new NovaCarga();

        carga1.verificarCarga();

        carga1.adicionarCarga("Geladeira", 20);
        carga1.adicionarCarga("Lavadora de roupa", 123);
        carga1.adicionarCarga("Banana", 10); //Item não existe na lista
        carga1.adicionarCarga("PlayStation 5", 0); //Quantidade inferior a 1

        carga1.retirarCarga("Lavadora de roupa", 23);
        carga1.retirarCarga("Geladeira", 5);
        carga1.retirarCarga("Erva mate", 10); //Item não existe no caminhão/lista
        carga1.retirarCarga("PlayStation 5", -2); //Quantidade negativa


        TiposDeProduto.adicionarItem("Banana", 0.1);
        carga1.adicionarCarga("Banana", 50);

        TiposDeProduto.atualizarPeso("Banana", 10);

        carga1.verificarCarga();
        System.out.println("Peso total: " + carga1.calcularPesoDaCarga());
    }

    public static void teste2(){
        DataBaseMatrices.saudacao(1,1);
    }

    public static void main(String[] args) {
        //Execução do código principal

        teste1();
        //teste2();
    }

}
