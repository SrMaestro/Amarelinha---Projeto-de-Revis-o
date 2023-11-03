package Amarelinha.src.main.java;

import java.util.HashMap;
import java.util.Map;

public class Main {
    // AVISO: A FUNÇÃO MAIN SEMPRE SERÁ A ÚLTIMA

    public static void teste1(){
        Map<String, Integer> teste = new HashMap<>();
        SegmentoDeViagem segmento = new SegmentoDeViagem("Porto Alegre", teste);
        SegmentoDeViagem.adicionarCarga("Celular", 300, teste);
        SegmentoDeViagem.adicionarCarga("Geladeira", 50, teste);
        SegmentoDeViagem.adicionarCarga("Playstation 5", 70, teste);
        SegmentoDeViagem.adicionarCarga("Luminaria", 2000, teste);

        Viagem viagemTeste = new Viagem(segmento);
    }

    public static void teste2(){
        DataBaseMatrices.saudacao(1,1);
    }

    public static void teste3() {Modalidades t = new Modalidades(); t.teste();}

    //Execução do código principal
    public static void main(String[] args) {


        //teste1();
        //teste2();
        teste3();
    }

}
