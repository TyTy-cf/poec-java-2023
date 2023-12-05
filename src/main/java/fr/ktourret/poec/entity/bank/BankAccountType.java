package fr.ktourret.poec.entity.bank;

public enum BankAccountType {

    CURRENT(1.055),
    SAVING(1.072);

    private final double value;

    BankAccountType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}
