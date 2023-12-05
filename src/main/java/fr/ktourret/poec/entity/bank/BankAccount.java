package fr.ktourret.poec.entity.bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {

    private String iban;

    private Client owner;

    private BankAccountType type;

    private Date createdAt;

    private List<Operation> operationList;

    public BankAccount() {
        operationList = new ArrayList<>();
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public BankAccountType getType() {
        return type;
    }

    public void setType(BankAccountType type) {
        this.type = type;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void addOperation(Operation operation) {
        this.operationList.add(operation);
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < operationList.size(); i++) {
            Operation ope = operationList.get(i); // operations[i]
            total += ope.getAmount();
        }
        return total;
    }

    public String getClientInfos() {
        return owner.getLastName().toUpperCase() + " " + owner.getFirstName();
    }
}
