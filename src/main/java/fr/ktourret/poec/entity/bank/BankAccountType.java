package fr.ktourret.poec.entity.bank;

public enum BankAccountType {

    CURRENT(1.055, "Current"),
    SAVING(1.072, "Saving");

    private final double value;

    private final String type;

    BankAccountType(double value, String type) {
        this.value = value;
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return getType() + " : " + getValue();
    }
}
