import java.io.Serializable;

public class Cidades implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Double price;
    private Integer quantity;

    public void Product() {
    }

    public Cidades(String name, Double price, Integer quantity) {
        super();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

     }
