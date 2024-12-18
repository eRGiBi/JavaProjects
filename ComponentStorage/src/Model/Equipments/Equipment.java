package Model.Equipments;

import Model.Item;

abstract public  class Equipment extends Item {

    private int SecurityLevel;

    public Equipment(int quantity, int securityLevel) {
        super(quantity);
        SecurityLevel = securityLevel;
    }

    public int getSecurityLevel() {
        return SecurityLevel;
    }
}

