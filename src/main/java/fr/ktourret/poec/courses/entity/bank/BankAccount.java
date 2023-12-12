package fr.ktourret.poec.courses.entity.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankAccount {

    private String iban;

    private Client owner;

    private BankAccountType type;

    private Date createdAt;

    private List<Operation> operationList = new ArrayList<>();

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
