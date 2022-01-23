package lesson2;

public class Notebook {
    private int price;
    private int ram;
    private int index;
    private String producer;

    public Notebook(int price, int ram, int index, String producer) {
        this.price = price;
        this.ram = ram;
        this.index = index;
        this.producer = producer;
    }

    public int getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", ram=" + ram +
                ", producer='" + producer + '\'' +
                '}';
    }
}
