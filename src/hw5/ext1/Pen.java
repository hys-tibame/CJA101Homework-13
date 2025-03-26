package hw5.ext1;

public abstract class Pen {

    private String brand;
    private int price;

    public Pen() {
    }

    public Pen(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract void write();

}

class Pencil extends Pen{

    public Pencil() {
    }

    public Pencil(String brand, int price) {
        super(brand, price);
    }

    @Override
    public void write() {
        System.out.println("Pencil: ");
        System.out.println("削鉛筆再寫");
    }

    @Override
    public int getPrice() {
        return (int)(super.getPrice() * 0.8);
    }
}

class InkBrush extends Pen {

    public InkBrush() {
    }

    public InkBrush(String brand, int price) {
        super(brand, price);
    }

    @Override
    public void write() {
        System.out.println("InkBrush: ");
        System.out.println("沾墨汁再寫");
    }

    @Override
    public int getPrice() {
        return (int)(super.getPrice() * 0.9);
    }
}

