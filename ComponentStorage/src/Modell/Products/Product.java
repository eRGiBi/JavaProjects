package Modell.Products;

import Modell.Item;

abstract public class Product extends Item {

    private int Price;

    public Product(int quantity, int price) {
        super(quantity);
        Price = price;
    }

    public int getPrice() {
        return Price;
    }

}
