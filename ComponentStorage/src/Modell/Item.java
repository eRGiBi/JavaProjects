package Modell;

abstract public class Item {

    private int Quantity;

    public Item(int quantity) {
        Quantity = quantity;
    }

    public int getQuantity() {
        return Quantity;
    }
}
