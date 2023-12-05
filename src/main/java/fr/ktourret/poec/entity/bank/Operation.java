package fr.ktourret.poec.entity.bank;

import java.util.Date;

public class Operation {

    private double amount;

    private String label;

    private Date createdAt;

    public Operation(double amount, String label, Date createdAt) {
        this.amount = amount;
        this.label = label;
        this.createdAt = createdAt;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
