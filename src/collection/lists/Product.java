package collection.lists;

public class Product {
    private int id;
    private String name;
    private double nettoPrice;
    private double bruttoPrice;

    public Product(int id, String name, double nettoPrice, double bruttoPrice) {
        this.id = id;
        this.name = name;
        this.nettoPrice = nettoPrice;
        this.bruttoPrice = bruttoPrice;
    }

    public Product(int id, String name, double nettoPrice) {
        this.id = id;
        this.name = name;
        this.nettoPrice = nettoPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(double nettoPrice) {
        this.nettoPrice = nettoPrice;
    }

    public double getBruttoPrice() {
        return bruttoPrice;
    }

    public void setBruttoPrice(double bruttoPrice) {
        this.bruttoPrice = bruttoPrice;
    }

    @Override
    public String toString() {
        return id +
                ", " + name + ", " + nettoPrice +
                ", " + bruttoPrice;
    }


}
