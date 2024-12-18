package Model.Products;

public class Pencil extends Product {

    private String Color;

    public Pencil(int price, int quantity, String color) {
        super(price, quantity);
        Color = color;

    }
    @Override
    public String toString() {
        return "Pencil{" +
                "Price: " + getPrice() +
                ", Quantity: " + getQuantity() +
                ", Color:'" + Color +
                '}';
    }
}
