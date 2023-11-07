package Amarelinha.src.main.java;

import java.util.Comparator;

public class CompararCapacidade implements Comparator<ObjetoCaminhao> {
    @Override
    public int compare(ObjetoCaminhao o1, ObjetoCaminhao o2) {
        return o1.capacidade.compareTo(o2.capacidade);
    }
}
