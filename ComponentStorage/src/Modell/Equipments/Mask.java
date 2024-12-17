package Modell.Equipments;

import Modell.Equipments.Equipment;

public class Mask extends Equipment {

    private String TypeOfFixing;

    public Mask(int securityLevel, int quantity, String typeOfFixing) {
        super(securityLevel, quantity);
        TypeOfFixing = typeOfFixing;
    }

    @Override
    public String toString() {
        return "Mask{" +
                "Security Level: " + getSecurityLevel() +
                ", Quantity: " + getQuantity() +
                ", TypeOfFixing: " + TypeOfFixing +
                '}';
    }
}
