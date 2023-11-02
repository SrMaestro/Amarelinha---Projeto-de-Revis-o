package Amarelinha.src.main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Modalidades {
    Double[] pequeno = new Double[]{5.83, 1000.};
    Double[] medio = new Double[]{13.42, 4000.};
    Double[] grande = new Double[]{29.21, 10000.};

    private Map<String, Double[]> caminhoes = new HashMap<>() {{
        caminhoes.put("Pequeno", pequeno);
        caminhoes.put("Medio", medio);
        caminhoes.put("Grande", grande);
    }};

    public Map<String, Double[]> getModalidades() {
        return caminhoes;
    }
}
