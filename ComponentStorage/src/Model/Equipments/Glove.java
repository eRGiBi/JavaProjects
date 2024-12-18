package Model.Equipments;

public class Glove extends Equipment {

    private String Size;

    public Glove(int securityLevel, int quantity, String size) {
        super(securityLevel, quantity);
        Size = size;
    }

    @Override
    public String toString() {
        return "Glove{" +
                "Security Level: " + getSecurityLevel() +
                ", Quantity: " + getQuantity() +
                ", Size:" + Size +
                '}';
    }
}
