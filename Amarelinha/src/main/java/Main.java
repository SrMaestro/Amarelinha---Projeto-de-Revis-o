package Amarelinha.src.main.java;

public class Main {
    // AVISO: A FUNÇÃO MAIN SEMPRE SERÁ A ÚLTIMA

    public static int teste1(){
        int valor = CalculaDistanciaCidades.calculaDistancia("PORTO ALEGRE", "RIO BRANCO");
        return valor;

    }



    //Execução do código principal
    public static void main(String[] args) {




        System.out.println(teste1());

        CalculaDistanciaCidades.visualizarArray();
        //teste2();
        //teste3();
    }

}
