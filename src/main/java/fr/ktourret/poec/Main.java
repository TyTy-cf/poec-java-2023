package fr.ktourret.poec;

import fr.ktourret.poec.entity.bank.*;
import fr.ktourret.poec.entity.chess.*;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
//        (new Algo()).test();
        AbstractPiece p1 = new Rook(Color.BLACK);
        AbstractPiece p2 = new Knight(Color.BLACK);
        AbstractPiece p3 = new Pawn(Color.BLACK);
        AbstractPiece p4 = new Pawn(Color.BLACK);

        Cell cell = new Cell(1, 'a');
        cell.setColor(Color.WHITE);

//        System.out.println(p3.equals(p4));
//        System.out.println(p2.getId());
//        System.out.println(p3.getId());
//        System.out.println(p4.getId());
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

//        ChessArrayList<Rook> operations = new ChessArrayList<>();
//        System.out.println(operations);
//        System.out.println(ba.getType());
    }

    private static double getRandomBetween(int min, int max) {
        return Math.floor((Math.random() * (max - min)) + min);
    }

}