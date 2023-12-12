package fr.ktourret.poec.courses.entity.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BankAccountType {

    CURRENT(1.055, "Current"),
    SAVING(1.072, "Saving");

    private final double value;

    private final String type;

    @Override
    public String toString() {
        return getType() + " : " + getValue();
    }
}
