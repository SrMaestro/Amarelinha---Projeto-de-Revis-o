package Amarelinha.src.main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CalculaDistanciaCidades {
    private static final List<List<String>> records = new ArrayList<>();

    static {
        String path = "Amarelinha/src/main/java/DistanciasCidadesCSV.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            //Define variavel temporaria para o while
            String line;
            while ((line = br.readLine()) != null) {
                //Divide cada um dos strings recebidos do 'line', em Strings individuais
                String[] values = line.split(";");

                //Coloca cada um dos valores já separados recebidos, em um novo array
                records.add(Arrays.asList(values));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public static int calculaDistancia (String cidade1, String cidade2){
        int index = records.get(0).indexOf(cidade1);
        int index2 = records.get(0).indexOf(cidade2);

        return Integer.parseInt(records.get(index+1).get(index2));
    }

    public static void visualizarArray(){
        for (List<String> i : records){
            System.out.println(i);
        }
    }
}
