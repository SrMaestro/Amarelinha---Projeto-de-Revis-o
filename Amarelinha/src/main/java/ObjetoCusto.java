package Amarelinha.src.main.java;
import java.util.Map;
public class ObjetoCusto {
    private Map<String, Integer> caminhoes;
    private double valor;

    public ObjetoCusto(Map<String, Integer> caminhoes, double valor){
        this.caminhoes = caminhoes;
        this.valor = valor;
    }

    public Map<String, Integer> getCaminhoes() {
        return caminhoes;
    }

    public double getValor() {
        return valor;
    }
}
