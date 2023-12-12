package fr.ktourret.poec.courses.entity.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Operation {

    private double amount;

    private String label;

    private Date createdAt;

}
