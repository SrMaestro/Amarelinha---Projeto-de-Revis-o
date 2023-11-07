package Amarelinha.src.main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsultarTrechoEModalidade {

    public static void consulta(String cidade1, String cidade2, String modalidade) {


        class ConsultaTrechos {

            static Map<String, Integer> trechos = new HashMap<>();
            static Map<String, Double> custos = new HashMap<>();

            public static double calcularCusto(int distancia, String tipoCaminhao) {
                return distancia * custos.get(tipoCaminhao);


            }

            public static void consultarTrecho(String origem, String destino, String tipoCaminhao) {
                String trecho = origem.toUpperCase() + "-" + destino.toUpperCase();
                if (trechos.containsKey(trecho)) {
                    int distancia = trechos.get(trecho);
                    double custo = calcularCusto(distancia, tipoCaminhao);
                    System.out.println("A distância entre " + origem + " e " + destino + " é de " + distancia + " km.");
                    System.out.println("O custo estimado para o trecho é de R$ " + String.format("%.2f", custo));
                } else {
                    System.out.println("Um dos trechos informados não está disponível.");
                }
            }

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Informe a cidade de origem: ");
                String origem = scanner.nextLine();

                System.out.print("Informe a cidade de destino: ");
                String destino = scanner.nextLine();

                System.out.print("Informe o tipo de caminhão (pequeno, medio, grande): ");
                String tipoCaminhao = scanner.nextLine().toLowerCase();

                consultarTrecho(origem, destino, tipoCaminhao);
            }
        }
    }
}
