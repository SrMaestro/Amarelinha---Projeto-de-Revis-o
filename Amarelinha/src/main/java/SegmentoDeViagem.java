package Amarelinha.src.main.java;

import java.util.Map;

public class SegmentoDeViagem extends NovaCarga {
    public String cidade;
    public Map<String, Integer> Carga;

    public SegmentoDeViagem(String cidade, Map<String, Integer> Carga){
        this.cidade = cidade;
        this.Carga = Carga;
    }
}
