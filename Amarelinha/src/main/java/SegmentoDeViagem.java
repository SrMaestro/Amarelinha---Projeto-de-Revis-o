package Amarelinha.src.main.java;

import java.util.Map;

public class SegmentoDeViagem extends NovaCarga {
    private final String cidade;
    private Map<String, Integer> Carga;
    private String TagDeEtapa;


    public SegmentoDeViagem(String cidade, Map<String, Integer> Carga){
        this.cidade = cidade;
        this.Carga = Carga;
    }

    public String getCidade() {
        return cidade;
    }

    public Map<String, Integer> getCarga() {
        return Carga;
    }

    public void setCargaZero(String item){
        this.Carga.replace(item, 0);
    }

    public void setCarga(Map<String, Integer> Carga){
        this.Carga = Carga;
    }

    public void removeCarga(String item){
        this.Carga.remove(item);
    }

    public void setTagDeEtapa(String tagDeEtapa) {
        this.TagDeEtapa = tagDeEtapa;
    }
}
