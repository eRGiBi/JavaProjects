package Modell.Products;

import Modell.Products.Product;

public class Notebook extends Product {

    private int PageNumber;

    public Notebook(int price, int quantity, int pageNumber) {
        super(price, quantity);
        PageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "Price: " + getPrice() +
                ", Quantity: " + getQuantity() +
                ", PageNumber: " + PageNumber +
                '}';
    }
}
