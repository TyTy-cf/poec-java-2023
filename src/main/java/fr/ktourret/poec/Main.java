package fr.ktourret.poec;

import fr.ktourret.poec.entity.bank.BankAccount;
import fr.ktourret.poec.entity.bank.BankAccountType;
import fr.ktourret.poec.entity.bank.Client;
import fr.ktourret.poec.entity.bank.Operation;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
//        (new Algo()).test();
//        AbstractPiece p1 = new Rook("black");
//        AbstractPiece p2 = new Knight("black");
//        AbstractPiece p3 = new Pawn("black");
//        System.out.println(p1);
//        (new Scanner()).test();
//        AbstractShape r1 = new Rectangle(20, 10);
//        AbstractShape s1 = new Square(12);
//        System.out.println(s1.calculateArea());

        Calendar cal = Calendar.getInstance();
        cal.set(1990, Calendar.JANUARY,1);
        Client client = new Client(
                "Kévin",
                "Tourret",
                "oui@oui.fr",
                cal.getTime()
        );

        BankAccount ba = new BankAccount();
        ba.setType(BankAccountType.CURRENT);
        ba.setCreatedAt(new Date());
        ba.setOwner(client);
        ba.setIban("FR7698751236987457223");
        ba.addOperation(new Operation(1500.0, "First credit", new Date()));
        ba.addOperation(new Operation(-650.0, "Pay rent", new Date()));
        ba.addOperation(new Operation(-45.0, "Groceries", new Date()));
        ba.addOperation(new Operation(-45.0, "Groceries", new Date()));
        ba.addOperation(new Operation(-45.0, "Groceries", new Date()));
        ba.addOperation(new Operation(-45.0, "Groceries", new Date()));
        ba.addOperation(new Operation(-45.0, "Groceries", new Date()));
        ba.addOperation(new Operation(-30.0, "Bar", new Date()));
        ba.addOperation(new Operation(-90.0, "Fuel", new Date()));
        ba.addOperation(new Operation(-76.0, "Insurance", new Date()));
        ba.addOperation(new Operation(-45.0, "Internet", new Date()));
        ba.addOperation(new Operation(-90.0, "Elec/Gas", new Date()));

        System.out.println(ba.getTotal());
    }

    private static double getRandomBetween(int min, int max) {
        return Math.floor((Math.random() * (max - min)) + min);
    }

}